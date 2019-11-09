package UnitTest.datastructureTest.stackHeapQueueTest.stackTest.stackRealizeTest;

import DataStructure.stackHeapQueue.stack.stackRealize.StackbyLinkedlist;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-09 12:53
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class StackbyLinkedlistTest {



    StackbyLinkedlist StackbyLinkedlist = new StackbyLinkedlist(10);

    @Test
    public void methodTest(){
        //peek��������
        int value = StackbyLinkedlist.peek();
        assert value == -1;
        value = StackbyLinkedlist.pop();
        assert value == -1;
        //empty��������
        boolean flag = StackbyLinkedlist.empty();
        assert flag;
        //size��������
        value = StackbyLinkedlist.size();
        assert value == 0;
        flag = StackbyLinkedlist.push(0);
        assert flag;
        //push��������
        for (int i = 1; i <= 9; i++) {
            flag = StackbyLinkedlist.push(i);
        }
        assert flag;
        flag = StackbyLinkedlist.empty();
        assert !flag;
        value = StackbyLinkedlist.size();
        assert value == 10;
        flag = StackbyLinkedlist.push(10);
        assert !flag;
        value = StackbyLinkedlist.pop();
        assert value == 9;
        value = StackbyLinkedlist.peek();
        assert value == 8;
        //search ��������
        flag = StackbyLinkedlist.search(8);
        assert flag;
        flag = StackbyLinkedlist.search(10);
        assert !flag;
        //pop��������
        for (int i = 1; i <= 9; i++) {
            StackbyLinkedlist.pop();
        }
        flag = StackbyLinkedlist.empty();
        assert flag;
        value = StackbyLinkedlist.pop();
        assert value == -1;
        value = StackbyLinkedlist.peek();
        assert value == -1;
        value = StackbyLinkedlist.size();
        assert value == 0;
    }
}
