package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2019-3-23 ����12:09:20
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: �鲢����
 *1������ֳ����Σ�ÿ��ȥ����
 *2������ʱ�ж��������Ƿ�Խ�磬Խ��ֹͣ����
 *3��ʵ�й鲢
 *@URL:
 *@version 1.0
 */
public class MergeSort implements SortInterface {

	public int[] sortMethod(int[] array) {
		if(array.length == 0 || array == null){
			return array;
		}
		int[] temp = new int[array.length];
		return mergesort(array, 0, array.length-1, temp);
	}
	
	public int[] mergesort(int[] array, int left, int right, int[] temp){
		
		if(left < right){
			int mid = (left+right)/2;
			mergesort(array, left, mid, temp);
			mergesort(array, mid+1, right, temp);
			sort(array, left, mid, right, temp);
		}
		return array;
	}
	
	//������ϲ�
	public void sort(int[] array, int left, int mid, int right, int[] temp) {

		int l = left;
		int r = mid + 1;
		int j = left;
		while(l <= mid && r <= right){
			if(array[l] > array[r]){
				temp[j++] = array[r++];
			}else{
				temp[j++] = array[l++];
			}
		}
		while(l <= mid){
			temp[j++] = array[l++];
		}
		while(r <= right){
			temp[j++] = array[r++];
		}
		//��װ����
		for (int i = left; i <= right; i++) {
			array[i] = temp[i];
		}
	}
}
