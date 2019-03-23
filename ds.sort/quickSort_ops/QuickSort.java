package quickSort_ops;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����11:55:48
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�����������������ź�˫����ţ����ڿ�������ĸĽ������ż����Ż�
 *������ţ�
 *1.ͬʱ������ָ�룬һ��ָ������м䶨λmid,��һ��ָ��i������Ѱ�ұȱ��С��Ԫ��(������forѭ����)��
 *2.��i�ҵ��ȱ��Ԫ��С�ģ�����������
 *3.���һ���ȶ�Ԫ�ظ����Ԫ�ؽ���  
 *4.�ȶԽ��������м��㻮�������֣��ݹ��ظ�1.2��
 *ע�����
 *1��mid�ȼ�һ���ٽ���
 *2��Ϊʲô��left<right��Ϊ�ж�������
 *   ��Ϊ�ݹ����quick_sort_duplexing(A, left, low-1)ʱ��
 *   ����left>low-1ʹ�������
 *
 *˫����ţ�
 *1.��ߵ�ָ�룬��ָ����������Ҵ��ڱ�˵�Ԫ�أ���ָ����С��
 *2.�����ߵ�ָ����ָ���Ԫ��
 *3.������˺͵�ָ����ָ���Ԫ��
 *4.���εݹ�
 *ע�����
 *1������������ֵ����
 *2��left, right, low, high, mid,������ע��
 *@version 1.0
 */

public class QuickSort {

	//������ţ�
	public void Quick_sort_Simplex(int [] sort_num, int left, int right) {

		//��λ����
		int mid = left;
		int temp = 0;
		
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
			Quick_sort_Simplex(sort_num, left, mid - 1);
			Quick_sort_Simplex(sort_num, mid + 1, right);
		}
	}
	
	//˫�����
	public void Quick_sort_duplexing(int [] sort_num, int left, int right) {

		int mid = left;
		int temp = 0;
		//˫��ָ��
		int low = left;
		int high = right;
		
		if(left < right){
			while(low < high){
				//��ָ�����������С�ڱ�˵�Ԫ��
				while((low < high) && (sort_num[high] > sort_num[left])){
					high--;
				}
				//��ָ����������Ҵ��ڱ�˵�Ԫ��
				while((low < high) && (sort_num[low] <= sort_num[left])){
					low++;
				}
				//�ߵ�ֵ������Ԫ��
				if(low <= high){
					temp = sort_num[high];
					sort_num[high] = sort_num[low];
					sort_num[low] = temp;
				}
				mid = low;
			}
			//��λ�����ˣ�����Ԫ��
			temp = sort_num[mid];
			sort_num[mid] = sort_num[left];
			sort_num[left] = temp;
			//�ݹ�
			Quick_sort_Simplex(sort_num, left, mid - 1);
			Quick_sort_duplexing(sort_num, mid + 1, right);
		}
	}
}
