package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date： 2019-3-23 下午12:10:15
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:1、统计原始数组的频率(用最小值优化)
 *2、输出统计后的数组。
 *@URL:
 *@version 1.0
 */
public class CountSort implements SortInterface {

	public  int[] sortMethod(int[] array_a) {
		
		//安全性检测
		if(array_a.length == 0 || array_a == null){
			return array_a;
		}
		
		//1、找出原始数组的最大最小值
		int max = array_a[0];
		int min = array_a[0];
		
		for(int i: array_a){
			max = max > i ? max : i;
			min = min < i ? min : i;
		}
		//2、定义新的数组大小  min到max之间，闭区间，有（max-min+1）个数字
		int[] array_b = new int[max - min + 1];
		
		//3、一次循环统计数据——优化掉最小值之前的无用存储
		for (int i = 0; i < array_a.length; i++) {
			array_b[array_a[i]-min]++;
		}
		//4、输出数据
		/*for (int i = 0; i < array_b.length; i++) {
			while(array_b[i] != 0){
				System.out.print(i+min+" ");
				array_b[i]--;
			}
		}*/
		//4、返回新数组
		int[] array_c = new int[array_a.length];
		
		//优化前方案——两次循环，需判空,浪费循环次数
		/*int count = 0;
		for (int i = 0; i < array_b.length; i++) {
			while(array_b[i] != 0){
				array_c[count++] = i + min;
				array_b[i]--;
			}
		}*/
		
		/*优化后方案:1、找出对应位有多少累加的统计数据；
		          2、根据累积数据填充b数组。
		 *注意事项:1、i必须到0，否则array_a[0]无法遍历到
		         2、b数组，必须先--，考虑到array_b中最小的统计位是1，表示有一个这样的数
		           这个数对应整个数组的最小值(即0位)，所以必须先--*/
		for (int i = 1; i < array_b.length; i++) {
			array_b[i] += array_b[i-1];
		}
		
		for (int i = array_a.length - 1; i >= 0; i--) {
			array_c[--array_b[array_a[i] - min]] = array_a[i];
		}
		//原址排序
		for (int i = 0; i < array_a.length; i++) {
			array_a[i] = array_c[i];
		}
		return array_a;
	}
}
