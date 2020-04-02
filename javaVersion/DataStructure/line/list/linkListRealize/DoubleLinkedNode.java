package DataStructure.line.list.linkListRealize;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-12-07 17:26
 * @author—Email  liujunfirst@outlook.com
 * @description  双向链表(双向循环链表)
 * @blogURL
 */
public class DoubleLinkedNode {

    DoubleLinkedNode front = null;
    DoubleLinkedNode next = null;
    int value;

    public DoubleLinkedNode(){
        this.value = 0;
    }

    public DoubleLinkedNode(int value){
        this.value = value;
    }
}
