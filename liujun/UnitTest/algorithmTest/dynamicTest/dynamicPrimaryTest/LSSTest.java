package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.lss.LSS;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£∫ 2019-11-25 16:39
 * @author°™Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class LSSTest {

    LSS lss = new LSS();
    @Test
    public void Testmethod(){
        int sum = lss.LargestSumofSubSequence(demo01);
        assert sum == 39;
        sum = lss.LargestSumofSubSequence(demo02);
        assert sum == 233;
        sum = lss.LargestSumofSubSequence(demo03);
        assert sum == 0;
        sum = lss.LargestSumofSubSequence(demo04);
        assert sum == 0;
        sum = lss.LargestSumofSubSequence(demo05);
        assert sum == -1;
        sum = lss.LargestSumofSubSequence(demo06);
        assert sum == 22;
    }

    //≤‚ ‘”√¿˝
    int[] demo01 = {-1,-2,-3,4,5,6,7,8,9,-10,-11,-12};//39
    int[] demo02 = {27,-49,1,3,-6,8,12,-5,-6,78,2,-6,-2,15,47,
            1,5,-69,52,5,51,-48,1,56,-19,-8,48,15};//233
    int[] demo03 = {};//0
    int[] demo04 = null;//0
    int[] demo05 = {-1,-2,-3,-4};//-1
    int[] demo06 = {-1,-2,1,2,3,4,5,6,-3,-4,2,2,3,4,5,6};//22
}
