package DataStructure.sort.innerSort.innerSortApply;
/** 
 *@author liujun
 *@date： 2018-8-25 下午04:58:29
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description: 返回数组中最小的k个数。
 *@method:
 *    方法一：使用堆
 *    方法二：使用快排
 *@version 1.0
 */
public class ReturnKMin {

	//方法一：使用堆
	public int[] kMinHeap(int[] array ,int k) {
		//输入检查
		if (k > array.length) {  
            return null;
        }
		//整堆
		for (int i = (array.length - 1)/2; i <= k; i++) {
			heapify(array, i, array.length - 1);
		}
		//交换堆顶和数组末尾元素，循环整堆,注意边界值
		int temp = 0;
		for (int i = array.length - 1; i >= array.length - k; i--) {
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, 0, i-1);
		}
		//数组倒叙
		for (int i = 0; i < k; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return new int[]{1};
	}
	
	//整堆函数——小顶堆
	public void heapify(int[] heap, int parent, int border){
		
		//左孩子，最大值标记
		int flag = parent * 2 + 1;
		//越界判断
		if(flag > border){
			return ;
		}
		//如果右孩子存在
		if(flag + 1 <= border){
			//左右孩子对比，找最大值
			flag = heap[flag] < heap[flag + 1] ? flag : flag + 1;
		}
		//对比父节点和孩子结点，找最大值,发生交换,并递归其最大值孩子结点
		if(heap[flag] < heap[parent]){
			int temp = heap[flag];
			heap[flag] = heap[parent];
			heap[parent] = temp;
			heapify(heap, flag, border);
		}
	}
	
	//方法二：使用快排
	public int[] kMinQuickSort(int[] array, int k){
		kMinQuickSortExe(array, k, 0,array.length - 1);
		return new int[]{1};
	}

	public void kMinQuickSortExe(int[] array, int k, int begin, int end) {
		// TODO Auto-generated method stub
		if (k > array.length) {
			System.out.println("k大于数组长度");
		    return ;
		}
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
