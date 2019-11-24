package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2019-3-23 ����12:09:48
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: ��������
 *@URL:
 *@version 1.0
 */
public class RadixSort implements SortInterface {

	public int[] sortMethod(int[] array) {
		//�߽��п�
		if(array.length == 0 || array == null){
			return array;
		}
		//�ҳ����λ��
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			temp = array[i] > 0 ? array[i] : -array[i];
			if(max < temp){
				max = temp;
			}
		}
		int d = String.valueOf(max).length();
		//��������λ��d �� radix
		radixsort(array, d, 10);
		return array;
	}
	
	public int[] radixsort(int[] array, int d, int radix) {

		//��ǰѭ������λ�����ӵ�һλ���� d λ
		int radixtemp = 1;
		//��ά�������ڻ�������radixpoint�Ƕ�άͰ��ָ��,ÿ��Ͱһ���������䱾��Ҳ��һ������
		int[][] radixbucket = new int[radix][array.length];
		int[] radixpoint = new int[radix];
		int temp = 0;

		//ѭ������λ loopcount
		for(int loopcount = 0; loopcount <= d; loopcount++){
			//��������(����ʹ������������Ĺ�ϣ�ṹ���߶�ά���飬���׾���)
			for (int i = 0; i < array.length; i++) {
				//ȡ����ǰβ������������
				temp = (array[i] / radixtemp) % radix;
				radixbucket[temp][radixpoint[temp]] = array[i];
				radixpoint[temp]++;
			}
			//����ͳ�ƺϲ�,ͨ��Ͱ��ָ���ж�Ͱ���Ƿ���Ԫ��
			int bucketcount = 0;
			for (int i = 0; i < radix; i++) {
				int j = 0;
				while(radixpoint[i] != 0){
					array[bucketcount++] = radixbucket[i][j++];
					radixpoint[i]--;
				}
			}
			//�޸�ѭ������
			radixtemp *= radix;
		}
		return array;
	}
}