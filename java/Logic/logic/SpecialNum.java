package Logic.logic;

import java.util.ArrayList;
import java.util.List;

/** 
 *@author liujun
 *@date�� 2018-8-23 ����11:59:55
 *@author��Email:liujunfirst@outlook.com
 *@description:һ��int ���飬�����������κ����ƣ�
 *Ҫ�����������������a[i]������ߵ�����С�ڵ��������ұߵ��������ڵ�������
 *�ܷ�ֻ��һ��������������������ռ�ʵ�֡�
 *@version 1.0
 *@attention:Ϊʲô�����һ�����㣺max <= array[i] = min_right[i]?
 *answer:
 *1.ΪʲôҪ����max����Ϊ����������ߵ�����С�ڵ�������
 *2.Ϊʲômax <= array[i]��ʹ��array[i]��������ߵ�����С�ڵ�������
 *3.Ϊʲôarray[i] = min_right[i]��������С�ڻ��ߴ��ڣ�
 *  С�ڲ�������Υ����min_right�����ĳ��ԡ�
 *  ���ڲ�������Υ�����ұߵ��������ڵ�������
 *4.��һ���У�max = max > array[i] ? max : array[i];�������
 *��array[i]��max�ϴ󣬲��ҵ���min_right[i]��
 *  �����������max = min_right[i] > array[i]������������ʵĴ��ڲ�������
 */
public class SpecialNum {

	//�ҳ�����ߵ�����С�ڵ��������ұߵ��������ڵ�����
	public void findSpecialNum(int[] array) {

		//����һ������min_right[]
		//����min_right[i]�ǵ�ǰλi�������������С���Ǹ�����
		int[] min_right = new int[array.length];
		min_right[array.length - 1] = array[array.length - 1];
		for (int i = min_right.length - 2; i >= 0 ; i--) {
			min_right[i] = array[i] < min_right[i + 1] ? array[i] : min_right[i + 1];
		}
		//����һ����ǰ���ֵ���ڱȽϣ�����list����������
		int max = Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		
		//Ϊʲô�����һ�����㣺max = array[i] = min_right[i]����attention��
		for (int i = 0; i < array.length; i++) {
			max = max > array[i] ? max : array[i];
			if(max == min_right[i]){
				list.add(max);
			}
		}
		//�����Щ��
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}
	
	//����������
	public static void main(String[] args) {
		int[] num = {1,7,3,4,5,6,2,8,9};
		//�������1,8,9
		SpecialNum sn = new SpecialNum();
		sn.findSpecialNum(num);
	}
}
