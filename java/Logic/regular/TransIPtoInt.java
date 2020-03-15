package Logic.regular;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-8-28 ����02:14:14
 *@author��Email:liujunfirst@outlook.com
 *@description:��string���͵�IP��ַת����int
 *@attention:���ǵ�int���͵���󳤶�Ϊ32λ���ڼ����ʱ���������⣬��˳˻�ѡ��long�������洢��
 *@version 1.0
 */
public class TransIPtoInt {
	
	//IPת��Ϊint
	public long iPToInt(String ip) {
		
		//������ʽ��IP�����ж�
		ip = ip.trim();
		String regular = "^[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}$";
		if(!ip.matches(regular)){
			//throw new Exception("IP��ַ����");
			return -1;
		}
	
		//ע��1������á�.����Ϊ�ָ��Ļ�,����������д��,String.split("\\."),����������ȷ�ķָ���,������String.split(".");
		//ע��2��IP��ַ��顣
		String[] iparray = ip.split("\\.");
		int hex = 8;
		long ipnum = 0; 
		for (int i = 0; i < iparray.length; i++) {
			if(Integer.parseInt(iparray[i]) > 255){
				//throw new Exception("IP��ַ����255");
				return -1;
			}
			long f = Integer.parseInt(iparray[i]);
			//ע�⣺�ȳ˳�,ȷ����λ��������λ
			f = f << (iparray.length - i - 1) * hex;
			ipnum += f;
		}
		return ipnum;
	}
	
	
	//int��תIP
	public String intToIP(long ipnum) {

		String intnum = "";
		int hex = 8; 
		int count = 1;
		for (int j = 3; j > 0; j--) {
			intnum += ipnum / (count << hex * j);
			ipnum %= (count << hex * j);
			intnum += ".";
		}
		return intnum += ipnum;
	}

}
