package stack.apply;

import stack.realize.StackbyArraylist;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-10-21 12:19
 * @author¡ªEmail:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class MinValueStackOpt extends StackbyArraylist {

    int miniStackValue;

    @Override
    public boolean pop() {
        if(!this.isEmpty()){
            int stackPeekValue = super.peek();
            miniStackValue = stackPeekValue < 0 ? miniStackValue - stackPeekValue : miniStackValue;
            super.pop();
        }
        return false;
    }

    @Override
    public boolean push(int value) {
        if(this.isEmpty()){
            miniStackValue = value;
            super.push(0);
        }else {
            int subValue = value - miniStackValue;
            super.push(subValue);
            miniStackValue = subValue < 0 ? value : miniStackValue;
        }
        return false;
    }

    @Override
    public int peek() {
        if(!this.isEmpty()){
            int stackPeekValue = super.peek();
            return stackPeekValue < 0 ? miniStackValue : stackPeekValue + miniStackValue;
        }
        return super.peek();
    }

    public int getMinValue(){
        return miniStackValue;
    }

    public static void main(String[] args) {
        MinValueStackOpt sa = new MinValueStackOpt();
        sa.push(5);
        sa.push(12);
        sa.push(3);
        System.out.println(sa.getMinValue());
        sa.push(10);
        System.out.println(sa.peek());;
        sa.pop();
        sa.push(1);
        System.out.println(sa.peek());;
        sa.pop();
        sa.pop();
        System.out.println(sa.getMinValue());
        System.out.println(sa.search(9));
        System.out.println(sa.search(12));
        System.out.println();
    }
}
