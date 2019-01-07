package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date�� 2018-5-13 Time������10:31:25
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:trans digital to capital
 *@version 1.0
 */
public class DigitalTrans {

	String[] digital = {"��","Ҽ","��","��","��","��","½","��","��","��"};
	String[] element = {"Ԫ","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��"};
	
	public String trans(String num) throws Exception {
		
		//1.ȥ�ո�
		num = num.trim();
		//2.�����жϣ� 2.1 ����һ��С����Ͷ�����֣������ַ������ԡ�  
		//         2.2 ��0��ͷ�Ĳ���ȷ(022,02.2)������0.x
		if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
			throw new Exception("Ǯ����ʽ����");
		}
		
		//3.�ֳ�������С�����ִ���
		//4.������С�����ֺϲ���ȥ��
		

		return num;
	}
	
	public static void main(String[] args) {

		while(true){
			Scanner scan = new Scanner(System.in);
			DigitalTrans dt = new DigitalTrans();
			try {
				System.out.println(dt.trans(scan.next()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
