package Algorithm.other.other;

import java.util.Arrays;

/** 
 *@author liujun
 *@date�� 2018-8-23 ����10:54:34
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��һ���������飬���������֮�����ֵ��С��ֵ,��ס��
 *ֻҪ�ó���Сֵ���ɣ�����Ҫ���������������
 * ����˼·��
 * ����һ�����������������a1,a2,...,an����������B=(b1,b2,...,bn-1)��
 * b1 = a1-a2��b2 = a2-a3��b3 = a3-a4��...��bn-1 = an-1 - an��
 * ��ôԭ�����У�����������֮�� ai - aj��1<=i,j<=n�����Ա�ʾ�� B �е�i������j-1��Ԫ�ص�������ͣ�
 * ����b2+b3+b4 = (a2-a3) + (a3-a4) + (a4-a5) = a2 - a5
 * O(n)�����B���к������ơ�����Ӷκ͡��㷨����С����ֵ�Ӷκ͡����������ࣩ��
 * 
 * ������(��)������һ�����ݣ��ҳ����ֵMax����СֵMin��Ȼ����������ݽ��л��֣�step=(Max - Min)/n.Ȼ�������n��Ͱ��
 * ����Ԫ�ص����ֵһ����ĳ��Ͱi�е����ֵ��Ͱ(i+1)�е���Сֵ�Ĳ�ֵ������Min + n * step = Max��
 *      ��֤���������������Ԫ�ص�����಻��ĳ��Ͱ i �е����ֵ��Ͱ (i+1) �е���Сֵ�Ĳ�ֵ��
 *      ������������Ԫ��λ��ͬһ��Ͱ�У��������С��step������Min + n * step < Maxd�ġ�
 *      ���ì�ܡ��������Ԫ�ؿ϶���λ�ڲ�ͬͰ�еġ������㷨ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�Ҳ��O(n)
 *@version 1.0
 */
public class D_Value {

	public void method1(int[] array) {
		// TODO Auto-generated method stub
		//����
		Arrays.sort(array);
		int min = Integer.MAX_VALUE;
		int temp = 0;
		for (int i = 1; i < array.length; i++) {
			temp = array[i] - array[i-1];
			if(min > temp){
				min = temp;
			}
		}
		System.out.println(min);
	}
	
	//��С����ֵ�Ӷκ�
	public void method2(int[] array) {

		//��������B=(b1,b2,...,bn-1)
		int[] array_b = new int[array.length - 1];
		for (int i = 0; i < array.length - 1; i++) {
			array_b[i] = array[i] - array[i+1];
			if (array_b[i] == 0) {
				System.out.println(0);
				return;
			}
		}
		//����B ��С����ֵ�Ӷκ�
		int[] array_c = new int[array_b.length];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array_c.length; i++) {
			for (int j = 0; j <= i; j++) {
				array_c[j] += array_b[i];
				if(Math.abs(min) > Math.abs(array_c[j])){
					min = Math.abs(array_c[j]);
				}
			}
		}
		//����B ��С����ֵ�Ӷκ�(������)
		/*int start = 0;
		int end = 0;
		int start_temp = 0;
		int temp_abs = 0;
		int best_min = Integer.MAX_VALUE;
		int sum_temp = 0;
		int sum_temp_abs = 0;
		
		for (int i = 0; i < array_b.length; i++) {
			sum_temp += array_b[i];
			sum_temp_abs = sum_temp > 0 ? sum_temp : 0 - sum_temp;
			temp_abs = array_b[i] > 0 ? array_b[i] : 0 - array_b[i]; 
			
			if (temp_abs < best_min) {
				best_min = temp_abs;
				start = i;
				end = i;
				sum_temp = temp_abs;
			}else {
				if(sum_temp_abs < best_min){
					best_min = sum_temp_abs;
					start = start_temp;
					end = i;
				}else {
					start_temp = i + 1;
					sum_temp = best_min;
				}
			}
		}*/
		//�����ֵ
		System.out.println(min);
	}
	
	//Ͱ����:��������м����©��
	/*public void method3(int[] array) {
		// TODO Auto-generated method stub
		//�ҳ����ֵMax����СֵMin
		Arrays.sort(array);
		int min = array[0];
		int max = array[array.length - 1];
		
		//step=(Max - Min)/n
		int n = array.length;
		int step = (max - min) / n;
		int count = min + step;
		int start = 0;
		int best_min = Integer.MAX_VALUE;
		
		//������n��Ͱ,����Ԫ�ص����ֵһ����ĳ��Ͱi�е����ֵ��Ͱ(i+1)�е���Сֵ�Ĳ�ֵ
		while (count < max) {
			if (array[start] < count) {
				while (array[start] < count) {
					start++;
				}
				if(start <= n - 1 && best_min > (array[start] - array[start - 1])){
					best_min = array[start] - array[start - 1];
				}
			}
			count += step;
		}
		System.out.println(best_min);
	}*/
	
	//����������
	public static void main(String[] args) {
		int[] array = {15,7,-640,10,80,-2,33,25,41,-5,84,22};
		int[] array1 = {15,7,-640,10,80,-2,33,25,41,-5,84,22};
		//int[] array2 = {15,7,-640,10,80,-2,33,25,41,-5,84,22};
		
		//�������10 - 7 = 3
		D_Value dv = new D_Value();
		System.out.println("����һ����������ֵ");
		dv.method1(array);
		System.out.println("����������С����ֵ�Ӷκ�");
		dv.method2(array1);
	}
}
