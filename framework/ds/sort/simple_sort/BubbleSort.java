package simple_sort;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����11:55:48
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:ð������
 *@version 1.0
 */

public class BubbleSort {

	public int [] Bubble_sort(int [] sort_num) {//������int�������飬�������������
		
		//����������temp
		int temp = 0;
		
		//�ⲿѭ����ѭ��Ԫ�ظ�����һ�Σ���Ϊ���һ��Ĭ������
		for (int i = 0; i < sort_num.length-1; i++) {
			//�ڲ�ѭ�����ⲿѭ��i�Σ�����ȷ��i��Ԫ���Ѿ��������ʣ��n-i������Ԫ�أ�
			//�ڲ�ѭ������ΪԪ�ظ���n��ȥ�ⲿѭ������i,����Ϊi��i+1�Աȣ���˷�ֹ�ĶԱ�Խ�磬���ټ�һ
			for (int j = 0; j < sort_num.length-i-1; j++) {
				
				if(sort_num[j] > sort_num[j+1]){
					temp = sort_num[j];
					sort_num[j] = sort_num[j+1];
					sort_num[j+1] = temp;
				}
			}
		}
		
		return sort_num;
	}
}
