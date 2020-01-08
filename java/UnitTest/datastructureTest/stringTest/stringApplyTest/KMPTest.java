package UnitTest.datastructureTest.stringTest.stringApplyTest;

import DataStructure.string.stringCompare.KMP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-06 00:04
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:JavaContext.xml"})
public class KMPTest {

    @Resource
    KMP kmp ;


    @Test
    public void testkmp(){
        boolean flag = kmp.kmp(source01, pattern01);
        assert flag;

        flag = kmp.kmp(source02, pattern02);
        assert flag;

        flag = kmp.kmp(source03, pattern03);
        assert !flag;
    }

    //正案例01：测试用例01
    String source01 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern01 = "==1vyugbuiy1==";

    //正案例02：测试用例02
    String source02 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern02 = "1vyugbuiy1";

    //反案例03：测试用例03
    String source03 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern03 = "=1=1vyugbuiy1==";
}