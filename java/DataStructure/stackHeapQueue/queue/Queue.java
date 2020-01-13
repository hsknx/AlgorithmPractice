package DataStructure.stackHeapQueue.queue;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-01-13 21:52
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public interface Queue {

    public boolean offer(int value);

    public int poll();

    public int peek();

    public boolean empty();

    public int getRealsize();

    public int getMaxsize();
}
