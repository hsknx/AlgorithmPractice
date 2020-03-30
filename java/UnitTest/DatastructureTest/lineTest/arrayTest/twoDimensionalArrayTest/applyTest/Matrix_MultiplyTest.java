package UnitTest.DatastructureTest.lineTest.arrayTest.twoDimensionalArrayTest.applyTest;

import DataStructure.line.array.twoDimensionalArray.twoDimensionalArrayApply.Matrix_Multiply;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date： 2020-01-08 21:40
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class Matrix_MultiplyTest {

    Matrix_Multiply matrix_multiply = new Matrix_Multiply();

    @Test
    public void TestMatrixMultiply() {
        int[][] target;
        target = matrix_multiply.MatrixMultiply(Demo01Materix_a, Demo01Materix_b);
        assert Arrays.deepEquals(target, Assert01Materix_c);
    }

    //准备两个矩阵（二维数组）:a是3*5，b是5*4
    int[][] Demo01Materix_a = {
            {1, 5, 7, 6, 9},
            {5, 7, 8, 3, 1},
            {2, 4, 8, 6, 1}};
    int[][] Demo01Materix_b = {
            {5, 7, 6, 3},
            {5, 3, 1, 5},
            {2, 4, 1, 3},
            {5, 6, 8, 2},
            {8, 3, 1, 1}};
    int[][] Assert01Materix_c = {
            {146, 113, 75, 70},
            {99,  109, 70, 81},
            {84,  97,  73, 63}};
}
