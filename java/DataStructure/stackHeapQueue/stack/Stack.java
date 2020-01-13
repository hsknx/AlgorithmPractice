package DataStructure.stackHeapQueue.stack;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-01-13 22:01
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public interface Stack {

    public int pop();

    public boolean push(int value);

    public int peek();

    public boolean empty();

    public boolean search(int value);

    public int getRealsize();

    public int getMaxsize();
}
