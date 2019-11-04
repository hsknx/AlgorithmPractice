package DataStructure.sort.innerSort.simpleSort;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-04 21:09
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class SimpleSort {

    //冒泡排序    参数：int类型数组，对数组进行排序
    public int [] BubbleSort(int [] sortNum) {
        //交换变量：temp
        int temp;
        //外部循环：循环元素个数减一次，因为最后一次默认有序
        for (int i = 0; i < sortNum.length-1; i++) {
            //内部循环：外部循环i次，可以确定i个元素已经有序，因此剩余n-i个无序元素，
            //内部循环次数为元素个数n减去外部循环次数i,又因为i和i+1对比，因此防止的对比越界，需再减一
            for (int j = 0; j < sortNum.length-i-1; j++) {
                if(sortNum[j] > sortNum[j+1]){
                    temp = sortNum[j];
                    sortNum[j] = sortNum[j+1];
                    sortNum[j+1] = temp;
                }
            }
        }
        return sortNum;
    }

/**
 * 设计思路 1)初试化建堆，堆顶即最大元素。
          2)交换堆顶和数组末尾元素，然后针对剩余的n-1个元素，对堆顶元素进行调整即可，
          3)重复2),直到所有元素有序。
    如何将数组调整为大顶堆
          1、初始化建堆只需要对二叉树的非叶子节点调用，从数组二分之n处分别跟左右孩子对比，
            发生交换，交换后的孩子，进一步跟它的左右孩子发生对比，直到数组对比达到边界,
             至此，二分之n这个二叉树有序(大顶堆)。O(n)
          2、不断缩小范围，自底向上，从右到左，从二分之n循环到顶(1)，
             至此，整个数组/二叉树有序(大顶堆)。*/
    public int[] heapSort(int [] heap) {
        int temp;
        //输入检查
        if (heap == null || heap.length <= 1) {
            return heap;
        }
        //初试化建堆
        for (int i = (heap.length - 1) / 2; i >= 0 ; i--) {
            heapify(heap, i, heap.length - 1);
        }
        //交换堆顶和数组末尾元素，循环整堆,注意边界值
        for (int i = heap.length - 1; i > 0; i--) {
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapify(heap, 0, i-1);
        }
        return heap;
    }

    //整堆函数
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
            flag = heap[flag] > heap[flag + 1] ? flag : flag + 1;
        }
        //对比父节点和孩子结点，找最大值,发生交换,并递归其最大值孩子结点
        if(heap[flag] > heap[parent]){
            int temp = heap[flag];
            heap[flag] = heap[parent];
            heap[parent] = temp;
            heapify(heap, flag, border);
        }
    }

    //插入排序
    public int [] insertSort(int [] sortNum) {
        int temp = 0;
        //外部循环从1开始，直到最后
        for (int i = 1; i < sortNum.length; i++) {
            //内部循环从外部位置遍历到0
            int j = i;
            temp = sortNum[i];
            while((j > 0) && (temp < sortNum[j - 1])){
                sortNum[j] = sortNum[j - 1];
                j--;
            }
            if(j != i){
                //因为在循环内j已经被减过。所以此处赋值给j，而不是j-1
                sortNum[j] = temp;
            }
            /*for (int j = i; j > 0; j--) {
                if(sortNum[j] < sortNum[j - 1]){
                    temp = sortNum[j];
                    sortNum[j] = sortNum[j - 1];
                    sortNum[j - 1] = temp;
                }
            }*/
        }
        return sortNum;
    }

    //选择排序
    public int [] selectSort(int [] sortNum) {
        int length = sortNum.length;
        int temp = 0;
        int flag = 0;
        //外部循环从0到n-1
        for (int i = 0; i < length - 1; i++) {
            //记录最值元素的下角标
            flag = i;
            //从待交换元素的下一个开始查找，直到最后一个元素
            for (int j = i+1; j <= length - 1; j++) {
                if(sortNum[j] < sortNum[flag]){
                    flag = j;
                }
            }
            //元素交换
            temp = sortNum[i];
            sortNum[i] = sortNum[flag];
            sortNum[flag] = temp;
        }
        return sortNum;
    }
}
