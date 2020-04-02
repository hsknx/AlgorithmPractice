package DataStructure.line.list.listApply;

import java.util.Random;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-7-25 上午11:59:31
 * @author—Email liujunfirst@outlook.com
 * @CSDN Blog URL:
 * @description 
 */
public class SkipList {

    //头尾指针(满足头指针值为最小值，尾指针为最大值)
    SkipListNode head, tail;
    //跳跃表层高
    public int SkipListlevel;
    //跳跃表总结点个数
    public int SkipListnum;
    public static final int HEAD_KEY = Integer.MIN_VALUE;
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public SkipList() {
        clear();
        head = initial();
        tail = head.next;
        SkipListlevel = 1;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public SkipListNode initial() {
        // TODO Auto-generated method stub
        SkipListNode phead = new SkipListNode();
        SkipListNode ptail = new SkipListNode();
        phead.value = HEAD_KEY;
        ptail.value = TAIL_KEY;
        phead.next = ptail;
        return phead;
    }

    public void add(int Value) {

        if (find(Value)) {
            return;
        }
        SkipListNode insertKey;
        SkipListNode fathersln = null;
        /* 经过实验证明：查找 耗时 比 插入 更加耗时。
        层数越高，整个数据备份越多，越臃肿，但是查找快、插入和删除慢
		层数越低，整个数据备份越少，      但是查找慢、插入和删除快
		综合考虑，建议层数高
		*/

        //无需新建层数
        if (SkipListnum <= (2 << SkipListlevel - 1)) {
            int k = randomLevel();
            insertKey = head;
            for (int i = 0; i < k; i++) {
                insertKey = insertKey.down;
            }
        } else {//需要新建层数
            SkipListNode phead = initial();
            phead.down = head;
            phead.next.down = tail;
            head = phead;
            tail = phead.next;
            insertKey = head;
            SkipListlevel++;
        }
        //向下补全所有的插入节点
        while (insertKey != null) {
            while (insertKey.next.value < Value) {
                insertKey = insertKey.next;
            }
            SkipListNode sln = new SkipListNode(Value);
            if (fathersln != null) {
                fathersln.down = sln;
            }
            sln.next = insertKey.next;
            insertKey.next = sln;
            insertKey = insertKey.down;
            fathersln = sln;
        }
        SkipListnum++;
    }

    public boolean delete(int x) {

        //快表层高降级
        if (head.next == tail && head.down != null) {
            head = head.down;
            tail = tail.down;
            this.SkipListlevel--;
        }
        //注意顺序：先降级、再判断不然会出现最后一个元素删除了，但是表级仍然不为1
		if (!find(x)) {
			return false;
		}
        SkipListNode point = head;
        SkipListNode prepoint = point;


        //横向查找
        while (point.value != x) {
            while (point.next.value <= x) {
                prepoint = point;
                point = point.next;
            }
            if (point.value == x) {
                break;
            }
            point = point.down;
            prepoint = prepoint.down;
            if (point.equals(prepoint)) {
                continue;
            }
            while (prepoint.next != point) {
                prepoint = prepoint.next;
            }
        }
        //纵向删除
        while (prepoint != null) {

            point = point.down;
            prepoint.next = prepoint.next.next;
            prepoint = prepoint.down;
            //循环至最低点结束
            while (prepoint != null && prepoint.next != point) {
                prepoint = prepoint.next;
            }
        }
        this.SkipListnum--;
        return true;
    }

    public boolean find(int x) {

        SkipListNode point = head;
        while (true) {
            while (point.next.value <= x) {
                point = point.next;
            }
            if (point.value == x) {
                return true;
            }
            if (point.down == null) {//到达最底层
                return false;
            }
            point = point.down;
        }
    }

    public int randomLevel() {
        Random r = new Random();
        return r.nextInt(SkipListlevel);
    }

    public void print() {//输出链表的整体结构
        SkipListNode point;
        SkipListNode headpoint = head;
        while (headpoint != null) {
            point = headpoint;
            while (point.value != TAIL_KEY) {
                if (point.value != HEAD_KEY) {
                    System.out.print(point.value + "-");
                }
                point = point.next;
            }
            System.out.println();
            headpoint = headpoint.down;
        }
    }
}