package DataStructure.sort.innerSort.innerSortRealize.quickSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 *@author liujun
 *@date： 2018-7-19 上午11:55:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description: 快速排序包括单向快排和双向快排，关于快速排序的改进见快排及其优化
 *单向快排：
 *1.同时设两个指针，一个指针代表中间定位mid,另一个指针i从左到右寻找比标杆小的元素(隐藏在for循环中)，
 *2.当i找到比标杆元素小的，发生交换，
 *3.最后一个比对元素跟标杆元素交换  
 *4.比对结束，由中间结点划分两部分，递归重复1.2。
 *  注意事项：
 *  1）mid先加一，再交换
 *  2）为什么是left<right作为判定条件？
 *    因为递归调用quick_sort_duplexing(A, left, low-1)时，
 *    存在left>low-1使程序出错
 *
 *双向快排：
 *1.设高低指针，低指针从左往右找大于标杆的元素，高指针找小的
 *2.交换高低指针所指向的元素
 *3.交换标杆和低指针所指向的元素
 *4.依次递归
 *  注意事项：
 *  1）发生两次数值交换
 *  2）left, right, low, high, mid,交换需注意
 *@version 1.0
 */

public class QuickSortSimplex implements SortInterface {

	//单向快排：
	public int[] sortMethod(int [] array) {
		quicksortSimplex(array, 0, array.length - 1);
		return array;
	}

	public int[] quicksortSimplex(int [] sortNum, int left, int right) {
		//定位变量
		int mid = left;
		int temp = 0;
		
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
			quicksortSimplex(sortNum, left, mid - 1);
			quicksortSimplex(sortNum, mid + 1, right);
		}
		return sortNum;
	}
}
