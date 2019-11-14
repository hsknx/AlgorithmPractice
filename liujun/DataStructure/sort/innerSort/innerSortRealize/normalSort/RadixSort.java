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
		//基数排序位数d
		radixsort(array, d);
		return array;
	}
	
	public int[] radixsort(int[] array, int d) {

		//十进制位数
		int radix = 1;
		//循环控制位
		int loopcount = 1;
		//二维数组用于基数排序、radixpoint是二维桶内指针,每个桶一个，所以其本身也是一个数组
		int[][] radixbucket = new int[10][array.length];
		int[] radixpoint = new int[10];
		int temp = 0;
		
		while(loopcount <= d){
			//基数排序(可以使用数组加链表的哈希结构或者二维数组，利弊均有)
			for (int i = 0; i < array.length; i++) {
				//取出尾数，用于排序
				temp = (array[i] / radix) % 10;
				radixbucket[temp][radixpoint[temp]] = array[i];
				radixpoint[temp]++;
			}
			//基数统计合并,通过桶内指针判断桶内是否还有元素
			int bucketcount = 0;
			for (int i = 0; i < 10; i++) {
				int j = 0;
				while(radixpoint[i] != 0){
					array[bucketcount++] = radixbucket[i][j++];
					radixpoint[i]--;
				}
			}
			
			//修改循环变量
			radix *= 10;
			loopcount++;
		}
		return array;
	}
}