package DataStructure.sort.innerSort.innerSortApply;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date�� 2018-7-26 ����11:16:37
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 *��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ�
 *�������鳤�ȵ�һ�룬������2����������������-1��
 *˼·һ�����ࣩ�����ݸ���ԭ���������£�Ҳ����������������֡���������һ��
 *             �������count���������������ͬ��count++������������ݡ�
 *˼·������棩��ͨ�����ŵķ�ʽ������С����������λ����������ֵ��
 *˼·������򵥣���ͨ��map��ͳ�Ƴ��ֵ����ֵ��
 *@version 1.0
 */
//�ҳ������������Ǹ�����
public class HalfPastNum {

	//˼·һ������ԭ��
	public int method_pigeon(int [] array){
		if(array == null || array.length == 0){
			return -1;
		}
		//����count����ȫ�ּ�ء�
		int count = 0;
		//���ȡ��һ��������Ϊ�Ա�ֵ
		int num = array[0];

		//����з������������֣��������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ
		for (int i = 0; i < array.length; i++) {
			//�������
			if(count == 0){
				num = array[i];
				count = 1;
			}else if(num == array[i]){
				count++;
			}else{
				count--;
			}
		}

		//������ڳ�������������������������-1
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == num){
				count++;
			}
		}
		return count > array.length/2 ? num : -1;
	}

	//˼·��������ԭ��
	public int method_quicksort(int [] array){
		if(array == null || array.length == 0){
			return -1;
		}
		//����
		Arrays.sort(array);
		//���
		int count = 0;
		int flag = array[array.length/2];
		for (int i = 0; i < array.length; i++) {
			if(array[i] == flag){
				count++;
			}
		}
		//������ڳ�������������������������-1
		return count > array.length/2 ? flag : -1;
	}

	//˼·����map����
	public int method_map(int [] array){

		if(array == null || array.length == 0){
			return -1;
		}
		if(array.length == 1){
			return array[0];
		}
		Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
		//�����������ֵ��������
		int num = 0;
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
				if(map.get(array[i]) > count){
					count = map.get(array[i]);
					num = array[i];
				}
			}else{
				map.put(array[i], 1);
			}
		}
		
		//������ڳ�������������������������-1
		return count > array.length/2 ? num : -1;
	}
}
