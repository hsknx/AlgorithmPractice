package UnitTest.datastructureTest.stringTest.stringCompareTest;

import DataStructure.string.stringCompare.RabinKarp;
import UnitTest.datastructureTest.stringTest.StringCompareTest;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-06 22:54
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class RabinKarpTest extends StringCompareTest {

    @Test
    public void testCompare(){
        super.testCompare(new RabinKarp());
    }
}
