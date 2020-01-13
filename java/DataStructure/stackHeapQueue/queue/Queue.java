package DataStructure.stackHeapQueue.queue;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-01-13 21:52
 * @author¡ªEmail: liujunfirst@outlook.com
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
