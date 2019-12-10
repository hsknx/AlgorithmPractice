package DataStructure.sort.innerSort.innerSortApply;

import DataStructure.sort.innerSort.innerSortRealize.simpleSort.HeapSort;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-12-10 09:49
 * @author—Email: liujunfirst@outlook.com
 * @description: 返回数组中最小的第k个数
 * @blogURL:
 */
public class ReturnKthMin {

    HeapSort heapify = new HeapSort();
    ReturnKMin returnKMin = new ReturnKMin();

    //使用堆排——方法一：维护一个k大小的堆，最后返回堆顶
    public int returnKthMinbyheap(int[] array, int k){
        if(array == null || array.length < k){
            return -1;
        }
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
        return array[0];
    }

    //使用快排
    public int returnKthMinbyquicksort(int[] array, int k){
        if(array == null || array.length < k){
            return -1;
        }
        returnKMin.kMinQuickSortExe(array,k,0,array.length-1);
        return array[k-1];
    }
}
