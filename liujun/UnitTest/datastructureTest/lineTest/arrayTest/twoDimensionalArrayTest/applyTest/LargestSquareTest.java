package UnitTest.datastructureTest.lineTest.arrayTest.twoDimensionalArrayTest.applyTest;

import DataStructure.line.array.twoDimensionalArray.apply.LargestSquare;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-05 13:21
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class LargestSquareTest {

    LargestSquare largestSquare = new LargestSquare();

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
        assert bound_value == 0;

        //��������04����ʼ��:(5,5),���߳�:0,Խ�磬����ֵΪ0
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test04,5,5);
        assert bound_value == 0;

        //��������05����ʼ��:(2��1),���߳�:2,
        bound_value = largestSquare.getMaxSideLengthViolence(Square_Test05,2,1);
        assert bound_value == 2;
    }

    //����������������01����ʼ��:(0��0),���߳�:2,��������4,
    int[][] Square_Test01 = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    //����������������02����ʼ��:(1��1),���߳�:3,��������9,
    int[][] Square_Test02 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //����������������03����ʼ��:��,���߳�:0,��������0,
    int[][] Square_Test03 = null;

    //����������������04����ʼ��:(5,5),���߳�:0,��������0,
    int[][] Square_Test04 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

    //����������������05����ʼ��:(2��1),���߳�:2,��������4,
    int[][] Square_Test05 = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };

}
