package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-14 22:13
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class BubbleSort implements SortInterface {

    //ð������    ������int�������飬�������������
    public int [] sortMethod(int [] sortNum) {
        //����������temp
        int temp;
        //��һ���ڲ����������ݽ�������Ĭ��Ϊ��������
        boolean flag = false;
        //�ⲿѭ����ѭ��Ԫ�ظ�����һ�Σ���Ϊ���һ��Ĭ������
        for (int i = 0; i < sortNum.length-1; i++) {
            //�ڲ�ѭ�����ⲿѭ��i�Σ�����ȷ��i��Ԫ���Ѿ��������ʣ��n-i������Ԫ�أ�
            //�ڲ�ѭ������ΪԪ�ظ���n��ȥ�ⲿѭ������i,����Ϊi��i+1�Աȣ���˷�ֹ�ĶԱ�Խ�磬���ټ�һ
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
