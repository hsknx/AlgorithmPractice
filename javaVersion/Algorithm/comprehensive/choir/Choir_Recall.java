package Algorithm.comprehensive.choir;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-12 09:37
 * @author��Email  liujunfirst@outlook.com
 * @description  �ϳ��� ���ݷ�
 * * �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
 * *Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 * @blogURL
 */
public class Choir_Recall implements Choir {

    //ѡ�������
    int choseNum;
    int intervald;
    int[] array;
    int arrayNum;

    //����˻����Ž�
    int bestValue;
    int tempValue;

    @Override
    public int getMaxValue(int[] array, int choseNum, int intervald) {
        return check(array, choseNum, intervald) ? countMaxValue(array, choseNum, intervald) : -1;
    }

    public int countMaxValue(int[] array, int choseNum, int intervald) {
        //initial
        this.choseNum = choseNum;
        this.intervald = intervald;
        this.array = array;
        this.arrayNum = array.length;
        bestValue = 1;
        tempValue = 1;

        countMax(0, 0);
        return bestValue;
    }

    //���ݺ���
    public void countMax(int depth, int start) {
        if (depth == choseNum) {
            bestValue = tempValue > bestValue ? tempValue : bestValue;
            return;
        }

        //��Ϊ�˴���˳��ѡ�ˣ�����i���ô� 0 ��ʼ�����Ǵӵݹ����ȣ���������ǰ������ˣ�
        int bound = Math.min(start + intervald, arrayNum);
        for (int i = start; i < bound; i++) {
            //�쳣��������⴦��
            if (array[i] == 0) {
                continue;
            }
            tempValue *= array[i];
            countMax(depth + 1, i + 1);
            tempValue /= array[i];
        }
    }
}
