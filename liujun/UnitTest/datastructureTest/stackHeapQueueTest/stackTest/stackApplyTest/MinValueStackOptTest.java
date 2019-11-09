package UnitTest.datastructureTest.stackHeapQueueTest.stackTest.stackApplyTest;

import DataStructure.stackHeapQueue.stack.stackApply.MinValueStackOpt;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-11-09 12:52
 * @author¡ªEmail:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class MinValueStackOptTest {

    MinValueStackOpt minValueStackOpt = new MinValueStackOpt();

    @Test
    public void getMinValueTest(){
        minValueStackOpt.push(7);
        minValueStackOpt.push(9);
        minValueStackOpt.push(8);
        int value = minValueStackOpt.getMinValue();
        assert value == 7;

        minValueStackOpt.push(5);
        minValueStackOpt.push(3);
        minValueStackOpt.push(4);
        value = minValueStackOpt.getMinValue();
        assert value == 3;

        for (int i = 1; i <= 4; i++) {
            minValueStackOpt.pop();
        }

        value = minValueStackOpt.getMinValue();
        assert value == 7;

        minValueStackOpt.push(21);
        value = minValueStackOpt.getMinValue();
        assert value == 7;

        minValueStackOpt.push(1);
        value = minValueStackOpt.getMinValue();
        assert value == 1;

        for (int i = 1; i <= 4; i++) {
            minValueStackOpt.pop();
        }
        value = minValueStackOpt.pop();
        assert value == -1;
        value = minValueStackOpt.getMinValue();
        assert value == -1;
    }
}
