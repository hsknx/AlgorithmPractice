package UnitTest.DatastructureTest.stackHeapQueueTest.queueTest.queueRealizeTest;

import DataStructure.stackHeapQueue.queue.queueRealize.ArrayQueue;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-09 22:56
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
public class ArrayQueueTest {

    ArrayQueue arrayQueue = new ArrayQueue(10);

    @Test
    public void methodTest(){

        boolean flag = arrayQueue.empty();
        assert flag;
        int value = arrayQueue.poll();
        assert value == -1;
        value = arrayQueue.peek();
        assert value == -1;
        value = arrayQueue.getRealsize();
        assert value == 0;
        flag = arrayQueue.offer(0);
        assert flag;
        //入队测试
        for (int i = 1; i <= 9; i++) {
            arrayQueue.offer(i);
            if(i == 5){
                flag = arrayQueue.empty();
                assert !flag;
                value = arrayQueue.poll();
                assert value == 0;
                value = arrayQueue.peek();
                assert value == 1;
                value = arrayQueue.getRealsize();
                assert value == 5;
            }
        }
        flag = arrayQueue.offer(10);
        assert !flag;
        flag = arrayQueue.offer(11);
        assert !flag;
        //出队测试，此时队列内队首至队尾[1,2,3,4,5,6,7,8,9]
        for (int i = 1; i <= 8; i++) {
            arrayQueue.poll();
            if(i == 5){
                flag = arrayQueue.empty();
                assert !flag;
                value = arrayQueue.poll();
                assert value == 6;
                value = arrayQueue.peek();
                assert value == 7;
                value = arrayQueue.getRealsize();
                assert value == 3;
            }
        }
        value = arrayQueue.poll();
        assert value == -1;
        flag = arrayQueue.empty();
        assert flag;
        value = arrayQueue.poll();
        assert value == -1;
        value = arrayQueue.peek();
        assert value == -1;
        value = arrayQueue.getRealsize();
        assert value == 0;
    }
}
