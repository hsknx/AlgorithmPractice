package UnitTest.datastructureTest.stringTest.stringCompareTest;

import DataStructure.string.stringCompare.RabinKarp;
import UnitTest.datastructureTest.stringTest.StringCompareTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-06 22:54
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class RabinKarpTest extends StringCompareTest {

    @Test//�����ƺ�������ѡ���й�ϵ
    public void testCompare(){
        super.testCompare(new RabinKarp());
    }

    @Test
    public void testcomparemethod(){//δ����
        RabinKarp rabinKarp = new RabinKarp();
        //rabinKarp.compare();
    }
}
