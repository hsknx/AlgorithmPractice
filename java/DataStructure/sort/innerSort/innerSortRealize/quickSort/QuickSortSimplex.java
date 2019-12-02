package DataStructure.sort.innerSort.innerSortRealize.quickSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2018-7-19 ����11:55:48
 *@author��Email:liujunfirst@outlook.com
 *@description: �����������������ź�˫����ţ����ڿ�������ĸĽ������ż����Ż�
 *������ţ�
 *1.ͬʱ������ָ�룬һ��ָ������м䶨λmid,��һ��ָ��i������Ѱ�ұȱ��С��Ԫ��(������forѭ����)��
 *2.��i�ҵ��ȱ��Ԫ��С�ģ�����������
 *3.���һ���ȶ�Ԫ�ظ����Ԫ�ؽ���  
 *4.�ȶԽ��������м��㻮�������֣��ݹ��ظ�1.2��
 *  ע�����
 *  1��mid�ȼ�һ���ٽ���
 *  2��Ϊʲô��left<right��Ϊ�ж�������
 *    ��Ϊ�ݹ����quick_sort_duplexing(A, left, low-1)ʱ��
 *    ����left>low-1ʹ�������
 *
 *˫����ţ�
 *1.��ߵ�ָ�룬��ָ����������Ҵ��ڱ�˵�Ԫ�أ���ָ����С��
 *2.�����ߵ�ָ����ָ���Ԫ��
 *3.������˺͵�ָ����ָ���Ԫ��
 *4.���εݹ�
 *  ע�����
 *  1������������ֵ����
 *  2��left, right, low, high, mid,������ע��
 *@version 1.0
 */

public class QuickSortSimplex implements SortInterface {

	//������ţ�
	public int[] sortMethod(int [] array) {
		quicksortSimplex(array, 0, array.length - 1);
		return array;
	}

	public int[] quicksortSimplex(int [] sortNum, int left, int right) {
		//��λ����
		int mid = left;
		int temp = 0;
		
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
			quicksortSimplex(sortNum, left, mid - 1);
			quicksortSimplex(sortNum, mid + 1, right);
		}
		return sortNum;
	}
}
