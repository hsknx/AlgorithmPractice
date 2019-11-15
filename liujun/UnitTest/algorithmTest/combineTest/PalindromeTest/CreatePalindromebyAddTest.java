package UnitTest.algorithmTest.combineTest.PalindromeTest;

import Algorithm.dynamic.dynamicPrimary.palindrome.CreatePalindromebyAdd;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-07 20:08
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class CreatePalindromebyAddTest {
    CreatePalindromebyAdd createPalindromebyAdd = new CreatePalindromebyAdd();

    //方法一：首位对比测试
    @Test
    public void headAndTailCompareTest(){

        //测试结果期望：-1，-1，0，0，3，8，1，-1
        int flag = createPalindromebyAdd.headAndTailCompare(TestString01);
        assert flag == -1;
        flag = createPalindromebyAdd.headAndTailCompare(TestString02);
        assert flag == -1;
        flag = createPalindromebyAdd.headAndTailCompare(TestString03);
        assert flag == 4;
        flag = createPalindromebyAdd.headAndTailCompare(TestString04);
        assert flag == 3;
        flag = createPalindromebyAdd.headAndTailCompare(TestString05);
        assert flag == 2;
        flag = createPalindromebyAdd.headAndTailCompare(TestString06);
        assert flag == 7;
        flag = createPalindromebyAdd.headAndTailCompare(TestString07);
        assert flag == 0;
        flag = createPalindromebyAdd.headAndTailCompare(TestString08);
        assert flag == -1;
        flag = createPalindromebyAdd.headAndTailCompare(TestString09);
        assert flag == 0;
    }

    //方法二：删除构造测试
    @Test
    public void useDeleteTest(){

        //测试结果期望：-1，-1，0，0，3，8，1，-1
        int flag = createPalindromebyAdd.useDelete(TestString01);
        assert flag == -1;
        flag = createPalindromebyAdd.useDelete(TestString02);
        assert flag == -1;
        flag = createPalindromebyAdd.useDelete(TestString03);
        assert flag == 4;
        flag = createPalindromebyAdd.useDelete(TestString04);
        assert flag == 3;
        flag = createPalindromebyAdd.useDelete(TestString05);
        assert flag == 2;
        flag = createPalindromebyAdd.useDelete(TestString06);
        assert flag == 7;
        flag = createPalindromebyAdd.useDelete(TestString07);
        assert flag == 0;
        flag = createPalindromebyAdd.useDelete(TestString08);
        assert flag == -1;
        flag = createPalindromebyAdd.useDelete(TestString09);
        assert flag == 0;
    }

    //方法三：LCS思想测试
    @Test
    public void useLCSTest(){
        //无法判断是第i位还是length-i位
    }

    //回文判断
    @Test
    public void PalindromeJudgeTest() {
        //测试结果期望：
        boolean flag = createPalindromebyAdd.PalindromeJudge(TestString01);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString02);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString03);
        assert  flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString04);
        assert  flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString05);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString06);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString07);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString08);
        assert !flag;
        flag = createPalindromebyAdd.PalindromeJudge(TestString09);
        assert flag;
    }

    //测试用例01:空，期望：-1
    String TestString01 = null;
    //测试用例02:空串，期望：-1
    String TestString02 = "";
    //测试用例03:偶数长度回文串，期望：4
    String TestString03 = "abcddcba";
    //测试用例04:奇数长度回文串，期望：3
    String TestString04 = "abcdcba";
    //测试用例05:需删除第3位，期望：2
    String TestString05 = "ab2cdcba";
    //测试用例06:需删除最后一位：7，期望：7
    String TestString06 = "abcdcba3";
    //测试用例07:需删除第一位：0，期望：0
    String TestString07 = "0abcdcba";
    //测试用例08:删除一位后仍不是回文串，期望：-1
    String TestString08 = "0abcd3cba";
    //测试用例09:仅含1个字符
    String TestString09 = "a";
}
