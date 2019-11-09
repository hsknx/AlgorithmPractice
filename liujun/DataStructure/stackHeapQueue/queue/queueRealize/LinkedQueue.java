package DataStructure.stackHeapQueue.queue.queueRealize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-09 22:56
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class LinkedQueue {

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

    public int peek(){
        int value = -1;
        //出队判空
        if(!empty()){
            value = front.value;
        }
        return value;
    }

    public int getRealsize(){
        return QueueRealsize;
    }

    public int getMaxsize(){
        return QueueMaxsize;
    }

    public boolean empty(){
        if(QueueRealsize == 0){
            return true;
        }
        return false;
    }
}