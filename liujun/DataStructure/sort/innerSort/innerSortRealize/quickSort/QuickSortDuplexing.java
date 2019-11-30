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

public class QuickSortDuplexing implements SortInterface {

	@Override
	public int[] sortMethod(int[] array) {
		return quicksortDuplexing(array, 0, array.length-1);
	}

	//˫�����
	public int[] quicksortDuplexing(int [] sortNum, int left, int right) {

		int mid = left;
		int temp = 0;
		//˫��ָ��
		int low = left;
		int high = right;
		
		if(left < right){
			while(low < high){
				//��ָ�����������С�ڱ�˵�Ԫ��
				while((low < high) && (sortNum[high] > sortNum[left])){
					high--;
				}
				//��ָ����������Ҵ��ڱ�˵�Ԫ��
				while((low < high) && (sortNum[low] <= sortNum[left])){
					low++;
				}
				//�ߵ�ֵ������Ԫ��
				if(low <= high){
					temp = sortNum[high];
					sortNum[high] = sortNum[low];
					sortNum[low] = temp;
				}
				mid = low;
			}
			//��λ�����ˣ�����Ԫ��
			temp = sortNum[mid];
			sortNum[mid] = sortNum[left];
			sortNum[left] = temp;
			//�ݹ�
			quicksortDuplexing(sortNum, left, mid - 1);
			quicksortDuplexing(sortNum, mid + 1, right);
		}
		return sortNum;
	}
}
