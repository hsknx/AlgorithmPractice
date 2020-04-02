package UnitTest.DatastructureTest.stringTest.stringCompareTest;

import DataStructure.string.stringCompare.KMP;
import UnitTest.DatastructureTest.stringTest.StringCompareTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-06 22:54
 * @author¡ªEmail liujunfirst@outlook.com
 * @description 
 * @blogURL
 */
public class KMPTest extends StringCompareTestDemo {

    @Test
    public void testCompare(){
        super.testCompare(new KMP());
    }
}
