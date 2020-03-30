package UnitTest.DatastructureTest.stringTest.stringApplyTest;

import DataStructure.string.stringApply.LNRSubstring;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-06 00:06
 * @author��Email:liujunfirst@outlook.com
 * @description:
 */
public class LNRSubstringTest {

    LNRSubstring lnrSubstring = new LNRSubstring();

    @Test
    public void testLNRSubstring() {
        int length = lnrSubstring.lengthOfLongestSubstring(demo01);
        assert length == 3;

        length = lnrSubstring.lengthOfLongestSubstring(demo02);
        assert length == 2;

        length = lnrSubstring.lengthOfLongestSubstring(demo03);
        assert length == 9;
    }

    //������01����������01
    String demo01 = "pwwkew";

    //������02����������02
    String demo02 = "aassddffgghh";

    //������03����������02
    String demo03 = "aasdfghjkll";
}
