package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date： 2019-3-23 下午12:09:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description: 基数排序
 *@URL:
 *@version 1.0
 */
public class RadixSort implements SortInterface {

	public int[] sortMethod(int[] array) {
		//边界判空
		if(array.length == 0 || array == null){
			return array;
		}
		//找出最大位数
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			temp = array[i] > 0 ? array[i] : -array[i];
			if(max < temp){
				max = temp;
			}
		}
		int d = String.valueOf(max).length();
		//基数排序位数d 和 radix
		radixsort(array, d, 10);
		return array;
	}
	
	public int[] radixsort(int[] array, int d, int radix) {

		//当前循环到的位数，从第一位到第 d 位
		int radixtemp = 1;
		//二维数组用于基数排序、radixpoint是二维桶内指针,每个桶一个，所以其本身也是一个数组
		int[][] radixbucket = new int[radix][array.length];
		int[] radixpoint = new int[radix];
		int temp = 0;

		//循环控制位 loopcount
		for(int loopcount = 0; loopcount <= d; loopcount++){
			//基数排序(可以使用数组加链表的哈希结构或者二维数组，利弊均有)
			for (int i = 0; i < array.length; i++) {
				//取出当前尾数，用于排序
				temp = (array[i] / radixtemp) % radix;
				radixbucket[temp][radixpoint[temp]] = array[i];
				radixpoint[temp]++;
			}
			//基数统计合并,通过桶内指针判断桶内是否还有元素
			int bucketcount = 0;
			for (int i = 0; i < radix; i++) {
				int j = 0;
				while(radixpoint[i] != 0){
					array[bucketcount++] = radixbucket[i][j++];
					radixpoint[i]--;
				}
			}
			//修改循环变量
			radixtemp *= radix;
		}
		return array;
	}
}