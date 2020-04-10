package UnitTest.AlgorithmTest.dynamicTest.dynamicOrdinaryTest;

import Algorithm.dynamic.dynamicOrdinary.LargestSquare;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-06 22:06
 * @author��Email  liujunfirst@outlook.com
 * @description 
 * @blogURL
 */
public class LargestSquareTest {

    LargestSquare largestSquare = new LargestSquare();

    //������ⷨ
    @Test
    public void violenceSolutionTest(){
        //��������01��ʵ����������9
        int maxValue = largestSquare.violenceSolution(Square_Test01);
        assert maxValue == 9;
        //��������02��ʵ����������9
        maxValue = largestSquare.violenceSolution(Square_Test02);
        assert maxValue == 9;
        //��������03��ʵ����������-1
        maxValue = largestSquare.violenceSolution(Square_Test03);
        assert maxValue == -1;
        //��������04��ʵ����������9
        maxValue = largestSquare.violenceSolution(Square_Test04);
        assert maxValue == 9;
        //��������05��ʵ����������9
        maxValue = largestSquare.violenceSolution(Square_Test05);
        assert maxValue == 9;
        //��������06��ʵ����������4
        maxValue = largestSquare.violenceSolution(Square_Test06);
        assert maxValue == 4;
        //��������07��ʵ����������4
        maxValue = largestSquare.violenceSolution(Square_Test07);
        assert maxValue == 4;
        //��������08��ʵ����������-3
        maxValue = largestSquare.violenceSolution(Square_Test08);
        assert maxValue == -3;
    }

    //��̬�滮��
    @Test
    public void dynamicSolution(){
        //��������01��ʵ����������9
        int maxValue = largestSquare.dynamicSolution(Square_Test01);
        assert maxValue == 9;
        //��������02��ʵ����������9
        maxValue = largestSquare.dynamicSolution(Square_Test02);
        assert maxValue == 9;
        //��������03��ʵ����������-1
        maxValue = largestSquare.dynamicSolution(Square_Test03);
        assert maxValue == -1;
        //��������04��ʵ����������9
        maxValue = largestSquare.dynamicSolution(Square_Test04);
        assert maxValue == 9;
        //��������05��ʵ����������9
        maxValue = largestSquare.dynamicSolution(Square_Test05);
        assert maxValue == 9;
        //��������06��ʵ����������4
        maxValue = largestSquare.dynamicSolution(Square_Test06);
        assert maxValue == 4;
        //��������07��ʵ����������4
        maxValue = largestSquare.dynamicSolution(Square_Test07);
        assert maxValue == 4;
        //��������08��ʵ����������-3
        maxValue = largestSquare.dynamicSolution(Square_Test08);
        assert maxValue == -3;
    }

    //��̬�滮�Ż�
    @Test
    public void dynamicOptSolution(){
        //��������01��ʵ����������9
        int maxValue = largestSquare.dynamicOptSolution(Square_Test01);
        assert maxValue == 9;
        //��������02��ʵ����������9
        maxValue = largestSquare.dynamicOptSolution(Square_Test02);
        assert maxValue == 9;
        //��������03��ʵ����������-1
        maxValue = largestSquare.dynamicOptSolution(Square_Test03);
        assert maxValue == -1;
        //��������04��ʵ����������9
        maxValue = largestSquare.dynamicOptSolution(Square_Test04);
        assert maxValue == 9;
        //��������05��ʵ����������9
        maxValue = largestSquare.dynamicOptSolution(Square_Test05);
        assert maxValue == 9;
        //��������06��ʵ����������4
        maxValue = largestSquare.dynamicOptSolution(Square_Test06);
        assert maxValue == 4;
        //��������07��ʵ����������4
        maxValue = largestSquare.dynamicOptSolution(Square_Test07);
        assert maxValue == 4;
        //��������08��ʵ����������-3
        maxValue = largestSquare.dynamicOptSolution(Square_Test08);
        assert maxValue == -3;
    }

    //UT������ѭ��ɨ�跨��������ɨ�裩
    @Test
    public void getMaxSideLengthViolenceTest(){
        //��������01����ʼ��:(0��0),���߳�:2������ֵΪ2
        int bound_value = largestSquare.getMaxSideLengthViolence(Square_Test01,0,0);
        assert bound_value == 2;

        //��������02����ʼ��:(1��1),���߳�:3,����ֵΪ3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test02,1,1);
        assert bound_value == 3;

        //��������03����ʼ��:�޻���(0,0),���߳�:0,����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test03,0,0);
        assert bound_value == -1;

        //��������04����ʼ��:(5,5),���߳�:0,Խ�磬����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test04,5,5);
        assert bound_value == -2;

        //��������05����ʼ��:(2��1),���߳�:2,
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test05,2,1);
        assert bound_value == 2;

        //��������06����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test06,1,1);
        assert bound_value == 2;

        //��������07����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test07,1,1);
        assert bound_value == 2;
    }

    //���ɨ�跨
    @Test
    public void getMaxSideLengthScannerTest(){
        //��������01����ʼ��:(0��0),���߳�:2������ֵΪ2
        int bound_value = largestSquare.getMaxSideLengthScanner(Square_Test01,0,0);
        assert bound_value == 2;

        //��������02����ʼ��:(1��1),���߳�:3,����ֵΪ3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test02,1,1);
        assert bound_value == 3;

        //��������03����ʼ��:�޻���(0,0),���߳�:0,����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test03,0,0);
        assert bound_value == -1;

        //��������04����ʼ��:(5,5),���߳�:0,Խ�磬����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test04,5,5);
        assert bound_value == -2;

        //��������05����ʼ��:(2��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test05,2,1);
        assert bound_value == 2;

        //��������06����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test06,1,1);
        assert bound_value == 2;

        //��������07����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthScanner(Square_Test07,1,1);
        assert bound_value == 2;
    }

    //��󳤶����Ʒ�
    @Test
    public void getMaxSideLengthLimit(){
        //��������01����ʼ��:(0��0),���߳�:2������ֵΪ2
        int bound_value = largestSquare.getMaxSideLengthLimit(Square_Test01,0,0);
        assert bound_value == 2;

        //��������02����ʼ��:(1��1),���߳�:3,����ֵΪ3
        Square_Test01 = null;
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test02,1,1);
        assert bound_value == 3;

        //��������03����ʼ��:�޻���(0,0),���߳�:0,����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test03,0,0);
        assert bound_value == -1;

        //��������04����ʼ��:(5,5),���߳�:0,Խ�磬����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test04,5,5);
        assert bound_value == -2;

        //��������05����ʼ��:(2��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test05,2,1);
        assert bound_value == 2;

        //��������06����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test06,1,1);
        assert bound_value == 2;

        //��������07����ʼ��:(1��1),���߳�:2,����ֵΪ2
        bound_value = largestSquare.getMaxSideLengthLimit(Square_Test07,1,1);
        assert bound_value == 2;
    }
    
    //����������������01����ʼ��:(0��0),��ʼ�����߳�:2,��ʼ����������4,ʵ����������9
    int[][] Square_Test01 = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1}
    };

    //����������������02����ʼ��:(1��1),��ʼ�����߳�:3,��ʼ����������9,ʵ����������9
    int[][] Square_Test02 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //����������������03����ʼ��:��,��ʼ�����߳�:0,��ʼ����������0,ʵ����������0
    int[][] Square_Test03 = null;

    //����������������04����ʼ��:(5,5),Խ��,��ʼ�����߳�:0,��ʼ����������0,ʵ����������9
    int[][] Square_Test04 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 1, 0, 1}
    };

    //����������������05����ʼ��:(2��1),��ʼ�����߳�:2,��ʼ����������4,ʵ����������9
    int[][] Square_Test05 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0}
    };

    //����������������06����ʼ��:(1��1),��ʼ�����߳�:2,��ʼ����������4,ʵ����������4
    int[][] Square_Test06 = new int[][]{
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1},
            {0, 1, 0, 1, 0}
    };

    //����������������07����ʼ��:(1��1),��ʼ�����߳�:2,��ʼ����������4,ʵ����������4
    int[][] Square_Test07 = new int[][]{
            {0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0, 0, 1}
    };

    //����������������08����ʼ��:(0��0),�ǽ���0,1������ֵ��-3
    int[][] Square_Test08 = new int[][]{
            {0, 0, 0, 1, 0, 7, 1},
            {1, 1, 2, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 4, 0, 1},
            {0, 1, 0, 1, 0, 0, 1}
    };
}
