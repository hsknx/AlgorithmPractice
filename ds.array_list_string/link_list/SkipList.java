package link_list;

import java.util.Random;

/** 
 *@author liujun
 *@date： 2019-7-25 上午11:59:31
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@CSDN Blog URL:
 *@description:
 *@version 1.0
 */
public class SkipList {

	//头尾指针(满足头指针值为最小值，尾指针为最大值)
	SkipListNode head, tail;
	//跳跃表层高
	int SkipListlevel;
	//跳跃表总结点个数
	int SkipListnum;
	public static final int HEAD_KEY = Integer.MIN_VALUE;
	public static final int TAIL_KEY = Integer.MAX_VALUE;
	
	public SkipList() {
		// TODO Auto-generated constructor stub
		clear();
		head = initial();
		tail = head.next;
		SkipListlevel = 1;
	}
	
	public void clear(){
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
	
	public void add(int x) {

		if(find(x)){
			return;
		}
		SkipListNode insertKey;
		SkipListNode fathersln = null;
		//无需新建层数
		if(SkipListnum + 1 < (2 << SkipListlevel - 1)){
			int k = randomLevel();
			insertKey = head;
			for (int i = 0; i < k; i++) {
				insertKey = insertKey.down;
			}
		}else{//需要新建层数
			SkipListNode phead = initial();
			phead.down = head;
			phead.next.down = tail;
			head = phead;
			tail = phead.next;
			insertKey = head;
			SkipListlevel++;
		}
		while(insertKey != null){
			while(insertKey.next.value < x){
				insertKey = insertKey.next;
			}
			SkipListNode sln = new SkipListNode(x);
			if(fathersln != null){
				fathersln.down = sln;
			}
			sln.next = insertKey.next;
			insertKey.next = sln;
			insertKey = insertKey.down;
			fathersln = sln;
		}
		SkipListnum++;
	}
	
	public void delete(int x) {

		if(!find(x)){
			return;
		}
		SkipListNode point = head;
		SkipListNode prepoint = head;
		while (point.value != x) {
			while(point.next.value < x){
				prepoint = point;
				point = point.next;
			}
			if(point.value == x){
				break;
			}
			point = point.down;
			prepoint = prepoint.down;
			while (prepoint.next != point) {
				prepoint = prepoint.next;
			}
		}
		while (prepoint != null) {
			prepoint.next = prepoint.next.next;
			prepoint =  prepoint.down;
		}
	}
	
	public boolean find(int x) {

		SkipListNode point = head;
		while (true) {
			while(point.next.value <= x){
				point = point.next;
			}
			if(point.value == x){
				return true;
			}
			if(point.down == null){
				return false;
			}
			point = point.down;
		}
	}
	
	public int randomLevel() {
		Random r = new Random();
		return r.nextInt(SkipListlevel);
	}
	
	public void print(){
		SkipListNode point = head;
		while(point.down != null){
			point = point.down;
		}
		while(point.value != TAIL_KEY){
			if(point.value != HEAD_KEY){
				System.out.print(point.value + "-");
			}
			point = point.next;
		}
	}
	public static void main(String[] args) {
		SkipList l = new SkipList();
		for (int i = 25; i > 0; i--) {
			l.add(i);
		}
		System.out.println(l.SkipListlevel);
		for (int i = 0; i < 20; i++) {
			l.print();
			System.out.println();
		}
		System.out.println(l.find(22));
		System.out.println(l.find(13));
		System.out.println(l.find(102));
	}
}

//跳跃表结点
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