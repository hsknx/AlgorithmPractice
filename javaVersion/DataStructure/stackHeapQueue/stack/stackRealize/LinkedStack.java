package DataStructure.stackHeapQueue.stack.stackRealize;

import DataStructure.stackHeapQueue.stack.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-10-21 12:17
 * @author—Email liujunfirst@outlook.com
 * @description  链表栈的基本实现
 */
public class LinkedStack implements Stack {

    public Node stackTop;
    public int stackRealSize;
    public int stackMaxSize;

    public LinkedStack(int num){
        stackRealSize = 0;
        stackMaxSize = num;
        stackTop = null;
    }

    public LinkedStack(){
        //默认栈内容量50
        new LinkedStack(50);
    }

    private class Node{
        int vlaue;
        Node next;
        Node(int value){
            this.vlaue = value;
            this.next = null;
        }
    }

    public int pop(){
        //出栈判空
        if(!this.empty()){
            stackRealSize--;
            int value = stackTop.vlaue;
            stackTop = stackTop.next;
            return value;
        }
        return -1;
    }

    public boolean push(int value){
        //入栈判满
        Node node = new Node(value);
        if(stackRealSize == stackMaxSize){
            return false;
        }else{
            node.next = stackTop;
        }
        stackTop = node;
        stackRealSize++;
        return true;
    }

    public int peek(){
        return (stackTop == null && stackRealSize ==0) ? -1 : stackTop.vlaue;
    }

    public boolean empty(){
        return (stackTop == null && stackRealSize ==0) ? true : false;
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

    public int getRealsize(){
        return stackRealSize;
    }

    public int getMaxsize(){
        return stackMaxSize;
    }

}
