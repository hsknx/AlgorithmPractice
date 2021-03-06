package UnitTest.AlgorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.lis.LIS;
import Algorithm.dynamic.dynamicPrimary.lis.LIS_divide;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 18:57
 * @author��Email liujunfirst@outlook.com
 * @description 
 * @blogURL
 */
public class LISTest {
    LIS lis = new LIS();
    LIS_divide lis_divide = new LIS_divide();

    @Test
    public void TestLis(){

        int result = lis.longestIncreasingSubsequence(demo01);
        assert result==9;
        result = lis.longestIncreasingSubsequence(demo02);
        assert result==0;
        result = lis.longestIncreasingSubsequence(demo03);
        assert result == 0;
        result = lis.longestIncreasingSubsequence(demo04);
        assert result==5;
        result = lis.longestIncreasingSubsequence(demo05);
        assert result==9;
        result = lis.longestIncreasingSubsequence(demo06);
        assert result==5;
        result = lis.longestIncreasingSubsequence(demo07);
        assert result==4;
        result = lis.longestIncreasingSubsequence(demo08);
        assert result==1;
    }

    @Test
    public void TestLis_divide(){

        int result = lis_divide.longestIncreasingSubsequence(demo01);
        assert result==9;
        result = lis_divide.longestIncreasingSubsequence(demo02);
        assert result==0;
        result = lis_divide.longestIncreasingSubsequence(demo03);
        assert result == 0;

        result = lis_divide.longestIncreasingSubsequence(demo04);
        assert result==5;
        result = lis_divide.longestIncreasingSubsequence(demo05);
        assert result==9;
        result = lis_divide.longestIncreasingSubsequence(demo06);
        assert result==5;
        result = lis_divide.longestIncreasingSubsequence(demo07);
        assert result==4;
        result = lis_divide.longestIncreasingSubsequence(demo08);
        assert result==1;
    }

    //��������
    String demo01 = "1528334656789123456";//123456789
    String demo02 = "";
    String demo03 = null;
    String demo04 = "18386873921";//13679
    String demo05 = "1234567823456789";//123456789
    String demo06 = "13572468";//12468
    String demo07 = "24681357";//2468
    String demo08 = "987654321";//123456789
}
