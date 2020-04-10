package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-14 22:15
 * @author��Email  liujunfirst@outlook.com
 * @description  ��������
 * @blogURL
 */
public class InsertSort implements SortInterface {

    //��������
    public int [] sortMethod(int [] sortNum) {
        int temp = 0;
        //�ⲿѭ����1��ʼ��ֱ�����
        for (int i = 1; i < sortNum.length; i++) {
            //�ڲ�ѭ�����ⲿλ�ñ�����0
            //====ʵ��1
            int j = i;
            temp = sortNum[i];
            while((j > 0) && (temp < sortNum[j - 1])){
                sortNum[j] = sortNum[j - 1];
                j--;
            }
            if(j != i){
                //��Ϊ��ѭ����j�Ѿ������������Դ˴���ֵ��j��������j-1
                sortNum[j] = temp;
            }
            //====ʵ��2
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

    //��������
    public int [] insertionsort(int [] sortNum, int left, int right) {
        int temp = 0;
        //�ⲿѭ����1��ʼ��ֱ�����
        for (int i = left + 1; i <= right; i++) {
            //�ڲ�ѭ�����ⲿλ�ñ�����0
            int j = i;
            temp = sortNum[i];
            while((j > left) && (temp < sortNum[j - 1])){
                sortNum[j] = sortNum[j - 1];
                j--;
            }
            if(j != i){
                //��Ϊ��ѭ����j�Ѿ������������Դ˴���ֵ��j��������j-1
                sortNum[j] = temp;
            }
        }
        return sortNum;
    }
}
