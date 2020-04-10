package Algorithm.comprehensive.shortestDeliveryPath;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-11 16:06
 * @author��Email  liujunfirst@outlook.com
 * @description  �ͻ����·��  ���ݷ�
 * @blogURL
 */
public class ShortPath_Recall implements ShortPath {

    //�����ܾ��� �� ��ǰ������Сֵ
    int sum_temp;
    int sum_best;
    int min;
    int positionNum;
    boolean[] visitFlag;
    //��������
    int[] position_row;
    int[] position_column;

    @Override
    public int shortPath(int[] position_row, int[] position_column) {
        return check(position_row, position_column) ? shortPath_recall(position_row, position_column) : -1;
    }

    public int shortPath_recall(int[] position_row, int[] position_column) {
        this.position_row = position_row;
        this.position_column = position_column;
        positionNum = position_row.length;
        visitFlag = new boolean[positionNum];
        Arrays.fill(visitFlag,false);
        sum_best = Integer.MAX_VALUE;

        for (int position = 0; position < positionNum; position++) {
            sum_temp = sum_temp + position_column[position] + position_row[position];
            //����ǰ�� position ��Ϊ����ֵ����
            visitFlag[position] = true;
            BranchandBound(position, 1);
            visitFlag[position] = false;  //��ȷ�� �� Arrays.fill(visitFlag,false);
            sum_temp = 0;
        }
        return sum_best;
    }

    public void BranchandBound(int position, int depth) {
        if (depth == positionNum) {
            //���һ������Ҫ���� ��������ֵ
            sum_temp = sum_temp + position_column[position] + position_row[position];
            if(sum_temp < sum_best){
                sum_best = sum_temp;
            }
            sum_temp = sum_temp - (position_column[position] + position_row[position]);

            return;
        }
        for (int i = 0; i < positionNum; i++) {
            int distance;
            //��ǰ��δ�����ʹ�
            if (!visitFlag[i]) {
                visitFlag[i] = true;
                distance = distance(position, i);
                //��֦
                if (sum_temp + distance < sum_best) {
                    sum_temp += distance;
                    BranchandBound(i, depth + 1);
                    sum_temp -= distance;
                }
                visitFlag[i] = false;
            }
        }
    }

    //������������
    public int distance(int x, int y) {
        int column_value = Math.abs(position_column[x] - position_column[y]);
        int row_value = position_row[x] - position_row[y] > 0 ? position_row[x] - position_row[y] : position_row[y] - position_row[x];
        return column_value + row_value;
    }
}
