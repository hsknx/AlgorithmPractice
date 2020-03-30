package UnitTest.DatastructureTest.stringTest.stringCompareTest;

import DataStructure.string.stringCompare.RabinKarp;
import UnitTest.DatastructureTest.stringTest.StringCompareTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-12-06 22:54
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class RabinKarpTest extends StringCompareTestDemo {

    @Test//跟进制和素数的选择有关系
    public void testCompare(){
        super.testCompare(new RabinKarp());
    }



    public void testcomparemethod(){//未测试
        RabinKarp rabinKarp = new RabinKarp();
        //rabinKarp.compare(String source, String target, int prime, int HEX);
    }
}
