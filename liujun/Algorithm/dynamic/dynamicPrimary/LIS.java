package Algorithm.dynamic.dynamicPrimary;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-27 22:04
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description: �����������
 */
//LongestIncreasingSubsequence
public class LIS {

    public String longestIncreasingSubsequence(String sequence){

        System.out.println("sequence:"+sequence);
        int length = sequence.length();
        char[] c = sequence.toCharArray();
        //ԭʼ����ֵ������
        int[] intarray = new int[length];
        int count = 0;
        for (char c1:c) {
            int i = Integer.parseInt(String.valueOf(c1));
            intarray[count++] = i;
        }
        //��¼��ǰ���ֵ������
        int[] longest = new int[length];
        int best = 0;
        //point���ڼ�¼ֵ
        int point = 0;
        Arrays.fill(longest,1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if((intarray[j] < intarray[i])&&((longest[j] + 1) > longest[i])){
                    longest[i] = longest[j] + 1;
                }
            }
            if(longest[i] > best){
               best = longest[i];
               point = i;
            }
        }
        //Ѱ��ֵ
        StringBuffer sb = new StringBuffer();
        sb.append(intarray[point]);
        for (int i = point - 1; i >= 0; i--) {
            if(longest[i] == longest[point] - 1){
                sb.append(intarray[i]);
                point = i;
            }
        }
        System.out.println("longest num:"+best);
        System.out.println("longest���飺"+Arrays.toString(longest));
        System.out.println("LongestIncreasingSubsequence:"+sb.reverse().toString());

        return "";
    }
}
