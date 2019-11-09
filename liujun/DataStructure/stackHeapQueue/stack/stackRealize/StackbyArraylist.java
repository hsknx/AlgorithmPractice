package DataStructure.stackHeapQueue.stack.stackRealize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-10-21 12:17
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description: 数组栈的基本实现
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
        //判断栈空
        if(!this.empty()){
            stackTop--;
            return stackValue[stackTop];
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

    public int size(){
        return stackTop;
    }
}
