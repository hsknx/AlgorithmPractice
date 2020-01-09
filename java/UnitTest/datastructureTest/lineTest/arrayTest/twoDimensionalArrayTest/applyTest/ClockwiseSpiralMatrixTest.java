package UnitTest.datastructureTest.lineTest.arrayTest.twoDimensionalArrayTest.applyTest;

import DataStructure.line.array.twoDimensionalArray.twoDimensionalArrayApply.ClockwiseSpiralMatrix;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-11-09 22:23
 * @author¡ªEmail:liujunfirst@outlook.com
 * @description:
 */
public class ClockwiseSpiralMatrixTest {

    ClockwiseSpiralMatrix clockwiseSpiralMatrix = new ClockwiseSpiralMatrix();

    @Test
    public void Testprint() {
        int[] target;
        target = clockwiseSpiralMatrix.print(Demo01);
        Arrays.equals(target, Answer01);
        target = clockwiseSpiralMatrix.print(Demo02);
        Arrays.equals(target, Answer02);
        target = clockwiseSpiralMatrix.print(Demo03);
        Arrays.equals(target, Answer03);
        target = clockwiseSpiralMatrix.print(Demo04);
        Arrays.equals(target, Answer04);
    }

    //Demo
    int[][] Demo01 = {
            {1,  2, 3,4},
            {12,13,14,5},
            {11,16,15,6},
            {10, 9, 8,7}
    };
    int[] Answer01 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    int[][] Demo02 = {
            { 2, 3,4},
            {11,12,5},
            {10,13,6},
            { 9, 8,7}
    };
    int[] Answer02 = {2,3,4,5,6,7,8,9,10,11,12,13};
    int[][] Demo03 = {
            {2,  3, 4,5},
            {11,12,13,6},
            {10, 9, 8,7}
    };
    int[] Answer03 = {2,3,4,5,6,7,8,9,10,11,12,13};
    int[][] Demo04 = {};
    int[] Answer04 = null;
}
