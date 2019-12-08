package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.lis.LIS;
import Algorithm.dynamic.dynamicPrimary.lis.LIS_divide;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£∫ 2019-11-25 18:57
 * @author°™Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class LISTest {
    LIS lis = new LIS();
    LIS_divide lis_divide = new LIS_divide();

    @Test
    public void TestLis(){

        String result = lis.longestIncreasingSubsequence(demo01);
        assert result.equals("123456789");
        result = lis.longestIncreasingSubsequence(demo02);
        assert result.equals("");
        result = lis.longestIncreasingSubsequence(demo03);
        assert result == null;
    }

    @Test
    public void TestLis_divide(){

        String result = lis_divide.longestIncreasingSubsequence(demo01);
        assert result.equals("123456789");
        result = lis_divide.longestIncreasingSubsequence(demo02);
        assert result.equals("");
        result = lis_divide.longestIncreasingSubsequence(demo03);
        assert result == null;
    }

    //≤‚ ‘”√¿˝
    String demo01 = "1528334656789123456";//123456789
    String demo02 = "";
    String demo03 = null;

}
