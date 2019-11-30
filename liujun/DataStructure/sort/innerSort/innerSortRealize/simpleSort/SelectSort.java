package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-04 21:09
 * @author��Email:liujunfirst@outlook.com
 * @description:
 */
public class SelectSort implements SortInterface {

    //ѡ������
    public int [] sortMethod(int [] sortNum) {
        int length = sortNum.length;
        int temp = 0;
        int flag = 0;
        //�ⲿѭ����0��n-1
        for (int i = 0; i < length - 1; i++) {
            //��¼��ֵԪ�ص��½Ǳ�
            flag = i;
            //�Ӵ�����Ԫ�ص���һ����ʼ���ң�ֱ�����һ��Ԫ��
            for (int j = i+1; j <= length - 1; j++) {
                if(sortNum[j] < sortNum[flag]){
                    flag = j;
                }
            }
            //Ԫ�ؽ���
            temp = sortNum[i];
            sortNum[i] = sortNum[flag];
            sortNum[flag] = temp;
        }
        return sortNum;
    }
}
