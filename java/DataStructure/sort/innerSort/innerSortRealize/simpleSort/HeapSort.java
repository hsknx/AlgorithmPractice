package DataStructure.sort.innerSort.innerSortRealize.simpleSort;

import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-14 22:14
 * @author��Email: liujunfirst@outlook.com
 * @description: ������
 * ���˼· 1)���Ի����ѣ��Ѷ������Ԫ�ء�
 *      2)�����Ѷ�������ĩβԪ�أ�Ȼ�����ʣ���n-1��Ԫ�أ��ԶѶ�Ԫ�ؽ��е������ɣ�
 *      3)�ظ�2),ֱ������Ԫ������
 *      ��ν��������Ϊ�󶥶�
 *      1����ʼ������ֻ��Ҫ�Զ������ķ�Ҷ�ӽڵ���ã����������֮n���ֱ�����Һ��ӶԱȣ�
 *      ����������������ĺ��ӣ���һ�����������Һ��ӷ����Աȣ�ֱ������Աȴﵽ�߽�,
 *      ���ˣ�����֮n�������������(�󶥶�)��O(n)
 *      2��������С��Χ���Ե����ϣ����ҵ��󣬴Ӷ���֮nѭ������(1)��
 *      ���ˣ���������/����������(�󶥶�)��
 * @blogURL:
 */
public class HeapSort implements SortInterface {

    public int[] sortMethod(int [] heap) {
        int temp;
        //������
        if (heap == null || heap.length <= 1) {
            return heap;
        }
        //���Ի�����
        for (int i = (heap.length - 1) / 2; i >= 0 ; i--) {
            heapify_big(heap, i, heap.length - 1);
        }
        //�����Ѷ�������ĩβԪ�أ�ѭ������,ע��߽�ֵ
        for (int i = heap.length - 1; i > 0; i--) {
            temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapify_big(heap, 0, i-1);
        }
        return heap;
    }

    //���Ѻ�������С����
    public void heapify_small(int[] heap, int parent, int border){

        //���ӣ����ֵ���
        int flag = parent * 2 + 1;
        //Խ���жϣ�������Ӵ���
        if(flag > border){
            return ;
        }
        //����Һ��Ӵ���
        if(flag + 1 <= border){
            //���Һ��ӶԱȣ������ֵ
            flag = heap[flag] > heap[flag + 1] ? flag + 1 : flag;
        }
        //�Աȸ��ڵ�ͺ��ӽ�㣬�����ֵ,��������,���ݹ������ֵ���ӽ��
        if(heap[flag] < heap[parent]){
            int temp = heap[flag];
            heap[flag] = heap[parent];
            heap[parent] = temp;
            heapify_small(heap, flag, border);
        }
    }

    //���Ѻ��������󶥶�
    public void heapify_big(int[] heap, int parent, int border){

        //���ӣ����ֵ���
        int flag = parent * 2 + 1;
        //Խ���жϣ�������Ӵ���
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
            heapify_big(heap, flag, border);
        }
    }
}
