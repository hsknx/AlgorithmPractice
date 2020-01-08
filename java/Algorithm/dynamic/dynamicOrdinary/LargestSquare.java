package Algorithm.dynamic.dynamicOrdinary;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-05 02:12
 * @author—Email:liujunfirst@outlook.com
 * @description:
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 解法一：暴力法
 *        1.1）暴力循环扫描法（含冗余扫描）
 *        1.2）逐层扫描法
 *        1.3）最大长度限制法
 * 解法二：动态规划法
 * 解法三：动态规划优化
 */
public class LargestSquare {

    //暴力求解法
    public int violenceSolution(int[][] Matrix) {

        //校验矩阵：空值问题
        if(Matrix == null){
            return -1;
        }
        //校验矩阵：仅含0,1,否则输出-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if (Matrix[i][j] != 0) {
                    //逐层扫描法
                    int num = getMaxSideLengthScanner(Matrix, i, j);
                    MaxSideLength = MaxSideLength > num ? MaxSideLength : num;
                }
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //动态规划法
    public int dynamicSolution(int[][] Matrix) {

        //校验矩阵：空值问题
        if(Matrix == null){
            return -1;
        }
        //校验矩阵：仅含0,1,否则输出-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        //状态矩阵
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        int[][] statusMatrix = new int[raw_bound + 1][column_bound + 1];

        for (int i = 1; i <= raw_bound; i++) {
            for (int j = 1; j <= column_bound; j++) {
                if(Matrix[i-1][j-1] == 1){
                    statusMatrix[i][j] = Math.min(Math.min(statusMatrix[i-1][j-1], statusMatrix[i-1][j]), statusMatrix[i][j-1]) + 1;
                    MaxSideLength = MaxSideLength > statusMatrix[i][j] ? MaxSideLength : statusMatrix[i][j];
                }
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //动态规划优化
    public int dynamicOptSolution(int[][] Matrix) {

        //校验矩阵：空值问题
        if(Matrix == null){
            return -1;
        }
        //校验矩阵：仅含0,1,否则输出-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        //状态矩阵
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        int[] statusMatrix = new int[column_bound + 1];
        int pre = 0;
        int now ;

        for (int i = 1; i <= raw_bound; i++) {
            for (int j = 1; j <= column_bound; j++) {
                now = statusMatrix[j];
                if(Matrix[i-1][j-1] == 1){
                    statusMatrix[j] = Math.min(Math.min(now, pre), statusMatrix[j-1]) + 1;
                    MaxSideLength = MaxSideLength > statusMatrix[j] ? MaxSideLength : statusMatrix[j];
                }else{
                    statusMatrix[j] = 0;
                }
                pre = now;
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //暴力循环扫描法（含冗余扫描）
    public int getMaxSideLengthViolence(int[][] Matrix, int rawposition, int columnposition) {

        //空值问题
        if(Matrix == null){
            return -1;
        }
        int MaxLength = 0;
        boolean flag = true;
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //越界问题
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }
        while(flag && ((rawposition + MaxLength) < raw_bound) && ((columnposition + MaxLength) < column_bound)){
            MaxLength++;
            for (int i = 0; i <= MaxLength; i++) {
                for (int j = 0; j <= MaxLength; j++) {
                    if (Matrix[rawposition + i][columnposition + j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag == false){
                    break;
                }
            }
        }
        return MaxLength--;
    }

    //逐层扫描法
    public int getMaxSideLengthScanner(int[][] Matrix, int rawposition, int columnposition) {

        //空值问题
        if(Matrix == null){
            return -1;
        }
        int MaxLength = 1;
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //越界问题
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }
        while((MaxLength + rawposition < raw_bound) && (MaxLength + columnposition < column_bound)){
            //扫描列
            for (int i = columnposition; i <= columnposition + MaxLength; i++) {
                if(Matrix[rawposition + MaxLength][i] == 0){
                    return MaxLength--;
                }
            }
            //扫描行
            for (int j = rawposition; j <= rawposition + MaxLength; j++) {
                if(Matrix[j][columnposition + MaxLength] == 0){
                    return MaxLength--;
                }
            }
            MaxLength++;
        }
        return MaxLength--;
    }

    //最大长度限制法
    public int getMaxSideLengthLimit(int[][] Matrix, int rawposition, int columnposition) {

        //空值问题
        if(Matrix == null){
            return -1;
        }
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //最大增长长度,选择最小值
        int MaxColumnLength = column_bound - columnposition;
        int MaxRawLength = raw_bound - rawposition;
        int MaxLength = MaxColumnLength > MaxRawLength ? MaxRawLength : MaxColumnLength;
        //越界问题
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }

        //逐层扫描行
        for (int i = rawposition; i < MaxLength + rawposition; i++) {
            //行不变，扫描列
            for (int j = columnposition; j < MaxLength + columnposition; j++) {
                if (Matrix[i][j] == 0){
                    MaxColumnLength = j - columnposition;
                    break;
                }
            }
            //如果出现行增量 大于等于 列增量 说明正方形结束
            MaxRawLength = i - rawposition;
            if(MaxRawLength >= MaxColumnLength){
                return MaxRawLength;
            }
        }
        return MaxLength;
    }
}
