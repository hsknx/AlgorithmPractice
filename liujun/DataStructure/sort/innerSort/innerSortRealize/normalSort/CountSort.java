package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date�� 2019-3-23 ����12:10:15
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:1��ͳ��ԭʼ�����Ƶ��(����Сֵ�Ż�)
 *2�����ͳ�ƺ�����顣
 *@URL:
 *@version 1.0
 */
public class CountSort implements SortInterface {

	public  int[] sortMethod(int[] array_a) {
		
		//��ȫ�Լ��
		if(array_a.length == 0 || array_a == null){
			return array_a;
		}
		
		//1���ҳ�ԭʼ����������Сֵ
		int max = array_a[0];
		int min = array_a[0];
		
		for(int i: array_a){
			max = max > i ? max : i;
			min = min < i ? min : i;
		}
		//2�������µ������С  min��max֮�䣬�����䣬�У�max-min+1��������
		int[] array_b = new int[max - min + 1];
		
		//3��һ��ѭ��ͳ�����ݡ����Ż�����Сֵ֮ǰ�����ô洢
		for (int i = 0; i < array_a.length; i++) {
			array_b[array_a[i]-min]++;
		}
		//4���������
		/*for (int i = 0; i < array_b.length; i++) {
			while(array_b[i] != 0){
				System.out.print(i+min+" ");
				array_b[i]--;
			}
		}*/
		//4������������
		int[] array_c = new int[array_a.length];
		
		//�Ż�ǰ������������ѭ�������п�,�˷�ѭ������
		/*int count = 0;
		for (int i = 0; i < array_b.length; i++) {
			while(array_b[i] != 0){
				array_c[count++] = i + min;
				array_b[i]--;
			}
		}*/
		
		/*�Ż��󷽰�:1���ҳ���Ӧλ�ж����ۼӵ�ͳ�����ݣ�
		          2�������ۻ��������b���顣
		 *ע������:1��i���뵽0������array_a[0]�޷�������
		         2��b���飬������--�����ǵ�array_b����С��ͳ��λ��1����ʾ��һ����������
		           �������Ӧ�����������Сֵ(��0λ)�����Ա�����--*/
		for (int i = 1; i < array_b.length; i++) {
			array_b[i] += array_b[i-1];
		}
		
		for (int i = array_a.length - 1; i >= 0; i--) {
			array_c[--array_b[array_a[i] - min]] = array_a[i];
		}
		//ԭַ����
		for (int i = 0; i < array_a.length; i++) {
			array_a[i] = array_c[i];
		}
		return array_a;
	}
}
