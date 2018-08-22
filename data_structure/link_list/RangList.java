package link_list;
/** 
 *@author liujun
 *@date�� 2018-8-22 ����02:06:33
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *1. �жϵ��ı��Ƿ��л�
 *2. �ҳ���������������
 *@version 1.0
 */
public class RangList extends SinglyLinkedList{

	public RangList(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	//β�巨��дΪ�����л�����
	public SinglyLinkedList insertTail(int[] list) {
		System.out.println("β�巨��дΪ�����л�����");
		SinglyLinkedList point = null;
		SinglyLinkedList first = point;
		//����ڽ��
		SinglyLinkedList temp = new SinglyLinkedList();
		//β�巨��ѭ����ֵ
		for (int i = 0; i < list.length; i++) {
			SinglyLinkedList link = new SinglyLinkedList(list[i]);
			//�״��ж�
			if (first == null) {
				first = point = link;
			}
			//����ڽ��
			if(i == list.length/2){
				temp = link;
				System.out.println("����㣺"+temp.value);
			}
			point.next = link;
			point = point.next;
		}
		//Ϊ�ڵ㹹�컷
		point.next = temp;
		return first;
	}
             
	//�жϵ������Ƿ��л�
	public boolean FindListTail(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		SinglyLinkedList slow = first;
		SinglyLinkedList fast = first;
		
		while (fast.next != null && fast != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	//���ص�������������
	public SinglyLinkedList ListMeet(SinglyLinkedList first) {
		
		SinglyLinkedList slow = first;
		SinglyLinkedList fast = first;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return fast;
			}
		}
		return null;
	}
	
	//�ҳ���������������
	public SinglyLinkedList findLoopPort(SinglyLinkedList first) {
		// TODO Auto-generated method stub

		SinglyLinkedList point_meet = ListMeet(first);
		while(first != null && point_meet != null){
			if(first == point_meet){
				return point_meet;
			}
			first = first.next;
			point_meet = point_meet.next;
		}
		return null;
	}
	
	//����������
	public static void main(String[] args) {
		
		//�����л�������
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		RangList rl = new RangList(0);
		SinglyLinkedList first= rl.insertTail(array);
		
		//���Ե������Ƿ��л�
		System.out.println(rl.FindListTail(first));
		System.out.println(rl.ListMeet(first).value);
	}
}
