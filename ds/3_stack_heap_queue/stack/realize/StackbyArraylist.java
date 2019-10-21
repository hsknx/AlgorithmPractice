package stack.realize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-10-21 12:17
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:数组栈一共有5个方法：pop、push、peek、empty、search.
 */
public class StackbyArraylist {

    int[] stackValue;
    int stackTop;

    public StackbyArraylist(int num) {
        stackValue = new int[num];
        stackTop = 0;
    }

    public StackbyArraylist() {
        //default size is 50
        stackValue = new int[50];
        stackTop = 0;
    }

    public boolean isEmpty() {
        return this.stackTop == 0 ? true : false;
    }

    public boolean pop() {
        if(!this.isEmpty()){
            stackTop--;
            return true;
        }
        return  false ;
    }

    public boolean push(int value) {

        if(this.stackTop < stackValue.length){
            stackValue[stackTop++] = value;
            return true;
        }
        return  false;
    }

    public int peek() {
        return this.isEmpty() ? -1 : stackValue[stackTop - 1];
    }

    public boolean search(int value) {
        //因为出栈的时候没有对栈内容清楚所以search的时候需要在限定范围内查询
        for (int i = 0; i < stackTop; i++){
            if (value == stackValue[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StackbyArraylist sa = new StackbyArraylist();
        sa.push(12);
        sa.push(11);
        sa.push(10);
        System.out.println(sa.peek());;
        sa.pop();
        sa.push(9);
        System.out.println(sa.peek());;
        sa.pop();
        sa.pop();
        System.out.println(sa.search(11));
        System.out.println(sa.search(9));
        System.out.println(sa.search(12));
        System.out.println();
    }
}
