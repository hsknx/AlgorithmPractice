package DataStructure.stackHeapQueue.stack.stackRealize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-10-21 12:17
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description: 链表栈的基本实现
 */
public class StackbyLinkedlist {

    public Node stackTop;
    public int stackSize;
    public int stackMaxSize;

    public StackbyLinkedlist(int num){
        stackSize = 0;
        stackMaxSize = num;
        stackTop = null;
    }

    public StackbyLinkedlist(){
        stackSize = 0;
        //默认栈内容量50
        stackMaxSize = 50;
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
        //出栈判空
        if(!this.empty()){
            stackSize--;
            int value = stackTop.vlaue;
            stackTop = stackTop.next;
            return value;
        }
        return -1;
    }

    public boolean push(int value){
        //入栈判满
        Node node = new Node(value);
        if(stackSize == stackMaxSize){
            return false;
        }else{
            node.next = stackTop;
        }
        stackTop = node;
        stackSize++;
        return true;
    }

    public int peek(){
        return (stackTop == null && stackSize ==0) ? -1 : stackTop.vlaue;
    }

    public boolean empty(){
        return (stackTop == null && stackSize ==0) ? true : false;
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

    public int size(){
        return stackSize;
    }

}
