package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-14 22:15
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class InsertSort implements SortInterface {

    //��������
    public int [] sortMethod(int [] sortNum) {
        int temp = 0;
        //�ⲿѭ����1��ʼ��ֱ�����
        for (int i = 1; i < sortNum.length; i++) {
            //�ڲ�ѭ�����ⲿλ�ñ�����0
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
}
