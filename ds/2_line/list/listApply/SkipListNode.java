package list.listApply;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-18 02:49
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
//��Ծ�����
class SkipListNode{

    int value;
    SkipListNode next;
    SkipListNode down;

    public SkipListNode() {

        this.value = Integer.MIN_VALUE;
        next = null;
        down = null;
    }

    public SkipListNode(int value) {

        this.value = value;
        next = null;
        down = null;
    }
}
