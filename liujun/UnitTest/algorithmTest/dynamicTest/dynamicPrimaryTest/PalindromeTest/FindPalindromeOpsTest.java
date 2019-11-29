package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest.PalindromeTest;

import Algorithm.dynamic.dynamicPrimary.palindrome.FindPalindromeOps;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-07 22:42
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
public class FindPalindromeOpsTest {

    FindPalindromeOps findPalindromeOps = new FindPalindromeOps();

    public void findStringTest(){

        String target = findPalindromeOps.findString(TestString01);
        assert target == null;
        target = findPalindromeOps.findString(TestString02);
        assert target == null;
        target = findPalindromeOps.findString(TestString03);
        assert target == "abcddcba";
        target = findPalindromeOps.findString(TestString04);
        assert target == "abcddcba";
        target = findPalindromeOps.findString(TestString05);
        assert target == "abcdcba";
        target = findPalindromeOps.findString(TestString06);
        assert target == "abcdcba";
        target = findPalindromeOps.findString(TestString07);
        assert target == "abcdcba";
        target = findPalindromeOps.findString(TestString08);
        assert target == null;
        target = findPalindromeOps.findString(TestString09);
        assert target.equals("a");
    }

    //测试用例01:空
    String TestString01 = null;
    //测试用例02:空串
    String TestString02 = "";
    //测试用例03:偶数长度回文串
    String TestString03 = "abcddcba";
    //测试用例04:奇数长度回文串
    String TestString04 = "abcdcba";
    //测试用例05:abcdcba
    String TestString05 = "sdfabcdcba";
    //测试用例06:abcdcba
    String TestString06 = "abcdcbawer";
    //测试用例07:含回文串，abcdcba
    String TestString07 = "dec4ev5veswnrtbtymnymabcdcbarfvbgtcjv9vc";
    //测试用例08:不含回文串
    String TestString08 = "awhnjkwhcwnlkibectdvhewhcoicybua";
    //测试用例09:仅含1个字符
    String TestString09 = "a";
}
