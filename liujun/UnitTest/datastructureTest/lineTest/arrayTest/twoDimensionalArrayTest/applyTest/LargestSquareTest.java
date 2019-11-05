package UnitTest.datastructureTest.lineTest.arrayTest.twoDimensionalArrayTest.applyTest;

import DataStructure.line.array.twoDimensionalArray.apply.LargestSquare;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-05 13:21
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class LargestSquareTest {

    LargestSquare largestSquare = new LargestSquare();

    //UT：暴力循环扫描法（含冗余扫描）
    @Test
    public void getMaxSideLengthViolenceTest(){
        //测试用例01，起始点:(0，0),最大边长:2，期望值为2
        int bound_value = largestSquare.getMaxSideLengthViolence(Square_Test01,0,0);
        assert bound_value == 2;

        //测试用例02：起始点:(1，1),最大边长:3,期望值为3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test02,1,1);
        assert bound_value == 3;

        //测试用例03：起始点:无或者(0,0),最大边长:0,期望值为0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test03,0,0);
        assert bound_value == 0;

        //测试用例04：起始点:(5,5),最大边长:0,越界，期望值为0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test04,5,5);
        assert bound_value == 0;

        //测试用例05：起始点:(2，1),最大边长:2,
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test05,2,1);
        assert bound_value == 2;
    }

    //正案例：测试用例01：起始点:(0，0),最大边长:2,最大面积：4,
    int[][] Square_Test01 = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    //正案例：测试用例02：起始点:(1，1),最大边长:3,最大面积：9,
    int[][] Square_Test02 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //反案例：测试用例03：起始点:无,最大边长:0,最大面积：0,
    int[][] Square_Test03 = null;

    //反案例：测试用例04：起始点:(5,5),最大边长:0,最大面积：0,
    int[][] Square_Test04 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //正案例：测试用例05：起始点:(2，1),最大边长:2,最大面积：4,
    int[][] Square_Test05 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

}
