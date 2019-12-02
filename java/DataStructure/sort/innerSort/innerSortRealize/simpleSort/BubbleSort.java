package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-14 22:13
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class BubbleSort implements SortInterface {

    //冒泡排序    参数：int类型数组，对数组进行排序
    public int [] sortMethod(int [] sortNum) {
        //交换变量：temp
        int temp;
        //第一次内部排序，无数据交换，则默认为数组有序
        boolean flag = false;
        //外部循环：循环元素个数减一次，因为最后一次默认有序
        for (int i = 0; i < sortNum.length-1; i++) {
            //内部循环：外部循环i次，可以确定i个元素已经有序，因此剩余n-i个无序元素，
            //内部循环次数为元素个数n减去外部循环次数i,又因为i和i+1对比，因此防止的对比越界，需再减一
            for (int j = 0; j < sortNum.length-i-1; j++) {
                if(sortNum[j] > sortNum[j+1]){
                    temp = sortNum[j];
                    sortNum[j] = sortNum[j+1];
                    sortNum[j+1] = temp;
                    flag = true;
                }
            }
            if(false){
                break;
            }
        }
        return sortNum;
    }
}
