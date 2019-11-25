package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.lcs.LCS;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-25 16:38
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class LCSTest {

    LCS lcs = new LCS();
    @Test
    public void Testmethod(){
        String result = lcs.method(demo01,demo01_comp);
        assert result.equals("");
        result = lcs.method(demo02,demo02_comp);
        assert result.equals("");
        result = lcs.method(demo03,demo03_comp);
        assert result.equals("");
        result = lcs.method(demo04,demo04_comp);
        assert result.equals("");
        result = lcs.method(demo05,demo05_comp);
        assert result.equals("abcdefg");
        result = lcs.method(demo06,demo06_comp);
        assert result.equals("sdfhhhkl");
    }

    //测试用例
    String demo01 = "aaa";
    String demo01_comp = "bbb";//无相似部分，测试结果为空串：“”

    String demo02 = "";
    String demo02_comp = "bbb";//无相似部分，测试结果为空串：“”

    String demo03 = "aaa";
    String demo03_comp = "";//无相似部分，测试结果为空串：“”

    String demo04 = null;
    String demo04_comp = "";//无相似部分，测试结果为空串：“”

    String demo05 = "1a2b3c4d5e6f7g8";
    String demo05_comp = "9a9b9c9d9e9f9g9";//测试结果为：“abcdefg”

    String demo06 = "1sd3445fh677hhk898777l";
    String demo06_comp = "2sd2b22fhzbzzhzhkblb";//测试结果为：“sdfhhhkl”
}
