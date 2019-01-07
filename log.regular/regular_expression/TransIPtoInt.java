package regular_expression;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-8-28 ����02:14:14
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��string���͵�IP��ַת����int
 *@version 1.0
 */
public class TransIPtoInt {

	public int iPToInt(String ip) throws Exception {

		//������ʽ��IP�����ж�
		ip = ip.trim();
		String regular = "^[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}$";
		if(!ip.matches(regular)){
			throw new Exception("IP��ַ����");
		}
		//IPת��Ϊint
		int hex = 8;
		int ipnum = 0; 
		//����á�.����Ϊ�ָ��Ļ�,����������д��,String.split("\\."),����������ȷ�ķָ���,������String.split(".");
		String[] iparray = ip.split("\\.");
		for (int i = 0; i < iparray.length; i++) {
			if(Integer.parseInt(iparray[i]) > 255){
				throw new Exception("IP��ַ����255");
			}
			int f = Integer.parseInt(iparray[i]);
			f = f << (iparray.length - i - 1) * hex;
			ipnum += f;
		}
		return ipnum;
	}
	
	//int��תIP
	public String intToIP(int ipnum) {

		String intnum = "";
		int hex = 8; 
		int count = 1;
		for (int j = 3; j > 0; j--) {
			intnum += ipnum / ((count << (hex * j)) - 1);
			ipnum %= count << (hex * j);
			intnum += ".";
		}
		return intnum += ipnum;
	}
	
	//����������
	public static void main(String[] args) throws Exception {
		
		String ip = "0.256.1.53";
		Scanner scan = new Scanner(System.in);
		ip = scan.nextLine();
		TransIPtoInt tp = new TransIPtoInt();
		int ipnum = tp.iPToInt(ip);
		System.out.println(ipnum);
		
		System.out.println(tp.intToIP(ipnum));;
		
	}
}
