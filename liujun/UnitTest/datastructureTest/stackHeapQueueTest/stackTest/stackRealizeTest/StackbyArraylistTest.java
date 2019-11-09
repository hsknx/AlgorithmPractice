package UnitTest.datastructureTest.stackHeapQueueTest.stackTest.stackRealizeTest;

import DataStructure.stackHeapQueue.stack.stackRealize.StackbyArraylist;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-09 12:53
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class StackbyArraylistTest {


    StackbyArraylist stackbyArraylist = new StackbyArraylist(10);

    @Test
    public void methodTest(){
        //peek��������
        int value = stackbyArraylist.peek();
        assert value == -1;
        value = stackbyArraylist.pop();
        assert value == -1;
        //empty��������
        boolean flag = stackbyArraylist.empty();
        assert flag;
        //size��������
        value = stackbyArraylist.size();
        assert value == 0;
        flag = stackbyArraylist.push(0);
        assert flag;
        //push��������
        for (int i = 1; i <= 9; i++) {
            flag = stackbyArraylist.push(i);
        }
        assert flag;
        flag = stackbyArraylist.empty();
        assert !flag;
        value = stackbyArraylist.size();
        assert value == 10;
        flag = stackbyArraylist.push(10);
        assert !flag;
        value = stackbyArraylist.pop();
        assert value == 9;
        value = stackbyArraylist.peek();
        assert value == 8;
        //search ��������
        flag = stackbyArraylist.search(8);
        assert flag;
        flag = stackbyArraylist.search(10);
        assert !flag;
        //pop��������
        for (int i = 1; i <= 9; i++) {
            stackbyArraylist.pop();
        }
        flag = stackbyArraylist.empty();
        assert flag;
        value = stackbyArraylist.pop();
        assert value == -1;
        value = stackbyArraylist.peek();
        assert value == -1;
        value = stackbyArraylist.size();
        assert value == 0;
    }
}
