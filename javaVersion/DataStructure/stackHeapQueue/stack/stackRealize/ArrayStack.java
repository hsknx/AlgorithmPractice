package DataStructure.stackHeapQueue.stack.stackRealize;

import DataStructure.stackHeapQueue.stack.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-10-21 12:17
 * @author��Email liujunfirst@outlook.com
 * @description  ����ջ�Ļ���ʵ��
 */
public class ArrayStack implements Stack {

    public int[] stackValue;
    public int stackTop;
    public int maxSize;

    public ArrayStack(int num) {
        maxSize = num;
        stackTop = 0;
        stackValue = new int[maxSize];
    }

    public ArrayStack() {
        //default size is 50
        //new ArrayStack(50);����д���Ǵ���ģ���ֵ�����ŷ������˳�����ʧ
        maxSize = 50;
        stackTop = 0;
        stackValue = new int[maxSize];
    }

    public int pop() {
        //�ж�ջ��
        if(!this.empty()){
            return stackValue[--stackTop];
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

    public int getRealsize(){
        return stackTop;
    }

    public int getMaxsize(){
        return maxSize;
    }
}