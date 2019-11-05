package UnitTest.datastructureTest.stringTest.stringApplyTest;

import DataStructure.string.stringApply.Sunday;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-06 00:06
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class SundayTest {

    Sunday sunday = new Sunday();

    //正案例01：测试用例01
    String source01 = "12345ui6789";
    String pattern01 = "ui";

    //正案例02：测试用例02
    String source02 = "12345uri67we89";
    String pattern02 = "we";

    //正案例03：测试用例03
    String source03 = "123rt45uri6789";
    String pattern03 = "rt";

    //反案例01：测试用例01
    String source04 = "12uw3wi345uri6789";
    String pattern04 = "uir";

    //反案例02：测试用例02
    String source05 = "12345uri6u4i789";
    String pattern05 = "ui";

    //反案例03：测试用例03
    String source06 = "12345uri67f34g3b5n689";
    String pattern06 = "f34gb5n6";
    @Test
    public void testSunday() {
        //正案例
        boolean flag = sunday.SundaySolution(source01, pattern01);
        assert flag;
        flag = sunday.SundaySolution(source02, pattern02);
        assert flag;
        flag = sunday.SundaySolution(source03, pattern03);
        assert flag;
        //反案例
        flag = sunday.SundaySolution(source04, pattern04);
        assert !flag;
        flag = sunday.SundaySolution(source05, pattern05);
        assert !flag;
        flag = sunday.SundaySolution(source06, pattern06);
        assert !flag;
    }
}
