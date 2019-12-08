package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.MiniValuePathofMatrix;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£∫ 2019-11-25 17:00
 * @author°™Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class MiniValuePathofMatrixTest {

    MiniValuePathofMatrix miniValuePathofMatrix = new MiniValuePathofMatrix();
    @Test
    public void Testmethod(){

        int value = miniValuePathofMatrix.method(Demo01);
        assert value == 7;
        value = miniValuePathofMatrix.method(Demo02);
        assert value == -1;
    }

    //≤‚ ‘”√¿˝
    int[][] Demo01= {
            {1,3,1},
            {1,5,1},
            {4,2,1},
    };
    int[][] Demo02= {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
    };
}
