package DataStructure.line.list.linkListRealize;

import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date： 2018-8-22 下午02:06:33
 *@author—Email:liujunfirst@outlook.com
 *@description: 环链表
 *1. 尾插法改写为构造有环链表
 *2. 判断单聊表是否有环
 *3. 找出带环单链表的入口
 *4. 构造相交链表
 *5. 判断两个链表是否相交
 *6. 找出两个链表的交点
 *@version 1.0
 */

public class RangList extends SinglyLinkedList{

	public RangList(int value) {
		//super(value);
	}
	
	@Override
	//尾插法改写为构造有环链表
	public SinglyLinkedNode insertTail(int[] list) {
		System.out.println("尾插法改写为构造有环链表");
		SinglyLinkedNode point = null;
		SinglyLinkedNode first = point;
		//环入口结点
		SinglyLinkedNode temp = new SinglyLinkedNode();
		//尾插法，循环赋值
		for (int i = 0; i < list.length; i++) {
			SinglyLinkedNode link = new SinglyLinkedNode(list[i]);
			//首次判断
			if (first == null) {
				first = point = link;
			}
			//环入口结点
			if(i == list.length/2){
				temp = link;
				System.out.println("插入点："+temp.value);
			}
			point.next = link;
			point = point.next;
		}
		//为节点构造环
		point.next = temp;
		return first;
	}
             
	//判断单链表是否有环
	public boolean FindListTail(SinglyLinkedNode first) {
		// TODO Auto-generated method stub
		SinglyLinkedNode slow = first;
		SinglyLinkedNode fast = first;
		
		while (fast.next != null && fast != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	//返回单链表环的相遇点
	public SinglyLinkedNode ListMeet(SinglyLinkedNode first) {
		
		SinglyLinkedNode slow = first;
		SinglyLinkedNode fast = first;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return fast;
			}
		}
		return null;
	}
	
	//找出带环单链表的入口
	public SinglyLinkedNode findLoopPort(SinglyLinkedNode first) {
		// TODO Auto-generated method stub

		SinglyLinkedNode point_meet = ListMeet(first);
		while(first != null && point_meet != null){
			if(first == point_meet){
				return point_meet;
			}
			first = first.next;
			point_meet = point_meet.next;
		}
		return null;
	}
	
	//构造相交链表
	public Map<Integer, SinglyLinkedNode> buildCrossLink(int[] array_a, int[] array_b) {
		// TODO Auto-generated method stub

		//思路：把a链表构造完，插入到b的一半，需要a链表的尾指针和b链表的一半指针
		//构造a链表——尾插法
		SinglyLinkedNode tail = null;
		SinglyLinkedNode first_a = tail;
		for (int i = 0; i < array_a.length; i++) {
			SinglyLinkedNode link_a = new SinglyLinkedNode(array_a[i]);
			//首次判断
			if (first_a == null) {
				first_a = tail = link_a;
			}
			tail.next = link_a;
			tail = tail.next;
		}
		//构造b链表——头插法
		SinglyLinkedNode first_b = null;
		for (int i = 0; i < array_b.length; i++) {
			SinglyLinkedNode link_b = new SinglyLinkedNode(array_b[i]);
			if(i == array_b.length/2){
				tail.next = link_b;
				System.out.println("交点值是： "+array_b[i]);
			}
			link_b.next = first_b;
			first_b = link_b;
		}
		Map<Integer, SinglyLinkedNode> map = new HashMap<Integer, SinglyLinkedNode>();
		map.put(1, first_a);
		map.put(2, first_b);
		return map;
	}
	
	//判断两个链表是否相交
	public boolean judgeCrossLink(SinglyLinkedNode first, SinglyLinkedNode second) {
		// TODO Auto-generated method stub
		//判断尾指针是否相同
		while (first.next != null) {
			first = first.next;
		}
		while (second.next != null) {
			second = second.next;
		}
		if(first == second){
			return true;
		}
		return false;
	}
	
	//找出两个链表的交点
	public int getCrossPoint(SinglyLinkedNode first, SinglyLinkedNode second) {
		// TODO Auto-generated method stub

		SinglyLinkedNode p1 = first;
		SinglyLinkedNode p2 = second;
		int count1 = 0;
		int count2 = 0;
		int way = 0;
		
		while (first.next != null) {
			first = first.next;
			count1++;
		}
		while (second.next != null) {
			second = second.next;
			count2++;
		}
		if(count1 - count2 > 0){
			way = count1 - count2;
			first = p1;
			second = p2;
		}else{
			way = count2 - count1;
			first = p2;
			second = p1;
		}
		while(way > 0){
			first = first.next;
			way--;
		}
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first.value;
	}
	
	//主方法测试
	public static void main(String[] args) {
		
		//构造有环单链表
		int[] array1 = {1,2,3,4,5,6,7,8,9,10};
		int[] array2 = {11,12,13,14,15,16,17,18,19,20};
		RangList rl = new RangList(0);
		System.out.println("构造有环单链表");
		SinglyLinkedNode first= rl.insertTail(array1);
		
		//测试单链表是否有环
		System.out.println("单链表是否有环");
		System.out.println(rl.FindListTail(first));
		System.out.println("单链表环的入口结点：");
		System.out.println(rl.ListMeet(first).value);
	
		//构造两个单链表相交
		Map<Integer, SinglyLinkedNode> map = rl.buildCrossLink(array1, array2);
		System.out.println("两个单链表是否相交");
		System.out.println(rl.judgeCrossLink(map.get(1), map.get(2)));
		System.out.println("两个单链表相交结点：");
		System.out.println(rl.getCrossPoint(map.get(1), map.get(2)));
	}
}
