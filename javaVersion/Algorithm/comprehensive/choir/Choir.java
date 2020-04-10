package Algorithm.comprehensive.choir;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-02-12 09:37
 * @author��Email  liujunfirst@outlooChoseNum.com
 * @description  �ϳ���
 * �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n��ѧ����
 * *����˳��ѡȡ ChoseNum��ѧ����Ҫ����������ѧ����λ�ñ�ŵĲ���� d��
 * *ʹ���� ChoseNum��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 * @blogURL
 */
public interface Choir {

    public int getMaxValue(int[] array, int choseNum, int intervald);

    default boolean check(int[] array, int choseNum, int interval) {
        if (array == null || array.length == 0 ||
                choseNum <= 0 || choseNum > array.length ||
                interval <= 0|| interval > array.length) {
            return false;
        }
        return true;
    }
}
