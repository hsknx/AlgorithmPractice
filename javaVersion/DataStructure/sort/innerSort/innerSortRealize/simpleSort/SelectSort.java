package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-04 21:09
 * @author—Email liujunfirst@outlook.com
 * @description  选择排序
 */
public class SelectSort implements SortInterface {

    //选择排序
    public int [] sortMethod(int [] sortNum) {
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
