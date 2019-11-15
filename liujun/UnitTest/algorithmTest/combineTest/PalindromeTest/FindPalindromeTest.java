package UnitTest.algorithmTest.combineTest.PalindromeTest;

import Algorithm.dynamic.dynamicPrimary.palindrome.FindPalindrome;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-07 22:41
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class FindPalindromeTest {

    FindPalindrome findPalindrome = new FindPalindrome();

    @Test
    public void findStringViolenceTest(){
        String target = findPalindrome.findStringViolence(TestString01);
        assert target == null;
        target = findPalindrome.findStringViolence(TestString02);
        assert target == null;
        target = findPalindrome.findStringViolence(TestString03);
        assert target.equals("abcddcba");
        target = findPalindrome.findStringViolence(TestString04);
        assert target.equals("abcdcba");
        target = findPalindrome.findStringViolence(TestString05);
        assert target.equals("abcdcba");
        target = findPalindrome.findStringViolence(TestString06);
        assert target.equals("abcdcba");
        target = findPalindrome.findStringViolence(TestString07);
        assert target.equals("abcdcba");
        target = findPalindrome.findStringViolence(TestString08);
        assert target == null;
        target = findPalindrome.findStringViolence(TestString09);
        assert target.equals("a");
    }

    @Test
    public void findStringTest(){
        String target = findPalindrome.findString(TestString01);
        assert target == null;
        target = findPalindrome.findString(TestString02);
        assert target == null;
        target = findPalindrome.findString(TestString03);
        assert target == "abcddcba";
        target = findPalindrome.findString(TestString04);
        assert target == "abcdcba";
        target = findPalindrome.findString(TestString05);
        //字符串的比较尽量使用equals
        assert target.equals("abcdcba");
        target = findPalindrome.findString(TestString06);
        assert target.equals("abcdcba");
        target = findPalindrome.findString(TestString07);
        assert target.equals("abcdcba");
        target = findPalindrome.findString(TestString08);
        assert target == null;
        target = findPalindrome.findString(TestString09);
        assert target == null;
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
    String TestString07 = "dec4evp5v8eswnrtbutymnabcdcbaymabcdicbarfvbgtcjvp9vc";
    //测试用例08:不含回文串
    String TestString08 = "awhnjkwhcwnlkibectdvhewhcoicybua";
    //测试用例09:仅含1个字符
    String TestString09 = "a";
}