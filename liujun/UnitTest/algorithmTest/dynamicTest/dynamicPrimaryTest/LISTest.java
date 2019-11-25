package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.LIS;
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

    @Test
    public void Testmethod(){

        String result = lis.longestIncreasingSubsequence(demo01);
        assert result.equals("123456789");
        result = lis.longestIncreasingSubsequence(demo02);
        assert result.equals("");
        result = lis.longestIncreasingSubsequence(demo03);
        assert result.equals(null);
    }

    //≤‚ ‘”√¿˝
    String demo01 = "1528334656789123456";//123456789
    String demo02 = "";
    String demo03 = null;

}
