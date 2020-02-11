package UnitTest.algorithmTest.combineTest.shortestDeliveryPathTest;

import Algorithm.comprehensive.shortestDeliveryPath.ShortPath_Greedy;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2020-02-11 14:34
 * @author—Email: liujunfirst@outlook.com
 * @description: 送货最短路径_贪心算法_UT ShortestDeliveryPath
 * @blogURL:
 */
public class ShortPath_GreedyTest extends ShortPathTestDemo{
    @Test
    public void shortPath(){
        super.shortPath(new ShortPath_Greedy());
    }
}
