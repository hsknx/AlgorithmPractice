package DataStructure.sort.innerSort.innerSortApply;
/** 
 *@author liujun
 *@date�� 2018-8-25 ����04:58:29
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: ������������С��k������
 *@method:
 *    ����һ��ʹ�ö�
 *    ��������ʹ�ÿ���
 *@version 1.0
 */
public class ReturnKMin {

	//����һ��ʹ�ö�
	public int[] kMinHeap(int[] array ,int k) {
		//������
		if (k > array.length) {  
            return null;
        }
		//����
		for (int i = (array.length - 1)/2; i <= k; i++) {
			heapify(array, i, array.length - 1);
		}
		//�����Ѷ�������ĩβԪ�أ�ѭ������,ע��߽�ֵ
		int temp = 0;
		for (int i = array.length - 1; i >= array.length - k; i--) {
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, 0, i-1);
		}
		//���鵹��
		for (int i = 0; i < k; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return new int[]{1};
	}
	
	//���Ѻ�������С����
	public void heapify(int[] heap, int parent, int border){
		
		//���ӣ����ֵ���
		int flag = parent * 2 + 1;
		//Խ���ж�
		if(flag > border){
			return ;
		}
		//����Һ��Ӵ���
		if(flag + 1 <= border){
			//���Һ��ӶԱȣ������ֵ
			flag = heap[flag] < heap[flag + 1] ? flag : flag + 1;
		}
		//�Աȸ��ڵ�ͺ��ӽ�㣬�����ֵ,��������,���ݹ������ֵ���ӽ��
		if(heap[flag] < heap[parent]){
			int temp = heap[flag];
			heap[flag] = heap[parent];
			heap[parent] = temp;
			heapify(heap, flag, border);
		}
	}
	
	//��������ʹ�ÿ���
	public int[] kMinQuickSort(int[] array, int k){
		kMinQuickSortExe(array, k, 0,array.length - 1);
		return new int[]{1};
	}

	public void kMinQuickSortExe(int[] array, int k, int begin, int end) {
		// TODO Auto-generated method stub
		if (k > array.length) {
			System.out.println("k�������鳤��");
		    return ;
		}
		int low = begin;
		int high = end;
		int temp = 0;
		//�߽��ж�
		if (begin < end) {
			//˫����ŷ�ʽ
			while(low < high){
				while(low < high && array[high] > array[begin]){
					high--;
				}
				//array[low] < array[begin]�Ǵ���д����������������ѭ��
				//��������whileѭ�������и�=,��������ѭ��
				while(low < high && array[low] <= array[begin]){
					low++;
				}
				if (low < high) {
					temp = array[high];
					array[high] = array[low];
					array[low] = temp;
				}
			}
			temp = array[begin];
			array[begin] = array[low];
			array[low] = temp;
			//kλ�жϣ���ʱֹͣ�ݹ顣
			if(k == low || k == low - 1){
				return ; 
			}
			if(low < k){
				kMinQuickSortExe(array, k, low + 1, end);
			}else {
				kMinQuickSortExe(array, k, begin, low - 1);
			}
		}
	}
}
