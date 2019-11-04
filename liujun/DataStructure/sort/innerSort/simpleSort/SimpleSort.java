package DataStructure.sort.innerSort.simpleSort;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-04 21:09
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class SimpleSort {

    //ð������    ������int�������飬�������������
    public int [] BubbleSort(int [] sortNum) {
        //����������temp
        int temp;
        //�ⲿѭ����ѭ��Ԫ�ظ�����һ�Σ���Ϊ���һ��Ĭ������
        for (int i = 0; i < sortNum.length-1; i++) {
            //�ڲ�ѭ�����ⲿѭ��i�Σ�����ȷ��i��Ԫ���Ѿ��������ʣ��n-i������Ԫ�أ�
            //�ڲ�ѭ������ΪԪ�ظ���n��ȥ�ⲿѭ������i,����Ϊi��i+1�Աȣ���˷�ֹ�ĶԱ�Խ�磬���ټ�һ
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
 * ���˼· 1)���Ի����ѣ��Ѷ������Ԫ�ء�
          2)�����Ѷ�������ĩβԪ�أ�Ȼ�����ʣ���n-1��Ԫ�أ��ԶѶ�Ԫ�ؽ��е������ɣ�
          3)�ظ�2),ֱ������Ԫ������
    ��ν��������Ϊ�󶥶�
          1����ʼ������ֻ��Ҫ�Զ������ķ�Ҷ�ӽڵ���ã����������֮n���ֱ�����Һ��ӶԱȣ�
            ����������������ĺ��ӣ���һ�����������Һ��ӷ����Աȣ�ֱ������Աȴﵽ�߽�,
             ���ˣ�����֮n�������������(�󶥶�)��O(n)
          2��������С��Χ���Ե����ϣ����ҵ��󣬴Ӷ���֮nѭ������(1)��
             ���ˣ���������/����������(�󶥶�)��*/
    public int[] heapSort(int [] heap) {
        int temp;
        //������
        if (heap == null || heap.length <= 1) {
            return heap;
        }
        //���Ի�����
        for (int i = (heap.length - 1) / 2; i >= 0 ; i--) {
            heapify(heap, i, heap.length - 1);
        }
        //�����Ѷ�������ĩβԪ�أ�ѭ������,ע��߽�ֵ
        for (int i = heap.length - 1; i > 0; i--) {
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapify(heap, 0, i-1);
        }
        return heap;
    }

    //���Ѻ���
    public void heapify(int[] heap, int parent, int border){

        //���ӣ����ֵ���
        int flag = parent * 2 + 1;
        //Խ���ж�
        if(flag > border){
            return ;
        }
        //����Һ��Ӵ���
        if(flag + 1 <= border){
            //���Һ��ӶԱȣ������ֵ
            flag = heap[flag] > heap[flag + 1] ? flag : flag + 1;
        }
        //�Աȸ��ڵ�ͺ��ӽ�㣬�����ֵ,��������,���ݹ������ֵ���ӽ��
        if(heap[flag] > heap[parent]){
            int temp = heap[flag];
            heap[flag] = heap[parent];
            heap[parent] = temp;
            heapify(heap, flag, border);
        }
    }

    //��������
    public int [] insertSort(int [] sortNum) {
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

    //ѡ������
    public int [] selectSort(int [] sortNum) {
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
