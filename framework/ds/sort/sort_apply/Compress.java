package sort_apply;

import java.util.Arrays;
import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-9-5 ����08:35:45
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��һ��ѹ������ַ�����ѹ�����������������
 *��ѹ���ַ����������ŵ����ֱ�ʾ���ַ�����Ҫ�ظ����Ρ�
 *��������ͬ�����֣��硰c2a2��,����ASCII��������Ӧ�����aacc��
 *@version 1.0
 */
public class Compress {

	public String decompression(String s) {

		//ƥ����ʽ��alpha�����зָ��������ĸ��number�����зָ����������
		String[] alpha = s.split("[0-9]+");
		String[] number = s.split("[a-zA-Z]+");
		//num��Ϊ�˺�������numreally������Ӱ���alphaһ��һ
		int[] num = new int[number.length];
		int[] numreally  = new int[number.length];
		int flag = 0;
		//stringתint
		for (int i = 0; i < number.length; i++) {
			if (number[i].matches("[0-9]+")) {
				num[flag] = Integer.parseInt(number[i]);
				numreally[flag] = Integer.parseInt(number[i]);
				flag++;
			}
		}
		//���򣬴�С����
		Arrays.sort(num);
		StringBuffer sb = new StringBuffer();
		//ѡ�����򣬰�����ĸ˳��������ͬ��������ĸ
		for (int i = 0; i < numreally.length - 1; i++) {
			for (int j = i; j < numreally.length; j++) {
				if (numreally[j] == numreally[i]) {
					if (alpha[i].hashCode() > alpha[j].hashCode()) {
						String sd = alpha[i];
						alpha[i] =  alpha[j];
						alpha[j] = sd;
					}
				}
			}
		}
		//�����ַ���
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < numreally.length; j++) {
				if (numreally[j] == num[i]) {
					numreally[j] = -1;
					for (int j2 = 0; j2 < num[i]; j2++) {
						sb.append(alpha[j]);
					}
				}
			}
		}
		return sb.toString();
	}
	
	//����������
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().trim();
		//��ӡ
		System.out.println(new Compress().decompression(s));
	}
	
}
