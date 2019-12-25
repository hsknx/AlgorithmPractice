package DataStructure.line.hashTable.hashTableRealize;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-25 22:22
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class HashTableNode {

    public int value;
    public HashTableNode next;

    public HashTableNode() {
        this.value = Integer.MIN_VALUE;
        next = null;
    }

    public HashTableNode(int value) {
        this.value = value;
        next = null;
    }
}
