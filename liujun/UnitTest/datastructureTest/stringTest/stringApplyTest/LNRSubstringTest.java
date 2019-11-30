package UnitTest.datastructureTest.stringTest.stringApplyTest;

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

    //������01����������01
    String source01 = "pwwkew";

    //������02����������02
    String source02 = "aassddffgghh";

    @Test
    public void testLNRSubstring() {
        int length = lnrSubstring.lengthOfLongestSubstring(source01);
        assert length == 3;

        length = lnrSubstring.lengthOfLongestSubstring(source02);
        assert length == 2;
    }
}
