package sort;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����11:55:48
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�����򣬳�ʼ�����ѵ�ʱ�临�Ӷ�ΪO(n)��
 *�����ؽ��ѵ�ʱ�临�Ӷ�Ϊnlog(n)�������ܵ�ʱ�临�Ӷ�ΪO(n+nlogn)=O(nlogn)��
 *˼·��
 *1)���Ի����ѣ��Ѷ������Ԫ�ء�
 *2)�����Ѷ�������ĩβԪ�أ�Ȼ�����ʣ���n-1��Ԫ�أ��ԶѶ�Ԫ�ؽ��е������ɣ�
 *3)�ظ�2),ֱ������Ԫ������
 *��ν��������Ϊ�󶥶�
 *  1����ʼ������ֻ��Ҫ�Զ������ķ�Ҷ�ӽڵ���ã����������֮n���ֱ�����Һ��ӶԱȣ�
 *����������������ĺ��ӣ���һ�����������Һ��ӷ����Աȣ�ֱ������Աȴﵽ�߽�,
 *���ˣ�����֮n�������������(�󶥶�)��O(n)
 *  2��������С��Χ���Ե����ϣ����ҵ��󣬴Ӷ���֮nѭ������(1)�����ˣ���������/����������(�󶥶�)��
 *@version 1.0
 */

public class HeapSort {

	public void heapSort(int [] heap) {
		//������
		if (heap == null || heap.length <= 1) {  
            return;  
        }
		
		//���Ի�����
		for (int i = (heap.length - 1) / 2; i >= 0 ; i--) {
			heapify(heap, i, heap.length - 1);
		}
		
		//�����Ѷ�������ĩβԪ�أ�ѭ������,ע��߽�ֵ
		for (int i = heap.length - 1; i > 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			heapify(heap, 0, i-1);
		}
	}
	
	//���Ѻ���
	public void heapify(int[] heap, int parent, int border){
		
//		for(int i = parent; i >= 0; i--){
			
			//���ӣ����ֵ���
			int flag = parent * 2 + 1;
			//Խ���ж�
			if(flag > border){
				return ;
			}
			//����Һ��Ӵ���
			if(flag + 1 <= border){
				//���Һ��ӶԱȣ������ֵ
				flag = heap[flag] > heap[flag + 1] ? flag : flag + 1;
			}
			//�Աȸ��ڵ�ͺ��ӽ�㣬�����ֵ,��������,���ݹ������ֵ���ӽ��
			if(heap[flag] > heap[parent]){
				int temp = heap[flag];
				heap[flag] = heap[parent];
				heap[parent] = temp;
				heapify(heap, flag, border);
			}
//		}
	}
}
