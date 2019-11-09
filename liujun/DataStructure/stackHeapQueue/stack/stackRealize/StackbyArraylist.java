package DataStructure.stackHeapQueue.stack.stackRealize;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-21 12:17
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description: ����ջ�Ļ���ʵ��
 */
public class StackbyArraylist {

    int[] stackValue;
    int stackTop;
    int maxSize;

    public StackbyArraylist(int num) {
        maxSize = num;
        stackValue = new int[maxSize];
        stackTop = 0;
    }

    public StackbyArraylist() {
        //default size is 50
        maxSize = 50;
        stackValue = new int[maxSize];
        stackTop = 0;
    }

    public int pop() {
        //�ж�ջ��
        if(!this.empty()){
            stackTop--;
            return stackValue[stackTop];
        }
        return  -1;
    }

    public boolean push(int value) {
        //�ж�ջ��
        if(this.stackTop < maxSize){
            stackValue[stackTop++] = value;
            return true;
        }
        return  false;
    }

    public int peek() {
        return this.empty() ? -1 : stackValue[stackTop - 1];
    }

    public boolean empty() {
        return this.stackTop == 0 ? true : false;
    }

    public boolean search(int value) {
        //��Ϊ��ջ��ʱ��û�ж�ջ�������
        // ����search��ʱ����Ҫ���޶���Χ�ڲ�ѯ
        for (int i = 0; i < stackTop; i++){
            if (value == stackValue[i]){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return stackTop;
    }
}
