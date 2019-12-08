package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.MiniValuePathofTriangle;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£∫ 2019-11-25 16:44
 * @author°™Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class MiniValuePathofTriangleTest {

    MiniValuePathofTriangle miniValuePathofTriangle = new MiniValuePathofTriangle();
    @Test
    public void Testmethod(){
        int value = miniValuePathofTriangle.method(Demo01);
        assert value == 9;
        value = miniValuePathofTriangle.method(Demo02);
        assert value == 11;
    }

    //≤‚ ‘”√¿˝
    int[][] Demo01= {
            {1},
            {2, 5},
            {3, 6, 5},
            {2, 1, 5, 1},
            {8, 9, 2, 8, 9}
    };
    int[][] Demo02= {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
    };
}
