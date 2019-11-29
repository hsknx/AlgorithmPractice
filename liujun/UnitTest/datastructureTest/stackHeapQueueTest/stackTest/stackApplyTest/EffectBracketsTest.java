package UnitTest.datastructureTest.stackHeapQueueTest.stackTest.stackApplyTest;

import DataStructure.stackHeapQueue.stack.stackApply.EffectBrackets;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£∫ 2019-11-30 01:14
 * @author°™Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class EffectBracketsTest {

    EffectBrackets effectBrackets = new EffectBrackets();

    @Test
    public void TestEffectBracketsbyStack(){
        assert !effectBrackets.EffectBracketsbyStack(Demo01);
        assert !effectBrackets.EffectBracketsbyStack(Demo02);
        assert effectBrackets.EffectBracketsbyStack(Demo03);
        assert effectBrackets.EffectBracketsbyStack(Demo04);
        assert effectBrackets.EffectBracketsbyStack(Demo05);
        assert !effectBrackets.EffectBracketsbyStack(Demo06);
        assert !effectBrackets.EffectBracketsbyStack(Demo07);
    }

    @Test
    public void TestEffectBracketsbyTotalNum(){

        assert !effectBrackets.EffectBracketsbyTotalNum(Demo01);
        assert !effectBrackets.EffectBracketsbyTotalNum(Demo02);
        assert effectBrackets.EffectBracketsbyTotalNum(Demo03);
        assert effectBrackets.EffectBracketsbyTotalNum(Demo04);
        assert effectBrackets.EffectBracketsbyTotalNum(Demo05);
        assert !effectBrackets.EffectBracketsbyTotalNum(Demo06);
        assert !effectBrackets.EffectBracketsbyTotalNum(Demo07);
    }

    @Test
    public void TestLongestEffectBracketsNum(){

        int num = effectBrackets.LongestEffectBracketsNum(Demo01);
        assert num == 0;
        num = effectBrackets.LongestEffectBracketsNum(Demo02);
        assert num == 0;
        num = effectBrackets.LongestEffectBracketsNum(Demo03);
        assert num == 2;
        num = effectBrackets.LongestEffectBracketsNum(Demo04);
        assert num == 4;
        num = effectBrackets.LongestEffectBracketsNum(Demo05);
        assert num == 14;
        num = effectBrackets.LongestEffectBracketsNum(Demo06);
        assert num == 14;
        num = effectBrackets.LongestEffectBracketsNum(Demo07);
        assert num == 10;
    }

    //≤‚ ‘”√¿˝
    String Demo01 = "";
    String Demo02 = null;
    String Demo03 = "()";
    String Demo04 = "()()";
    String Demo05 = "(()()(()(())))";
    String Demo06 = "(()()(()(()))))";//false
    String Demo07 = "()(()()))(()(()()))";//10

}
