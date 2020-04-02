package DataStructure.stackHeapQueue.queue.queueRealize;

import DataStructure.stackHeapQueue.queue.Queue;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 22:56
 * @author—Email liujunfirst@outlook.com
 * @description 
 */
public class LinkedQueue implements Queue {

    public int QueueRealsize;
    public int QueueMaxsize;
    public LinkedQueueNode front;
    public LinkedQueueNode tail;

    private class LinkedQueueNode{
        int value;
        LinkedQueueNode next;
        LinkedQueueNode(int value){
            this.value = value;
            this.next = null;
        }
    }

    public LinkedQueue(){
        //默认队列最大容量为50
        new LinkedQueue(50);
    }

    public LinkedQueue(int num){
        QueueRealsize = 0;
        QueueMaxsize = num;
        front = tail = null;
    }

    @Override
    public boolean offer(int value){
        //入队判满
        if(QueueRealsize < QueueMaxsize){
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(value);
            //第一次入队
            if(QueueRealsize == 0){
                front = linkedQueueNode;
            }else{
                tail.next = linkedQueueNode;
            }
            tail = linkedQueueNode;
            QueueRealsize++;
            return true;
        }
        return false;
    }

    @Override
    public int poll(){
        int value = -1;
        //出队判空
        if(!empty()){
           value = front.value;
           front = front.next;
           QueueRealsize--;
        }
        return value;
    }

    @Override
    public int peek(){
        int value = -1;
        //出队判空
        if(!empty()){
            value = front.value;
        }
        return value;
    }

    @Override
    public int getRealsize(){
        return QueueRealsize;
    }

    @Override
    public int getMaxsize(){
        return QueueMaxsize;
    }

    @Override
    public boolean empty(){
        if(QueueRealsize == 0){
            return true;
        }
        return false;
    }
}