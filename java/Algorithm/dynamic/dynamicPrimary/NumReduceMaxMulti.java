package Algorithm.dynamic.dynamicPrimary;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 16:44
 * @author��Email: liujunfirst@outlook.com
 * @description: ����һ�������� n��������Ϊ���������������ĺͣ�
 * ��ʹ��Щ�����ĳ˻���󻯡� ��������Ի�õ����˻�
 * @blogURL:
 */
public class NumReduceMaxMulti {

    public int reduce(int num) {
        if (num <= 1) {
            return num;
        }
        int maxMulti = 0;
        int[] maxMultiarray = new int[num+1];
        maxMultiarray[1] = 1;
        //ע��ѭ����Χ
        for (int i = 2; i <= num; i++) {
            for (int j = 1; j < i; j++) {
                //maxMultiarray[i] = Math.max(maxMultiarray[i], (j) * Math.max(i - j, maxMultiarray[i - j]));
                maxMultiarray[i] = Math.max(maxMultiarray[i], (i - j) * Math.max(j, maxMultiarray[j]));
            }
        }
        return maxMultiarray[num];
    }

    /*����ѧ��ò���и�ɶ����ֵ�������ţ������˼��������������ĺ�Ϊn��
    ��������������ƽ��n��ʱ�����������ĳ˻����ܴﵽ���*/
    public int reduceMath(int num) {
        if (num <= 1) {
            return num;
        }
        if (num <= 3) {
            return num - 1;
        }
        /*����������3������������Ҫ�� n/3�������Ļ�������������1,2 ���ֿ����ԡ�
        ���������1���ղ�����Ҳ������������1�Ĳ����û������ģ�����������һ���������һ�ε�3��1�Ĳ�֣���2��2���档
        ���������2���ǲ�����˵��ֱ�ӳ�������2���ɡ�*/
        int x = num / 3, y = num % 3;
        //ǡ��������ֱ��Ϊ3^x
        if (y == 0) {
            return (int) Math.pow(3, x);
        }
        //����Ϊ1����һ�� 3^(x-1)*2*2,����Ϊ2��ֱ�ӳ���2
        return y == 1 ? (int) Math.pow(3, x - 1) * 4 : (int) Math.pow(3, x) * 2;
    }
}
