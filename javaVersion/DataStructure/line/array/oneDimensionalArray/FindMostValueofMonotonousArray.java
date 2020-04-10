package DataStructure.line.array.oneDimensionalArray;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-08 19:50
 * @author��Email  liujunfirst@outlook.com
 * @description  �������飬�����������ֵ�����/��Сֵ��
 * ���������
 * 1������������
 * 2�������ݼ���
 * 3�����������
 * 4���ȼ�����
 * 5����ֵ����
 * @blogURL
 */
public class FindMostValueofMonotonousArray {

    public static int maxValue = 0;
    public static int minValue = 0;

    public void find(int[] array) {

        //��֤�Ƿ�Ϊ��ֵ
        if (array[0] == array[1]) {
            maxValue = array[0];
            minValue = array[0];
            return;
        }
        int left = 0;
        int bound = array.length - 1;
        int right = bound;
        int mid = (left + right) / 2;
        //�ȵ���
        if (array[0] < array[1]) {
            while (mid > 0 && mid < bound) {//��ֹԽ��
                if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                    maxValue = array[mid];
                    minValue = Math.min(array[0], array[bound]);
                    break;
                    //�����ڵ�����
                } else if (array[mid] > array[mid - 1]) {
                    left = mid + 1;//ע���һ
                    mid = (left + right) / 2;
                    //���뵥����
                } else {
                    right = mid;
                    mid = (left + right) / 2;
                }
            }
            //������
            if (mid == bound) {
                minValue = array[0];
                maxValue = array[bound];
            }
        } else {//�ȵ���
            while (mid > 0 && mid < bound) {//��ֹԽ��
                if (array[mid] < array[mid + 1] && array[mid] < array[mid - 1]) {
                    minValue = array[mid];
                    maxValue = Math.max(array[0], array[bound]);
                    break;
                    //�����ڵ�����
                } else if (array[mid] < array[mid - 1]) {
                    left = mid + 1;//ע���һ
                    mid = (left + right) / 2;
                } else {
                    //���뵥����
                    right = mid;
                    mid = (left + right) / 2;
                }
            }
            //������
            if (mid == bound) {
                maxValue = array[0];
                minValue = array[bound];
            }
        }
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }
}
