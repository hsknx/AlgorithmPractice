package regular_expression;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-8-8 ����07:03:55
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�������ַ����Ĵ�Сд���������ʱСд��ĸ��������ǰ����д�ں�
 *@version 1.0
 */
public class ��Сд���� {

	public void trans(String s) {
		// TODO Auto-generated method stub

		String[] c1 = s.split("[a-z]");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c1.length; i++) {
			sb.append(c1[i].toLowerCase());
		}
		String[] c2 = s.split("[A-Z]");
		for (int j = 0; j < c2.length; j++) {
			sb.append(c2[j].toUpperCase());
		}
		System.out.println(sb);
	}
	
	//����������
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		��Сд���� d = new ��Сд����();
		d.trans(s);
	}
}
