package DataStructure.line.list.linkListRealize;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-12-07 18:17
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * 1、双向链表的插入
 * 2、双向链表删除
 * 3、双向链表查找
 * 4、双向链表转数组
 * @blogURL:
 */
public class DoubleLinkedList {

    DoubleLinkedNode headpoint = null;
    DoubleLinkedNode tailpoint = null;
    int size;

    public DoubleLinkedList(){
        size = 0;
    }

    //双向链表插入——头插法
    public DoubleLinkedList insertHead(int[] array){
        DoubleLinkedList head = new DoubleLinkedList();
        if(array == null || array.length == 0){
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            DoubleLinkedNode node = new DoubleLinkedNode(array[i]);
            //修复 前表首节点
            node.next = head.headpoint;
            node.next.front = node;
            //修复 表首节点
            head.headpoint = node;
            node.front = head.tailpoint;
            //修复 尾节点
            head.tailpoint.next = node;
            this.size++;
        }

        return head;
    }

    //双向链表插入——尾插法
    public DoubleLinkedList insertTail(int[] array){
        DoubleLinkedList head = null;
        return head;
    }

    //双向链表插入——单个元素插入
    public DoubleLinkedList insert(DoubleLinkedList head, int value){
        return head;
    }

    //双向链表的查找——查找某元素
    public int findValue(int value){
        return -1;
    }

    //双向链表的查找——查找某位置是否有元素
    public int findIndex(int index){
        return -1;
    }

    //双向链表的删除——删除某元素
    public int deleteValue(int value){
        return -1;
    }

    //双向链表的删除——删除某位置
    public int deleteIndex(int index){
        return -1;
    }

    //双向链表转数组
    public int[] transtoArray(DoubleLinkedList head){
        int[] array = new int[head.size];
        return array;
    }
}
