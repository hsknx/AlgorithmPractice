package UnitTest.DatastructureTest.stackHeapQueueTest.queueTest.queueRealizeTest;

import DataStructure.stackHeapQueue.queue.queueRealize.LinkedQueue;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-09 22:57
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
public class LinkedQueueTest {
    
    LinkedQueue linkedQueue = new LinkedQueue(10);

    @Test
    public void methodTest(){

        boolean flag = linkedQueue.empty();
        assert flag;
        int value = linkedQueue.poll();
        assert value == -1;
        value = linkedQueue.peek();
        assert value == -1;
        value = linkedQueue.getRealsize();
        assert value == 0;
        flag = linkedQueue.offer(0);
        assert flag;
        //入队测试
        for (int i = 1; i <= 9; i++) {
            linkedQueue.offer(i);
            if(i == 5){
                flag = linkedQueue.empty();
                assert !flag;
                value = linkedQueue.poll();
                assert value == 0;
                value = linkedQueue.peek();
                assert value == 1;
                value = linkedQueue.getRealsize();
                assert value == 5;
            }
        }
        flag = linkedQueue.offer(10);
        assert flag;
        flag = linkedQueue.offer(11);
        assert !flag;
        //出队测试，此时队列内队首至队尾[1,2,3,4,5,6,7,8,9,10]
        for (int i = 1; i <= 9; i++) {
            linkedQueue.poll();
            if(i == 5){
                flag = linkedQueue.empty();
                assert !flag;
                value = linkedQueue.poll();
                assert value == 6;
                value = linkedQueue.peek();
                assert value == 7;
                value = linkedQueue.getRealsize();
                assert value == 4;
            }
        }
        value = linkedQueue.poll();
        assert value == -1;
        flag = linkedQueue.empty();
        assert flag;
        value = linkedQueue.poll();
        assert value == -1;
        value = linkedQueue.peek();
        assert value == -1;
        value = linkedQueue.getRealsize();
        assert value == 0;
    }
}