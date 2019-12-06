package UnitTest.datastructureTest.stringTest.stringApplyTest;

import DataStructure.string.stringCompare.KMP;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-06 00:04
 * @author��Email:liujunfirst@outlook.com
 * @description:
 */
public class KMPTest {

    KMP kmp = new KMP();

    //������01����������01
    String source01 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern01 = "==1vyugbuiy1==";

    //������02����������02
    String source02 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern02 = "1vyugbuiy1";

    //������03����������03
    String source03 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern03 = "=1=1vyugbuiy1==";
    @Test
    public void testKMP(){
        boolean flag = kmp.kmp(source01, pattern01);
        assert flag;

        flag = kmp.kmp(source02, pattern02);
        assert flag;

        flag = kmp.kmp(source03, pattern03);
        assert !flag;
    }
}
