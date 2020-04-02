package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author—Email  liujunfirst@outlook.com
 * @description  插入排序
 * @blogURL
 */
public class InsertSort implements SortInterface {

    //插入排序
    public int [] sortMethod(int [] sortNum) {
        int temp = 0;
        //外部循环从1开始，直到最后
        for (int i = 1; i < sortNum.length; i++) {
            //内部循环从外部位置遍历到0
            //====实现1
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
            //====实现2
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
        }
        return sortNum;
    }
}
