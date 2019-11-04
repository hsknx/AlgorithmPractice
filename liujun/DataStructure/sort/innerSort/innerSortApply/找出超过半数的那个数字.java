package DataStructure.sort.innerSort.innerSortApply;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date： 2018-7-26 上午11:16:37
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 *超过数组长度的一半，因此输出2。如果不存在则输出0。
 *思路一（最简洁）：根据鸽笼原理，最差情况下，也会出现三个“该数字”连续排在一起，
 *             定义变量count，如果左右数据相同，count++，并保存该数据。
 *思路二（最常规）：通过快排的方式，将从小到大排序，中位数既是所求值。
 *思路三（最简单）：通过map，统计出现的最多值。
 *@version 1.0
 */
public class 找出超过半数的那个数字 {

	//思路一：鸽笼原理
	public void method_pigeon(int [] test){
		//定义count变量全局监控。
		int count = 0;
		//随机取第一个数据最为对比值
		int num = test[0];
		
		//如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
		for (int i = 0; i < test.length; i++) {
			//清空重置
			if(count == 0){
				num = test[i];
				count = 1;
			}else if(num == test[i]){
				count++;
			}else{
				count--;
			}
		}
		
		//打印数据,并且验证数据是否超过半数，否则输出0
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
	
	//思路二：快排原理
	public void method_quicksort(int [] test){
		//快排
		Arrays.sort(test);
		//输出
		int num = 0;
		for (int i = 0; i < test.length; i++) {
			if(test[i] == test[test.length/2]){
				num++;
			}
		}
		//打印数据,并且验证数据是否超过半数，否则输出0
		if(num > test.length/2){
			System.out.println(test[test.length/2]);
		}else{
			System.out.println(0);
		}
		
	}
	
	//思路三：map方法
	public void method_map(int [] test){

		Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
		//定义出现最多的值和其数量
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
		
		//打印数据,并且验证数据是否超过半数，否则输出0
		if(num > test.length/2){
			System.out.println(value);
		}else{
			System.out.println(0);
		}
	}
	
}
