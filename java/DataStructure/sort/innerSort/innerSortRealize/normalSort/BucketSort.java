package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2018-8-22 ����05:03:35
 *@author��Email:liujunfirst@outlook.com
 *@description: Ͱ����
 *���ݽṹ ���� ���������
 *@version 1.0
 */

public class BucketSort implements SortInterface {
	//ɢ�б�
	class HashtableNode{
		int value;
		HashtableNode next;
		
		public HashtableNode() {
			// TODO Auto-generated constructor stub
			this.value = Integer.MIN_VALUE;
			next = null;
		}
		public HashtableNode(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			next = null;
		}
	}

	public int[] sortMethod(int[] array) {
		//Ĭ��Ͱ��С����������
		int defaultBucketSize = 10;
		return bucketsort(array, defaultBucketSize);
	}
	
	public int[] bucketsort(int[] array, int bucketsize) {
		//��ȫ�Լ��
		if(array.length == 0 || array == null){
			return array;
		}
		//����Ͱ
		HashtableNode[] HashtableNode = new HashtableNode[bucketsize];
		for (int i = 0; i < HashtableNode.length; i++) {
			HashtableNode[i] = new HashtableNode();
		}
		//�ҳ������Сֵ(����array[0]���������ֵ��array[1]����Сֵ)����ȷ��Ͱ�ļ��
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			max = max > array[i] ? max : array[i];
			min = min < array[i] ? min : array[i];
		}
		//Ͱ�ļ��: ��Ϊ����ֻ�����̵�ԭ����Ҫ��1������ȡ��
		int bucketgap = (max - min) / bucketsize + 1;
		
		//��ϣ���ݣ���ϣ֮��ʹ�ò������򣬶�Ͱ�ڽ�������
		for (int i : array) {
			int head = (i - min) / bucketgap;
			//Ͱ�ڲ�������
				//�½��ڵ�
			HashtableNode point = new HashtableNode(i);
				//��������
			if(Integer.MIN_VALUE == HashtableNode[head].value){
				HashtableNode[head] = point;
			}else{
				//����Ĳ�������
				HashtableNode pro = HashtableNode[head];
				HashtableNode p = pro;
				while (p != null && p.value < point.value) {
					pro = p;
					p = p.next;
				}
				if(HashtableNode[head] == pro && point.value < pro.value){
					point.next = pro;
					HashtableNode[head] = point;
				}else{
					point.next = pro.next;
					pro.next = point;
				}
			}
		}
	    //����Ϊ���鲢����
		int count = 0;
		for (int i = 0; i < HashtableNode.length; i++) {
			HashtableNode p = HashtableNode[i];
			while (p != null && p.value != Integer.MIN_VALUE) {
				array[count] = p.value;
				p = p.next;
				count++;
			}
		}
		return array;
	}
}
