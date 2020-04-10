package Logic.math;

import java.util.Scanner;

/**
 *@author liujun
 *@date 2018-4-24 Time������12:02:48
 *@author��Email liujunfirst@outlook.com
 *@description �ٶ�һ�ֱ���ı��뷶Χ��a ~ y��25����ĸ����1λ��4λ�ı��룬
 *������ǰѸñ��밴�ֵ��������γ�һ���������£� a, aa, aaa, aaaa, aaab, 
 *aaac, �� ��, b, ba, baa, baaa, baab, baac �� ��, yyyw, yyyx, 
 *yyyy ����a��IndexΪ0��aa��IndexΪ1��aaa��IndexΪ2���Դ����ơ� 
 *��дһ������������������һ�����룬�����������Ӧ��Index.
 *˼·��
 *   ������b��ʱ��˵��a��ʱ���Ѿ�������һ��aʱ��ѭ������16276��
 *��һ��b����16276+1����Ҫ�����¼������16276-651-26-1,
 *Ȼ���Ӧ�ַ���λ����ˣ��ر�ע�⣺�����Ҫ�����ַ�������ֵ��һ,��Ϊa��0��
 *@version 1.0
 */
public class Alpha_transto_num {

	/**
	 * trans alpha to num
	 */
	public Alpha_transto_num(String s) {

		//��ȡ�ַ�������
		double [] count_num = new double [4];
	    double temp = 1;
	    double alpha_hex = 25;
	    count_num[3] = 1; 
	    
	    //�����λ��ֵ,������
	    for (int i = 0; i < 3; i++) {
			count_num[2-i] = count_num[3-i] + Math.pow(alpha_hex, temp);
			//System.out.println(count_num[2-i]);
			temp++;
		}
	    //������ֵsum
	    double sum = 0;
	    int count = s.length();
	    for (int j = 0; j < count; j++) {
	    	sum += (s.charAt(j) - 'a') * count_num[j];
		}
	    sum = sum + count - 1;
	    System.out.println("real:" + sum);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String s=scanner.next();
		s=s.trim();
		
		if(s.length()>4){
			System.out.println("error");
			return ;
		}
		
		new Alpha_transto_num(s);
		
	}
}
