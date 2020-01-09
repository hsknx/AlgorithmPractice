package DataStructure.line.array.twoDimensionalArray.twoDimensionalArrayApply;

import Logic.check.MatrixCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-09 22:22
 * @author—Email:liujunfirst@outlook.com
 * @description: 顺时针螺旋矩阵
 */
public class ClockwiseSpiralMatrix {

    public int[] print(int[][] matrix) {

        if (!MatrixCheck.judgeisRectangle(matrix)) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();
        //左上角(a, b),右下角(c, d)
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        int[] target = new int[(c+1)*(d+1)];
        while (a <= c && b <= d) {
            //最外层一圈打印
            //特殊情况：单独行、单独列
            if (a == c) {
                for (int i = b; i <= d; i++) {
                    list.add(matrix[a][i]);
                }
            }else if (b == d) {
                for (int i = a; i <= c; i++) {
                    list.add(matrix[i][b]);
                }
            }else {
                //四个循环，分别是从左到右，从上到下，到右到左，从下到上
                for (int i = b; i < d; i++) {
                    list.add(matrix[a][i]);
                }
                for (int i = a; i < c; i++) {
                    list.add(matrix[i][d]);
                }
                for (int i = d; i > b; i--) {
                    list.add(matrix[c][i]);
                }
                for (int i = c; i > a; i--) {
                    list.add(matrix[i][b]);
                }
            }
            //缩小一层
            a++;
            b++;
            c--;
            d--;
        }
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        //target = list.toArray(new int[0]);
        return target;
    }
}