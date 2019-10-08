package sort;
/** 
 *@author liujun
 *@date： 2018-7-19 下午01:16:13
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class SortTest {

	public static void main(String[] args) {
		
		//测试数据，期望输出：123456789
		int [] array = {8,2,4,6,5,7,9,1,3};
		//int [] array1 = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		
		System.out.print("原始数据：");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("排序后    ：");
		
		//桶排序
		/*BucketSort sort = new BucketSort();
		System.out.println(sort.getClass().getName());
		sort_num1 = sort.bucketSort(array);*/
		
		//归并排序
		/*MergeSort sort = new MergeSort();
		 * System.out.println(sort.getClass().getName());
		sort_num = sort.mergesort(array);*/
		
		//基数排序
		RadixSort sort = new RadixSort();
		System.out.println(sort.getClass().getName());
		sort.radixSort(array);
		
		//计数排序
		/*CountSort sort = new CountSort();
		System.out.println(sort.getClass().getName());
		sort_num = sort.countsort(array);*/
		
		//输出数组
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}