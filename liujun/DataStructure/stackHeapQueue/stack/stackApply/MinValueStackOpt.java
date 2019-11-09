package DataStructure.stackHeapQueue.stack.stackApply;

import DataStructure.stackHeapQueue.stack.stackRealize.ArrayStack;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-10-21 12:19
 * @author¡ªEmail:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class MinValueStackOpt extends ArrayStack {

    int miniStackValue;

    @Override
    public int pop() {
        if(!this.empty()){
            int peekValue = super.peek();
            miniStackValue = peekValue < 0 ? miniStackValue - peekValue : miniStackValue;
            return super.pop();
        }
        return -1;
    }

    @Override
    public boolean push(int value) {
        if(this.empty()){
            miniStackValue = value;
            super.push(0);
        }else {
            int pushValue = value - miniStackValue;
            super.push(pushValue);
            miniStackValue = pushValue < 0 ? value : miniStackValue;
        }
        return false;
    }

    @Override
    public int peek() {
        if(!this.empty()){
            int stackPeekValue = super.peek();
            return stackPeekValue < 0 ? miniStackValue : stackPeekValue + miniStackValue;
        }
        return super.peek();
    }

    public int getMinValue(){
        if(!this.empty()){
            return miniStackValue;
        }
        return -1;
    }
}
