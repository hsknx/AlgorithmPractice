package UnitTest.datastructureTest.stackHeapQueueTest.stackTest.stackRealizeTest;

import DataStructure.stackHeapQueue.stack.stackRealize.ArrayStack;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-09 12:53
 * @author��Email:liujunfirst@outlook.com
 * @description:
 */
public class ArrayStackTest {

    ArrayStack arrayStack = new ArrayStack(10);

    @Test
    public void methodTest(){
        //peek��������
        int value = arrayStack.peek();
        assert value == -1;
        value = arrayStack.pop();
        assert value == -1;
        //empty��������
        boolean flag = arrayStack.empty();
        assert flag;
        //size��������
        value = arrayStack.getRealsize();
        assert value == 0;
        flag = arrayStack.push(0);
        assert flag;
        //push��������
        for (int i = 1; i <= 9; i++) {
            flag = arrayStack.push(i);
        }
        assert flag;
        flag = arrayStack.empty();
        assert !flag;
        value = arrayStack.getRealsize();
        assert value == 10;
        flag = arrayStack.push(10);
        assert !flag;
        value = arrayStack.pop();
        assert value == 9;
        value = arrayStack.peek();
        assert value == 8;
        //search ��������
        flag = arrayStack.search(8);
        assert flag;
        flag = arrayStack.search(10);
        assert !flag;
        //pop��������
        for (int i = 1; i <= 9; i++) {
            arrayStack.pop();
        }
        flag = arrayStack.empty();
        assert flag;
        value = arrayStack.pop();
        assert value == -1;
        value = arrayStack.peek();
        assert value == -1;
        value = arrayStack.getRealsize();
        assert value == 0;
    }
}
