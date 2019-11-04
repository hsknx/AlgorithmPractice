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
 *�������鳤�ȵ�һ�룬������2����������������0��
 *˼·һ�����ࣩ�����ݸ���ԭ���������£�Ҳ����������������֡���������һ��
 *             �������count���������������ͬ��count++������������ݡ�
 *˼·������棩��ͨ�����ŵķ�ʽ������С����������λ����������ֵ��
 *˼·������򵥣���ͨ��map��ͳ�Ƴ��ֵ����ֵ��
 *@version 1.0
 */
public class �ҳ������������Ǹ����� {

	//˼·һ������ԭ��
	public void method_pigeon(int [] test){
		//����count����ȫ�ּ�ء�
		int count = 0;
		//���ȡ��һ��������Ϊ�Ա�ֵ
		int num = test[0];
		
		//����з������������֣��������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ
		for (int i = 0; i < test.length; i++) {
			//�������
			if(count == 0){
				num = test[i];
				count = 1;
			}else if(num == test[i]){
				count++;
			}else{
				count--;
			}
		}
		
		//��ӡ����,������֤�����Ƿ񳬹��������������0
		count = 0;
		for (int i = 0; i < test.length; i++) {
			if(test[i] == num){
				count++;
			}
		}
		if(count > test.length/2){
			System.out.println(num);
		}else{
			System.out.println(0);
		}
	}
	
	//˼·��������ԭ��
	public void method_quicksort(int [] test){
		//����
		Arrays.sort(test);
		//���
		int num = 0;
		for (int i = 0; i < test.length; i++) {
			if(test[i] == test[test.length/2]){
				num++;
			}
		}
		//��ӡ����,������֤�����Ƿ񳬹��������������0
		if(num > test.length/2){
			System.out.println(test[test.length/2]);
		}else{
			System.out.println(0);
		}
		
	}
	
	//˼·����map����
	public void method_map(int [] test){

		Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
		//�����������ֵ��������
		int value = 0;
		int num = 0;
		
		for (int i = 0; i < test.length; i++) {
			if(map.containsKey(test[i])){
				map.put(test[i], map.get(test[i])+1);
				if(map.get(test[i]) > num){
					num = map.get(test[i]);
					value = test[i];
				}
			}else{
				map.put(test[i], 1);
			}
		}
		
		//��ӡ����,������֤�����Ƿ񳬹��������������0
		if(num > test.length/2){
			System.out.println(value);
		}else{
			System.out.println(0);
		}
	}
	
}
