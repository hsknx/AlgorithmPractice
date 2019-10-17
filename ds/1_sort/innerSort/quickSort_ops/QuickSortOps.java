package innerSort.quickSort_ops;

/** 
 *@author liujun
 *@date： 2019-3-23 下午12:08:37
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:采用插入法来优化快速排序
 *@URL:
 *@version 1.0
 */
public class QuickSortOps {

	public int[] quickSortOps(int [] sort_num) {
		long time1 = System.nanoTime();
		// 默认k为8
		quicksortOps(sort_num, 8);
		long time2 = System.nanoTime() - time1;
		System.out.println("QuickSortOps用时："+time2);
		return sort_num;
	}
	
	public int[] quicksortOps(int [] sort_num, int k) {
		// TODO Auto-generated constructor stub
		if(k > sort_num.length){
			return insertion_sort(sort_num, 0, sort_num.length - 1);
		}
		quicksortOpsSimplex(sort_num, 0, sort_num.length - 1, k);
		return sort_num;
	}
	
	public int[] quicksortOpsSimplex(int [] sort_num, int left, int right, int k) {

		//定位变量
		int mid = left;
		int temp = 0;
		if(right - left + 1 <= k){
			insertion_sort(sort_num, left, right);
			return sort_num;
		}
		if(left < right){
			//从左到右寻找比标杆小的元素，依次与mid交换
			for (int i = left + 1; i <= right; i++) {
				if(sort_num[i] < sort_num[left]){
					mid++;
					temp = sort_num[mid];
					sort_num[mid] = sort_num[i];
					sort_num[i] = temp;
				}
			}
			//最后一个比对元素跟标杆元素交换
			temp = sort_num[mid];
			sort_num[mid] = sort_num[left];
			sort_num[left] = temp;
			
			//递归
			quicksortOpsSimplex(sort_num, left, mid - 1, k);
			quicksortOpsSimplex(sort_num, mid + 1, right, k);
		}
		return sort_num;
	}
	
	public int [] insertionSort(int [] sort_num) {
		
		long time1 = System.nanoTime();
		insertion_sort(sort_num, 0, sort_num.length - 1);
		long time2 = System.nanoTime() - time1;
		System.out.println("InsertionSort用时："+time2);
		return sort_num;
	}
	//快速排序改进的插排
	public int [] insertion_sort(int [] sort_num, int left, int right) {

		int temp = 0;
		
		//外部循环从1开始，直到最后
		for (int i = left; i <= right; i++) {
			//内部循环从外部位置遍历到0
			for (int j = i; j > left; j--) {
				if(sort_num[j] < sort_num[j - 1]){
					temp = sort_num[j];
					sort_num[j] = sort_num[j - 1];
					sort_num[j - 1] = temp;
				}
			}
		}
		return sort_num;
	}
}
