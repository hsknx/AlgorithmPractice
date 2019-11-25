package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest.PalindromeTest;

import Algorithm.dynamic.dynamicPrimary.palindrome.CreatePalindromebyDelete;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-07 20:07
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class CreatePalindromebyDeleteTest {

    CreatePalindromebyDelete createPalindromebyDelete = new CreatePalindromebyDelete();

    //测试
    @Test
    public void useLcsTest() {

        //测试结果期望：-1，-1，0，0，3，8，1，-1
        int flag = createPalindromebyDelete.useLcs(TestString01);
        assert flag == -1;
        flag = createPalindromebyDelete.useLcs(TestString02);
        assert flag == -1;
        flag = createPalindromebyDelete.useLcs(TestString03);
        assert flag == 0;
        flag = createPalindromebyDelete.useLcs(TestString04);
        assert flag == 0;
        flag = createPalindromebyDelete.useLcs(TestString05);
        assert flag == 1;
        flag = createPalindromebyDelete.useLcs(TestString06);
        assert flag == 1;
        flag = createPalindromebyDelete.useLcs(TestString07);
        assert flag == 1;
        flag = createPalindromebyDelete.useLcs(TestString08);
        assert flag == 2;
        flag = createPalindromebyDelete.useLcs(TestString09);
        assert flag == 0;
    }

    //测试用例01:空
    String TestString01 = null;
    //测试用例02:空串
    String TestString02 = "";
    //测试用例03:偶数长度回文串
    String TestString03 = "abcddcba";
    //测试用例04:奇数长度回文串
    String TestString04 = "abcdcba";
    //测试用例05:
    String TestString05 = "ab2cdcba";
    //测试用例06:
    String TestString06 = "abcdcba3";
    //测试用例07:
    String TestString07 = "0abcdcba";
    //测试用例08:
    String TestString08 = "0abcd3cba";
    //测试用例09:仅含1个字符
    String TestString09 = "a";
}
