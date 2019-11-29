package UnitTest.datastructureTest.stringTest.stringApplyTest;

import DataStructure.string.stringApply.LNRSubstring;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-06 00:06
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
public class LNRSubstringTest {

    LNRSubstring lnrSubstring = new LNRSubstring();

    //正案例01：测试用例01
    String source01 = "pwwkew";

    //反案例02：测试用例02
    String source02 = "aassddffgghh";

    @Test
    public void testLNRSubstring() {
        int length = lnrSubstring.lengthOfLongestSubstring(source01);
        assert length == 3;

        length = lnrSubstring.lengthOfLongestSubstring(source02);
        assert length == 2;
    }
}
