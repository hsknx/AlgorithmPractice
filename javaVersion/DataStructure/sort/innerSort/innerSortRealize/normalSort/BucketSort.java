package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.line.hashTable.hashTableRealize.HashTableNode;
import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 *@author liujun
 *@date 2018-8-22 ����05:03:35
 *@author��Email liujunfirst@outlook.com
 *@description  Ͱ����
 *���ݽṹ ���� ���������
 *@version 1.0
 */

public class BucketSort implements SortInterface {

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
		HashTableNode[] hashTableNodes = new HashTableNode[bucketsize];
		for (int i = 0; i < bucketsize; i++) {
			hashTableNodes[i] = new HashTableNode();
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
			HashTableNode point = new HashTableNode(i);
				//��������
			if(Integer.MIN_VALUE == hashTableNodes[head].value){
				hashTableNodes[head] = point;
			}else{
				//����Ĳ�������
				HashTableNode pro = hashTableNodes[head];
				HashTableNode p = pro;
				while (p != null && p.value < point.value) {
					pro = p;
					p = p.next;
				}
				if(hashTableNodes[head] == pro && point.value < pro.value){
					point.next = pro;
					hashTableNodes[head] = point;
				}else{
					point.next = pro.next;
					pro.next = point;
				}
			}
		}
	    //����Ϊ���鲢����
		int count = 0;
		for (int i = 0; i < bucketsize; i++) {
			HashTableNode p = hashTableNodes[i];
			while (p != null && p.value != Integer.MIN_VALUE) {
				array[count] = p.value;
				p = p.next;
				count++;
			}
		}
		return array;
	}
}