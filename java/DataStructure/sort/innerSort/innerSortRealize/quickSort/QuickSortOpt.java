package DataStructure.sort.innerSort.innerSortRealize.quickSort;

import DataStructure.sort.innerSort.SortInterface;
import DataStructure.sort.innerSort.innerSortRealize.simpleSort.InsertSort;

/**
 *@author liujun
 *@date�� 2019-3-23 ����12:08:37
 *@author��Email:liujunfirst@outlook.com
 *@description:���ò��뷨���Ż���������
 *@URL:
 *@version 1.0
 */
public class QuickSortOpt implements SortInterface {

	InsertSort insertionsort = new InsertSort();
	public int[] sortMethod(int [] array) {
		// Ĭ��kΪ3
		quicksortOpsSimplex(array, 0, array.length - 1, 8);
		return array;
	}
	
	public int[] quicksortOpsSimplex(int [] sortNum, int left, int right, int k) {

		//��λ����
		int mid = left;
		int temp = 0;
		if(right - left + 1 <= k){
			insertionsort.insertionsort(sortNum, left, right);
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


}
