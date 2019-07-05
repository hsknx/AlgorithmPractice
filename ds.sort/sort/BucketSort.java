package sort;

/** 
 *@author liujun
 *@date�� 2018-8-22 ����05:03:35
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:Ͱ����
 *���ݽṹ�������������
 *@version 1.0
 */
public class BucketSort {

	//ɢ�б�
	class Hashtable{
		int value;
		Hashtable next;
		
		public Hashtable() {
			// TODO Auto-generated constructor stub
			this.value = Integer.MIN_VALUE;
			next = null;
		}
		public Hashtable(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			next = null;
		}
	}
	
	public int[] bucketSort(int[] array) {

		//Ĭ��Ͱ��С����������
		int defaultBucketSize = 10;
		return bucketsort(array, defaultBucketSize);
	}
	
	public int[] bucketsort(int[] array, int bucketsize) {

		//��ȫ�Լ��
		if(array.length == 0){
			return array;
		}
		//����Ͱ
		Hashtable[] hashtable = new Hashtable[bucketsize];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new Hashtable();
		}
		//�ҳ������Сֵ(����array[0]�����ֵ��array[1]����Сֵ)����ȷ��Ͱ�ļ��
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(max < array[i]){
				max = array[i];
			}
			if(min > array[i]){
				min = array[i];
			}
		}
		//Ͱ�ļ���1��Ϊ������ȡ��
		int bucketgap = (max - min) / bucketsize + 1;
		
		//��ϣ���ݣ���ϣ֮��ʹ�ò������򣬶�Ͱ�ڽ�������
		for (int i : array) {
			int head = (i - min) / bucketgap;
			//Ͱ�ڲ�������
				//�½��ڵ�
			Hashtable point = new Hashtable(i);
				//��������
			if(Integer.MIN_VALUE == hashtable[head].value){
				hashtable[head] = point;
			}else{
				Hashtable p = hashtable[head];
				while (p.next != null && p.next.value > point.value) {
					p = p.next;
				}
				point.next = p.next;
				p.next = point;
			}
		}
	    //����Ϊ���鲢����
		int count = 0;
		for (int i = 0; i < hashtable.length; i++) {
			Hashtable p = hashtable[i];
			while (p != null && p.value != Integer.MIN_VALUE) {
				array[count] = p.value;
				p = p.next;
				count++;
			}
		}
		return array;
	}
	
}
