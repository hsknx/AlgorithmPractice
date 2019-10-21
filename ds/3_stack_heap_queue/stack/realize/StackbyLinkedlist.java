package stack.realize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-10-21 12:17
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:链表栈一共有5个方法：pop、push、peek、empty、search.
 */
public class StackbyLinkedlist {

    public Node stackTop;

    public StackbyLinkedlist(){
        stackTop = null;
    }

    private static class Node{
        int vlaue;
        Node next;
        public Node(int value){
            this.vlaue = value;
            this.next = null;
        }
    }

    public int pop(){
        if(stackTop != null){
            int value = stackTop.vlaue;
            stackTop = stackTop.next;
            return value;
        }
        return -1;
    }

    public void push(int value){

        Node node = new Node(value);
        if(stackTop == null){
            stackTop = node;
        }else{
            node.next = stackTop;
            stackTop = node;
        }
    }

    public int peek(){
        return stackTop != null ? stackTop.vlaue : -1;
    }

    public boolean empty(){
        return stackTop == null ? true : false;
    }

    public boolean search(int value){
        Node test = stackTop;
        while (test != null){
            if(test.vlaue == value){
                return true;
            }
            test = test.next;
        }
        return false;
    }

    public static void main(String[] args) {
        StackbyLinkedlist sa = new StackbyLinkedlist();
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
