package DataStructure.line.array.twoDimensionalArray.apply;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-05 02:12
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class LargestSquare {

    public int LargestSquareSolution(int[][] Matrix) {
        //校验矩阵

        //计算只包含 1 的最大正方形，并返回其面积
        int MaxValue = 0;

        return MaxValue * MaxValue;
    }


    //暴力求解法
    public int violenceMethod(int[][] Matrix) {

        int MaxSideLength = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if (Matrix[i][j] != 0) {
                    int num = getMaxSideLengthScanner(Matrix, 1, 1);
                }
            }
        }


        return MaxSideLength;
    }

    //动态规划法
    public int dynamicMethod(int[][] Matrix) {

        int MaxSideLength = 0;

        return MaxSideLength;
    }

    //动态规划优化
    public int dynamicOptMethod(int[][] Matrix) {

        int MaxSideLength = 0;

        return MaxSideLength;
    }

    //暴力循环扫描法（含冗余扫描）
    public int getMaxSideLengthViolence(int[][] Matrix, int rawposition, int columnposition) {

        if(Matrix == null){
            return 0;
        }
        int MaxLength = 0;
        boolean flag = true;
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        if(rawposition > raw_bound || columnposition > column_bound){
            return 0;
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
    public int getMaxSideLengthScanner(int[][] Matrix, int rawline, int columnline) {

        int MaxLength = 0;
        return MaxLength;

    }

    //最大长度限制法
    public int getMaxSideLengthLimit(int[][] Matrix, int rawline, int columnline) {

        int MaxLength = 0;
        return MaxLength;
    }
}
