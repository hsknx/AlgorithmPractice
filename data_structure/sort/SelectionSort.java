package sort;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����11:55:48
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:ѡ������
 *@version 1.0
 */

public class SelectionSort {

	public int [] Selection_sort(int [] sort_num) {
		// TODO Auto-generated constructor stub
		int length = sort_num.length;
		int temp = 0;
		int flag = 0;
		
		//�ⲿѭ����0��n-1
		for (int i = 0; i < length - 1; i++) {
			flag = i;//��¼��ֵԪ�ص��½Ǳ�
			//�Ӵ�����Ԫ�ص���һ����ʼ���ң�ֱ�����һ��Ԫ��
			for (int j = i+1; j <= length - 1; j++) {
				if(sort_num[j] < sort_num[flag]){
					flag = j;
				}
			}
			//Ԫ�ؽ���
			temp = sort_num[i];
			sort_num[i] = sort_num[flag];
			sort_num[flag] = temp;
		}
		return sort_num;
	}
}
