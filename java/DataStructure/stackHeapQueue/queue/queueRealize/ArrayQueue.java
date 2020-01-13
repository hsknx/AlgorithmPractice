package DataStructure.stackHeapQueue.queue.queueRealize;

import DataStructure.stackHeapQueue.queue.Queue;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-09 22:56
 * @author—Email:liujunfirst@outlook.com
 * @description:
 */
public class ArrayQueue implements Queue {

    public int[] queue;
    public int QueueRealsize;
    public int QueueMaxsize;
    public int front;
    public int tail;

    public ArrayQueue(){
        //默认队列容量50
        new ArrayQueue(50);
    }

    public ArrayQueue(int num){
        //默认队列容量50
        QueueMaxsize = num;
        queue = new int[QueueMaxsize];
        QueueRealsize = 0;
        front = tail = 0;
    }

    @Override
    public boolean offer(int value){
        //入队判满
        if(tail + 1 != front){
            queue[tail] = value;
            tail = (++tail) % QueueMaxsize;
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
            value = queue[front];
            front = (front + 1 + QueueMaxsize) % QueueMaxsize;
            QueueRealsize--;
        }
        return value;
    }

    //获取队首元素
    @Override
    public int peek(){
        int value = -1;
        //出队判空
        if(!empty()){
            value = queue[front];
        }
        return value;
    }

    @Override
    public int getRealsize(){
        return (tail + QueueMaxsize - front) % QueueMaxsize;
    }

    @Override
    public int getMaxsize(){
        return QueueMaxsize;
    }

    @Override
    public boolean empty(){
        return tail == front;
    }
}
