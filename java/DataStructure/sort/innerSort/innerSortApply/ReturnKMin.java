package DataStructure.sort.innerSort.innerSortApply;

import DataStructure.sort.innerSort.innerSortRealize.simpleSort.HeapSort;

/**
 *@author liujun
 *@date： 2018-8-25 下午04:58:29
 *@author—Email:liujunfirst@outlook.com
 *@description: 返回数组中最小的k个数。
 *@method:
 *    方法一：使用堆
 *    方法二：使用快排
 *@version 1.0
 */
public class ReturnKMin {

	HeapSort heapify = new HeapSort();

	//方法一：(维护一个k大小的堆)
	public int[] kMinHeap_K(int[] array ,int k) {
		//输入检查
		if (array == null || array.length < k) {
			return null;
		}
		int[] kmin = new int[k];
		//整堆(维护的大顶堆)
		for (int i = k / 2; i >= 0; i--) {
			heapify.heapify_big(array, i, k - 1);
		}
		//交换堆顶和数组末尾元素，循环整堆,注意边界值 k
		int temp = 0;
		for (int i = array.length - 1; i >= k; i--) {
			if(array[0] > array[i]){
				temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				heapify.heapify_big(array, 0, k - 1);
			}
		}
		int kcount = 0;
		for (int i = k - 1; i >= 0; i--) {
			kmin[kcount++] = array[i];
		}
		//为了测试，可以不要
		heapify.sortMethod(kmin);
		return kmin;
	}

	//方法一：使用堆(维护一个array.length - k大小的堆)
	public int[] kMinHeap_length(int[] array ,int k) {
		//输入检查
		if(array == null || array.length < k){
			return null;
		}
		int[] kmin = new int[k];
		int kcount = 0;
		//整堆(维护的小顶堆)
		for (int i = (array.length - k - 1)/2; i >= 0; i--) {
			heapify.heapify_small(array, i, array.length - k - 1);
		}
		//交换堆顶和数组末尾元素，循环整堆,注意边界值
		int temp = 0;
		for (int i = array.length - 1; i >= array.length - k; i--) {
			if(array[0] < array[i]){
				temp = array[0];
				kmin[kcount++] = array[0];//记录
				array[0] = array[i];
				array[i] = temp;
				heapify.heapify_small(array, 0, array.length - k - 1);
			}else{
				kmin[kcount++] = array[i];//记录
			}
		}
		//为了测试，把最后的kmin,进行排序
		heapify.sortMethod(kmin);
		return kmin;
	}

	//方法二：使用快排
	public int[] kMinQuickSort(int[] array, int k){
		if(array == null || array.length < k){
			return null;
		}

		kMinQuickSortExe(array, k, 0,array.length - 1);
		int[] kmin = new int[k];
		for (int i = 0; i < k; i++) {
			kmin[i] = array[i];
		}
		heapify.sortMethod(kmin);
		return kmin;
	}

	public void kMinQuickSortExe(int[] array, int k, int begin, int end) {
		int low = begin;
		int high = end;
		int temp = 0;
		//边界判断
		if (begin < end) {
			//双向快排方式
			while(low < high){
				while(low < high && array[high] > array[begin]){
					high--;
				}
				//array[low] < array[begin]是错误写法，容易引起无限循环
				//上下两个while循环必须有个=,否则无限循环
				//每次循环均需要判断出界情况：low < high
				while(low < high && array[low] <= array[begin]){
					low++;
				}
				if (low < high) {
					temp = array[high];
					array[high] = array[low];
					array[low] = temp;
				}
			}
			temp = array[begin];
			array[begin] = array[low];
			array[low] = temp;
			//k位判断，及时停止递归。
			if(k == low || k == low - 1){
				return ; 
			}
			if(low < k){
				kMinQuickSortExe(array, k, low + 1, end);
			}else {
				kMinQuickSortExe(array, k, begin, low - 1);
			}
		}
	}
}
