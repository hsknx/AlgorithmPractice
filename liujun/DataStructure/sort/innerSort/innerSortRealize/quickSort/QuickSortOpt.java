package DataStructure.sort.innerSort.innerSortRealize.quickSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date： 2019-3-23 下午12:08:37
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:采用插入法来优化快速排序
 *@URL:
 *@version 1.0
 */
public class QuickSortOpt implements SortInterface {

	public int[] sortMethod(int [] array) {
		// 默认k为3
		quicksortOps(array, 8);
		return array;
	}
	
	public int[] quicksortOps(int [] sortNum, int k) {
		// TODO Auto-generated constructor stub
		if(k > sortNum.length){
			return insertionsort(sortNum, 0, sortNum.length - 1);
		}
		quicksortOpsSimplex(sortNum, 0, sortNum.length - 1, k);
		return sortNum;
	}
	
	public int[] quicksortOpsSimplex(int [] sortNum, int left, int right, int k) {

		//定位变量
		int mid = left;
		int temp = 0;
		if(right - left + 1 <= k){
			insertionsort(sortNum, left, right);
			return sortNum;
		}
		if(left < right){
			//从左到右寻找比标杆小的元素，依次与mid交换
			for (int i = left + 1; i <= right; i++) {
				if(sortNum[i] < sortNum[left]){
					mid++;
					temp = sortNum[mid];
					sortNum[mid] = sortNum[i];
					sortNum[i] = temp;
				}
			}
			//最后一个比对元素跟标杆元素交换
			temp = sortNum[mid];
			sortNum[mid] = sortNum[left];
			sortNum[left] = temp;
			
			//递归
			quicksortOpsSimplex(sortNum, left, mid - 1, k);
			quicksortOpsSimplex(sortNum, mid + 1, right, k);
		}
		return sortNum;
	}
	
	public int [] insertionSort(int [] sortNum) {
		insertionsort(sortNum, 0, sortNum.length - 1);
		return sortNum;
	}
	//插入排序
	public int [] insertionsort(int [] sortNum, int left, int right) {

		int temp = 0;
		//外部循环从1开始，直到最后
		for (int i = left + 1; i <= right; i++) {
			//内部循环从外部位置遍历到0
			int j = i;
			temp = sortNum[i];
			while((j > left) && (temp < sortNum[j - 1])){
				sortNum[j] = sortNum[j - 1];
				j--;
			}
			if(j != i){
				//因为在循环内j已经被减过。所以此处赋值给j，而不是j-1
				sortNum[j] = temp;
			}
			/*for (int j = i; j > left; j--) {
				if(sortNum[j] < sortNum[j - 1]){
					temp = sortNum[j];
					sortNum[j] = sortNum[j - 1];
					sortNum[j - 1] = temp;
				}
			}*/
		}
		return sortNum;
	}
}
