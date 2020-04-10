package Algorithm.dynamic.dynamicPrimary;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-25 16:41
 * @author��Email  liujunfirst@outlook.com
 * @description  ��ҽ��ᣬ��һ��ֱ���ϣ���n�����ݣ�ÿ�����������������ȵĲƱ���
 * ��һ���� ��ϣ���ӷ����е�ȡ�Ʊ������ڷ������б�������
 * ���ͬʱ�����ڵ����������е�ȡ�Ʊ��ͻᴥ�������������ڲ�������������ǰ���£�
 * ���ɻ�ȡ���ٲƱ������� [5��2��6��3��1��7]����ѡ��5��6��7
 * @blogURL
 */
public class ThiefSteal {

    public int method(int[] values){

        if(values == null || values.length == 0){
            return 0;
        }
        int length = values.length;
        int[] bestGoodsValue = new int[length];
        bestGoodsValue[0] = values[0];
        if(length == 1){
            return bestGoodsValue[0];
        }
        bestGoodsValue[1] = Math.max(values[0], values[1]);
        if(length == 2){
            return bestGoodsValue[1];
        }
        for (int i = 2; i < length; i++) {
            bestGoodsValue[i] = Math.max(bestGoodsValue[i-1], bestGoodsValue[i-2] + values[i]);
        }
        return bestGoodsValue[length - 1];
    }
}
