package Algorithm.dynamic.dynamicPrimary.lis;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-27 22:04
 * @author��Email:liujunfirst@outlook.com
 * @description: �����������
 */
//LongestIncreasingSubsequence
public class LIS {

    public int longestIncreasingSubsequence(String sequence) {

        if (sequence == null || sequence.length() == 0) {
            return 0;
        }
        int length = sequence.length();
        char[] c = sequence.toCharArray();
        //ԭʼ����ֵ������
        int[] intArray = new int[length];
        int count = 0;
        for (char c1 : c) {
            int i = Integer.parseInt(String.valueOf(c1));
            intArray[count++] = i;
        }
        //��¼��ǰ���ֵ������
        int[] longest = new int[length];
        int best = 0;
        //point���ڼ�¼ֵ
        int point = 0;
        Arrays.fill(longest, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ((intArray[j] < intArray[i])) {
                    longest[i] = (longest[j] + 1) > longest[i] ? (longest[j] + 1) : longest[i];
                }
            }
            if (longest[i] > best) {
                best = longest[i];
                point = i;
            }
        }
        //Ѱ��ֵ
        StringBuffer sb = new StringBuffer();
        sb.append(intArray[point]);
        for (int i = point - 1; i >= 0; i--) {
            if (longest[i] == longest[point] - 1) {
                sb.append(intArray[i]);
                point = i;
            }
        }
        //System.out.println("longest num:"+best);
        //System.out.println("longest���飺"+Arrays.toString(longest));
        //System.out.println("LongestIncreasingSubsequence:"+sb.reverse().toString());
        //return sb.reverse().toString();
        return best;
    }
}
