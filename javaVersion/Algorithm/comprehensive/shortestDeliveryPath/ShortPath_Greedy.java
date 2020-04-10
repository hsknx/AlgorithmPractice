package Algorithm.comprehensive.shortestDeliveryPath;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 14:32
 * @author��Email  liujunfirst@outlook.com
 * @description  �ͻ����·��  ̰���㷨
 * @blogURL
 */
public class ShortPath_Greedy implements ShortPath {

    @Override
    public int shortPath(int[] position_row, int[] position_column) {

        return check(position_row, position_column) ? shortPath_greedy(position_row, position_column) : -1;
    }

    //������̾��룺prim˼·
    public int shortPath_greedy(int[] position_row, int[] position_column) {

        //�����ܾ��� �� ��ǰ������Сֵ
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int positionNum = position_row.length;
        //p������ÿ���¼���Ľ�㣬�������±�
        int p = 0;
        //��ʼ����̾�������� shortRouteValue���������ã���¼��̾���ͷ��ʱ�ʶ
        int[] shortRouteValue = new int[positionNum];
        for (int i = 0; i < shortRouteValue.length; i++) {
            shortRouteValue[i] = position_row[i] + position_column[i];
            if (min > shortRouteValue[i]) {
                min = shortRouteValue[i];
                p = i;
            }
        }
        sum += shortRouteValue[p];
        shortRouteValue[p] = -1;
        //��һ������Ϊ��㣬��Ϊ-1����ʾ�ѱ�������
        for (int i = 1; i < positionNum; i++) {
            min = Integer.MAX_VALUE;
            //ÿ�μ�����½��p,����������̾�������顣
            shortRouteValue = update(p, shortRouteValue, position_row, position_column);

            //���������ҳ���ǰ��Сֵ�ĵ�
            for (int j = 0; j < shortRouteValue.length; j++) {
                if (shortRouteValue[j] != -1 && min > shortRouteValue[j]) {
                    min = shortRouteValue[j];
                    p = j;
                }
            }
            //����Сֵ��sum���,��ˢ����Сֵ,���õ�ǰ��Сֵ���ѷ���
            sum += min;
            shortRouteValue[p] = -1;
        }

        //�����Ϸ���ֵ��������Ǹ���ص����
        sum = sum + position_row[p] + position_column[p];
        return sum;
    }

    //��̾�������ĸ��º���
    private int[] update(int p, int[] shortRouteValue, int[] position_row, int[] position_column) {

        //�������
        int row_value = 0;
        int column_value = 0;
        //int count = 0;
        for (int i = 0; i < position_column.length; i++) {
            //��������δ���ʽ�����
            if (shortRouteValue[i] != -1) {
                //�����ֵ,�˴������ֲ�ͬд��
                column_value = Math.abs(position_column[p] - position_column[i]);
                row_value = position_row[p] - position_row[i] > 0 ? position_row[p] - position_row[i] : position_row[i] - position_row[p];
                //count = column_value + row_value;
                //shortRouteValue[i] = count < shortRouteValue[i] ? count : shortRouteValue[i];
                shortRouteValue[i] = column_value + row_value;
            }
        }
        return shortRouteValue;
    }

}
