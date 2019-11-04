package innerSort.quickSort_ops;

/** 
 *@author liujun
 *@date�� 2019-3-23 ����12:08:37
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:���ò��뷨���Ż���������
 *@URL:
 *@version 1.0
 */
public class QuickSortOps {

	public int[] quickSortOps(int [] sort_num) {
		long time1 = System.nanoTime();
		// Ĭ��kΪ8
		quicksortOps(sort_num, 8);
		long time2 = System.nanoTime() - time1;
		System.out.println("QuickSortOps��ʱ��"+time2);
		return sort_num;
	}
	
	public int[] quicksortOps(int [] sort_num, int k) {
		// TODO Auto-generated constructor stub
		if(k > sort_num.length){
			return insertion_sort(sort_num, 0, sort_num.length - 1);
		}
		quicksortOpsSimplex(sort_num, 0, sort_num.length - 1, k);
		return sort_num;
	}
	
	public int[] quicksortOpsSimplex(int [] sort_num, int left, int right, int k) {

		//��λ����
		int mid = left;
		int temp = 0;
		if(right - left + 1 <= k){
			insertion_sort(sort_num, left, right);
			return sort_num;
		}
		if(left < right){
			//������Ѱ�ұȱ��С��Ԫ�أ�������mid����
			for (int i = left + 1; i <= right; i++) {
				if(sort_num[i] < sort_num[left]){
					mid++;
					temp = sort_num[mid];
					sort_num[mid] = sort_num[i];
					sort_num[i] = temp;
				}
			}
			//���һ���ȶ�Ԫ�ظ����Ԫ�ؽ���
			temp = sort_num[mid];
			sort_num[mid] = sort_num[left];
			sort_num[left] = temp;
			
			//�ݹ�
			quicksortOpsSimplex(sort_num, left, mid - 1, k);
			quicksortOpsSimplex(sort_num, mid + 1, right, k);
		}
		return sort_num;
	}
	
	public int [] insertionSort(int [] sort_num) {
		
		long time1 = System.nanoTime();
		insertion_sort(sort_num, 0, sort_num.length - 1);
		long time2 = System.nanoTime() - time1;
		System.out.println("InsertionSort��ʱ��"+time2);
		return sort_num;
	}
	//��������Ľ��Ĳ���
	public int [] insertion_sort(int [] sort_num, int left, int right) {

		int temp = 0;
		
		//�ⲿѭ����1��ʼ��ֱ�����
		for (int i = left; i <= right; i++) {
			//�ڲ�ѭ�����ⲿλ�ñ�����0
			for (int j = i; j > left; j--) {
				if(sort_num[j] < sort_num[j - 1]){
					temp = sort_num[j];
					sort_num[j] = sort_num[j - 1];
					sort_num[j - 1] = temp;
				}
			}
		}
		return sort_num;
	}
}
