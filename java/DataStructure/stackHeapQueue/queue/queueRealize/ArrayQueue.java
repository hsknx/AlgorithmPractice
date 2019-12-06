package DataStructure.stackHeapQueue.queue.queueRealize;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-09 22:56
 * @author��Email:liujunfirst@outlook.com
 * @description:
 */
public class ArrayQueue {

    public int[] queue;
    public int QueueRealsize;
    public int QueueMaxsize;
    public int front;
    public int tail;

    public ArrayQueue(){
        //Ĭ�϶�������50
        new ArrayQueue(50);
    }

    public ArrayQueue(int num){
        //Ĭ�϶�������50
        QueueMaxsize = num;
        queue = new int[QueueMaxsize];
        QueueRealsize = 0;
        front = tail = 0;
    }

    public boolean offer(int value){
        //�������
        if(tail + 1 != front){
            queue[tail] = value;
            tail = (++tail) % QueueMaxsize;
            QueueRealsize++;
            return true;
        }
        return false;
    }

    public int poll(){
        int value = -1;
        //�����п�
        if(!empty()){
            value = queue[front];
            front = (front + 1 + QueueMaxsize) % QueueMaxsize;
            QueueRealsize--;
        }
        return value;
    }

    //��ȡ����Ԫ��
    public int peek(){
        int value = -1;
        //�����п�
        if(!empty()){
            value = queue[front];
        }
        return value;
    }

    public int getRealsize(){
        return (tail + QueueMaxsize - front) % QueueMaxsize;
    }

    public int getMaxsize(){
        return QueueMaxsize;
    }

    public boolean empty(){
        return tail == front;
    }
}