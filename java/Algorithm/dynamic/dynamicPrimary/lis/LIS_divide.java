package Algorithm.dynamic.dynamicPrimary.lis;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-09 00:24
 * @author��Email: liujunfirst@outlook.com
 * @description: �����������
 * @blogURL:
 */
public class LIS_divide {
    public int longestIncreasingSubsequence(String sequence) {

        if (sequence == null || sequence.length() == 0) {
            return 0;
        }
        char[] c = sequence.toCharArray();
        //ԭʼ����ֵ������
        int[] intArray = new int[sequence.length()];
        int count = 0;
        for (char c1 : c) {
            intArray[count++] = Integer.parseInt(String.valueOf(c1));
        }

        //��ʽ������η�
        int piles = 0;
        int poker = 0;
        int left, right, mid;
        int[] top = new int[count];
        for (int i = 0; i < count; i++) {
            left = 0;
            right = piles;
            poker = intArray[i];
            while (left < right) {
                mid = (left + right) / 2;
                if (poker < top[mid]) {
                    right = mid;// ? right = mid-1;
                } else if (poker > top[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if(left == piles){
                piles++;
            }
            top[left] = poker;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < piles; i++) {
            stringBuffer.append(top[i]);
        }
        //return stringBuffer.toString();
        return piles;//����
    }
}