package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date�� 2018-5-2 Time������09:34:09
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�����ַ������һ�����ʵĳ��ȣ������Կո������
 *@version 1.0
 */
public class ͳ�����һ�����ʳ��� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String string = scan.nextLine();
			//�Ӱ�ȫ�Ƕȿ��ǣ���trim()��ֹǰ����ֶ���ո�
			System.out.println(string.trim().length() - 
					string.trim().lastIndexOf(" ") - 1);
		}
	}
}
