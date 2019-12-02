package UnitTest.algorithmTest.dynamicTest.dynamicPrimaryTest;

import Algorithm.dynamic.dynamicPrimary.SpacerExtract;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 16:41
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class SpacerExtractTest {

    SpacerExtract spacerExtract = new SpacerExtract();
    @Test
    public void Testmethod(){

        int result = spacerExtract.method(demo01);
        assert result == 18;
        result = spacerExtract.method(demo02);
        assert result == 0;
        result = spacerExtract.method(demo03);
        assert result == 0;
        result = spacerExtract.method(demo04);
        assert result == 352;
    }

    //��������
    int[] demo01 = {5,2,6,3,1,7};//ѡ��5��6��7,result = 18
    int[] demo02 = {};//result = 0
    int[] demo03 = null;//result = 0
    //����9��β�ģ�result = 352
    int[] demo04 = {9,1,19,5,2,29,3,3,39,4,1,49,5,59,36,6,69,56,7,79};
}
