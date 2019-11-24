package DataStructure.sort.innerSort.innerSortApply;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-9-5 ����08:35:45
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description: ��һ��ѹ������ַ�����ѹ�����������������
 * ��ѹ���ַ����������ŵ����ֱ�ʾ���ַ�����Ҫ�ظ����Ρ�
 * ��������ͬ�����֣��硰c2a2��,����ASCII��������Ӧ�����aacc��
 * ����ͬ�����֣����ճ���˳���ѹ��
 */
public class Decompress {

    public String decompression(String source) {

        if (source == null || source.length() == 0) {
            return "";
        }
        //ƥ����ʽ��alpha�����зָ��������ĸ��number�����зָ����������
        String[] alpha = source.split("[0-9]+");
        String[] number = source.split("[a-zA-Z]+");

        boolean flag = true;
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 0) {
                flag = String.valueOf(source.charAt(i)).matches("[a-zA-Z]+") ? true : false;
            } else {
                flag = String.valueOf(source.charAt(i)).matches("[0-9]+") ? true : false;
            }
            if (!flag) {
                return "";
            }
        }

        //num��Ϊ�˺�������numreally������Ӱ���alphaһ��һ
        int[] numberfront = new int[number.length - 1];
        int[] numberfollow = new int[number.length - 1];
        int count = 0;
        //stringתint
        for (int i = 0; i < number.length; i++) {
            if (number[i].matches("[0-9]+")) {
                numberfront[count] = Integer.parseInt(number[i]);
                numberfollow[count] = Integer.parseInt(number[i]);
                count++;
            }
        }
        //���򣬴�С����
        Arrays.sort(numberfront);
        StringBuffer sb = new StringBuffer();
        //ѡ�����򣬰�����ĸ˳��������ͬ��������ĸ
        for (int i = 0; i < numberfront.length - 1; i++) {
            for (int j = i; j < numberfollow.length; j++) {
                //��ͬ���������İ���asc������
                if ((numberfollow[j] == numberfront[i]) && (alpha[i].charAt(0) - alpha[j].charAt(0) > 0)) {
                    String sd = alpha[i];
                    alpha[i] = alpha[j];
                    alpha[j] = sd;
                }
            }
        }
        //�����ַ���
        for (int i = 0; i < numberfollow.length; i++) {
            for (int j = 0; j < numberfollow[i]; j++) {
                sb.append(alpha[i]);
            }
        }
        return sb.toString();
    }
}
