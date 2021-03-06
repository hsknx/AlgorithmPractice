package DataStructure.stackHeapQueue.stack.stackRealize;

import DataStructure.stackHeapQueue.stack.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-10-21 12:17
 * @author—Email liujunfirst@outlook.com
 * @description  数组栈的基本实现
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
        //new ArrayStack(50);这种写法是错误的，赋值会随着方法的退出而消失
        maxSize = 50;
        stackTop = 0;
        stackValue = new int[maxSize];
    }

    public int pop() {
        //判断栈空
        if(!this.empty()){
            return stackValue[--stackTop];
        }
        return  -1;
    }

    public boolean push(int value) {
        //判断栈满
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
        //因为出栈的时候没有对栈内容清除
        // 所以search的时候需要在限定范围内查询
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
