package Algorithm.dynamic.dynamicPrimary;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 16:39
 * @author��Email: liujunfirst@outlook.com
 * @description: ��¥��,쳲���Ш����
 * ����¥��ʱ��ÿ�ο�������1��̨�׻�2��̨�ף�����n��¥ ���ж�������¥�ķ�ʽ
 * @blogURL:
 */
public class ClimbStairs {

    private static int capacity = 10;
    private static int[] statusNum = new int[capacity];
    {
        statusNum[0] = 1;
        statusNum[1] = 1;
        for (int i = 2; i < capacity; i++) {
            statusNum[i] = statusNum[i-1] + statusNum[i-2];
        }
    }

    public int method(int value){
        return value <= 0 ? 0 : climbStairs(value);
    }

    public int climbStairs(int value){
        return value < capacity ? statusNum[value] : expansion(value+1);
    }

    public int expansion(int value){
        int[] statusNum1 = new int[value];
        for (int i = 0; i < capacity; i++) {
            statusNum1[i] = statusNum[i];
            System.out.println(statusNum1[i]);
        }
        for (int i = capacity; i < value; i++) {
            statusNum1[i] = statusNum1[i-1] + statusNum1[i-2];
            System.out.println(statusNum1[i]);
        }
        capacity = value;
        statusNum = statusNum1;
        return statusNum[capacity - 1];
    }
}
