package DataStructure.sort.innerSort.innerSortRealize.quickSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2019-3-23 ����12:08:37
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:���ò��뷨���Ż���������
 *@URL:
 *@version 1.0
 */
public class QuickSortOpt implements SortInterface {

	public int[] sortMethod(int [] array) {
		// Ĭ��kΪ3
		quicksortOps(array, 8);
		return array;
	}
	
	public int[] quicksortOps(int [] sortNum, int k) {
		// TODO Auto-generated constructor stub
		if(k > sortNum.length){
			return insertionsort(sortNum, 0, sortNum.length - 1);
		}
		quicksortOpsSimplex(sortNum, 0, sortNum.length - 1, k);
		return sortNum;
	}
	
	public int[] quicksortOpsSimplex(int [] sortNum, int left, int right, int k) {

		//��λ����
		int mid = left;
		int temp = 0;
		if(right - left + 1 <= k){
			insertionsort(sortNum, left, right);
			return sortNum;
		}
		if(left < right){
			//������Ѱ�ұȱ��С��Ԫ�أ�������mid����
			for (int i = left + 1; i <= right; i++) {
				if(sortNum[i] < sortNum[left]){
					mid++;
					temp = sortNum[mid];
					sortNum[mid] = sortNum[i];
					sortNum[i] = temp;
				}
			}
			//���һ���ȶ�Ԫ�ظ����Ԫ�ؽ���
			temp = sortNum[mid];
			sortNum[mid] = sortNum[left];
			sortNum[left] = temp;
			
			//�ݹ�
			quicksortOpsSimplex(sortNum, left, mid - 1, k);
			quicksortOpsSimplex(sortNum, mid + 1, right, k);
		}
		return sortNum;
	}
	
	public int [] insertionSort(int [] sortNum) {
		insertionsort(sortNum, 0, sortNum.length - 1);
		return sortNum;
	}
	//��������
	public int [] insertionsort(int [] sortNum, int left, int right) {

		int temp = 0;
		//�ⲿѭ����1��ʼ��ֱ�����
		for (int i = left + 1; i <= right; i++) {
			//�ڲ�ѭ�����ⲿλ�ñ�����0
			int j = i;
			temp = sortNum[i];
			while((j > left) && (temp < sortNum[j - 1])){
				sortNum[j] = sortNum[j - 1];
				j--;
			}
			if(j != i){
				//��Ϊ��ѭ����j�Ѿ������������Դ˴���ֵ��j��������j-1
				sortNum[j] = temp;
			}
			/*for (int j = i; j > left; j--) {
				if(sortNum[j] < sortNum[j - 1]){
					temp = sortNum[j];
					sortNum[j] = sortNum[j - 1];
					sortNum[j - 1] = temp;
				}
			}*/
		}
		return sortNum;
	}
}
