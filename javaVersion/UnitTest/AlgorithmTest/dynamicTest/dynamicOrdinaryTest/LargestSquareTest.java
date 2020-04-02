package UnitTest.AlgorithmTest.dynamicTest.dynamicOrdinaryTest;

import Algorithm.dynamic.dynamicOrdinary.LargestSquare;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-06 22:06
 * @author—Email  liujunfirst@outlook.com
 * @description 
 * @blogURL
 */
public class LargestSquareTest {

    LargestSquare largestSquare = new LargestSquare();

    //暴力求解法
    @Test
    public void violenceSolutionTest(){
        //测试用例01，实际最大面积：9
        int maxValue = largestSquare.violenceSolution(Square_Test01);
        assert maxValue == 9;
        //测试用例02，实际最大面积：9
        maxValue = largestSquare.violenceSolution(Square_Test02);
        assert maxValue == 9;
        //测试用例03，实际最大面积：-1
        maxValue = largestSquare.violenceSolution(Square_Test03);
        assert maxValue == -1;
        //测试用例04，实际最大面积：9
        maxValue = largestSquare.violenceSolution(Square_Test04);
        assert maxValue == 9;
        //测试用例05，实际最大面积：9
        maxValue = largestSquare.violenceSolution(Square_Test05);
        assert maxValue == 9;
        //测试用例06，实际最大面积：4
        maxValue = largestSquare.violenceSolution(Square_Test06);
        assert maxValue == 4;
        //测试用例07，实际最大面积：4
        maxValue = largestSquare.violenceSolution(Square_Test07);
        assert maxValue == 4;
        //测试用例08，实际最大面积：-3
        maxValue = largestSquare.violenceSolution(Square_Test08);
        assert maxValue == -3;
    }

    //动态规划法
    @Test
    public void dynamicSolution(){
        //测试用例01，实际最大面积：9
        int maxValue = largestSquare.dynamicSolution(Square_Test01);
        assert maxValue == 9;
        //测试用例02，实际最大面积：9
        maxValue = largestSquare.dynamicSolution(Square_Test02);
        assert maxValue == 9;
        //测试用例03，实际最大面积：-1
        maxValue = largestSquare.dynamicSolution(Square_Test03);
        assert maxValue == -1;
        //测试用例04，实际最大面积：9
        maxValue = largestSquare.dynamicSolution(Square_Test04);
        assert maxValue == 9;
        //测试用例05，实际最大面积：9
        maxValue = largestSquare.dynamicSolution(Square_Test05);
        assert maxValue == 9;
        //测试用例06，实际最大面积：4
        maxValue = largestSquare.dynamicSolution(Square_Test06);
        assert maxValue == 4;
        //测试用例07，实际最大面积：4
        maxValue = largestSquare.dynamicSolution(Square_Test07);
        assert maxValue == 4;
        //测试用例08，实际最大面积：-3
        maxValue = largestSquare.dynamicSolution(Square_Test08);
        assert maxValue == -3;
    }

    //动态规划优化
    @Test
    public void dynamicOptSolution(){
        //测试用例01，实际最大面积：9
        int maxValue = largestSquare.dynamicOptSolution(Square_Test01);
        assert maxValue == 9;
        //测试用例02，实际最大面积：9
        maxValue = largestSquare.dynamicOptSolution(Square_Test02);
        assert maxValue == 9;
        //测试用例03，实际最大面积：-1
        maxValue = largestSquare.dynamicOptSolution(Square_Test03);
        assert maxValue == -1;
        //测试用例04，实际最大面积：9
        maxValue = largestSquare.dynamicOptSolution(Square_Test04);
        assert maxValue == 9;
        //测试用例05，实际最大面积：9
        maxValue = largestSquare.dynamicOptSolution(Square_Test05);
        assert maxValue == 9;
        //测试用例06，实际最大面积：4
        maxValue = largestSquare.dynamicOptSolution(Square_Test06);
        assert maxValue == 4;
        //测试用例07，实际最大面积：4
        maxValue = largestSquare.dynamicOptSolution(Square_Test07);
        assert maxValue == 4;
        //测试用例08，实际最大面积：-3
        maxValue = largestSquare.dynamicOptSolution(Square_Test08);
        assert maxValue == -3;
    }

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
        assert bound_value == -1;

        //测试用例04：起始点:(5,5),最大边长:0,越界，期望值为0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test04,5,5);
        assert bound_value == -2;

        //测试用例05：起始点:(2，1),最大边长:2,
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test05,2,1);
        assert bound_value == 2;

        //测试用例06：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test06,1,1);
        assert bound_value == 2;

        //测试用例07：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test07,1,1);
        assert bound_value == 2;
    }

    //逐层扫描法
    @Test
    public void getMaxSideLengthScannerTest(){
        //测试用例01，起始点:(0，0),最大边长:2，期望值为2
        int bound_value = largestSquare.getMaxSideLengthScanner(Square_Test01,0,0);
        assert bound_value == 2;

        //测试用例02：起始点:(1，1),最大边长:3,期望值为3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test02,1,1);
        assert bound_value == 3;

        //测试用例03：起始点:无或者(0,0),最大边长:0,期望值为0
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test03,0,0);
        assert bound_value == -1;

        //测试用例04：起始点:(5,5),最大边长:0,越界，期望值为0
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test04,5,5);
        assert bound_value == -2;

        //测试用例05：起始点:(2，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test05,2,1);
        assert bound_value == 2;

        //测试用例06：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test06,1,1);
        assert bound_value == 2;

        //测试用例07：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test07,1,1);
        assert bound_value == 2;
    }

    //最大长度限制法
    @Test
    public void getMaxSideLengthLimit(){
        //测试用例01，起始点:(0，0),最大边长:2，期望值为2
        int bound_value = largestSquare.getMaxSideLengthLimit(Square_Test01,0,0);
        assert bound_value == 2;

        //测试用例02：起始点:(1，1),最大边长:3,期望值为3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test02,1,1);
        assert bound_value == 3;

        //测试用例03：起始点:无或者(0,0),最大边长:0,期望值为0
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test03,0,0);
        assert bound_value == -1;

        //测试用例04：起始点:(5,5),最大边长:0,越界，期望值为0
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test04,5,5);
        assert bound_value == -2;

        //测试用例05：起始点:(2，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test05,2,1);
        assert bound_value == 2;

        //测试用例06：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test06,1,1);
        assert bound_value == 2;

        //测试用例07：起始点:(1，1),最大边长:2,期望值为2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test07,1,1);
        assert bound_value == 2;
    }
    
    //正案例：测试用例01：起始点:(0，0),起始点最大边长:2,起始点最大面积：4,实际最大面积：9
    int[][] Square_Test01 = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1}
    };

    //正案例：测试用例02：起始点:(1，1),起始点最大边长:3,起始点最大面积：9,实际最大面积：9
    int[][] Square_Test02 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //反案例：测试用例03：起始点:无,起始点最大边长:0,起始点最大面积：0,实际最大面积：0
    int[][] Square_Test03 = null;

    //反案例：测试用例04：起始点:(5,5),越界,起始点最大边长:0,起始点最大面积：0,实际最大面积：9
    int[][] Square_Test04 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 0, 1}
    };

    //正案例：测试用例05：起始点:(2，1),起始点最大边长:2,起始点最大面积：4,实际最大面积：9
    int[][] Square_Test05 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0}
    };

    //正案例：测试用例06：起始点:(1，1),起始点最大边长:2,起始点最大面积：4,实际最大面积：4
    int[][] Square_Test06 = new int[][]{
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1},
            {0, 1, 0, 1, 0}
    };

    //正案例：测试用例07：起始点:(1，1),起始点最大边长:2,起始点最大面积：4,实际最大面积：4
    int[][] Square_Test07 = new int[][]{
            {0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0, 0, 1}
    };

    //反案例：测试用例08：起始点:(0，0),非仅含0,1，期望值：-3
    int[][] Square_Test08 = new int[][]{
            {0, 0, 0, 1, 0, 7, 1},
            {1, 1, 2, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 4, 0, 1},
            {0, 1, 0, 1, 0, 0, 1}
    };
}
