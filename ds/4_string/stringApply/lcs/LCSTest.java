package stringApply.lcs;

import java.util.Random;

public class LCSTest {

	//����һ�������Сд�����ֵ�����
	public String random_sequence() {
		
		Random ran=new Random();
		String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//�������г���ֵ,С��20
		int n=ran.nextInt(20)+1;//Random.nextInt(int n),��ֵ����[0,n)�����䣬����0��������n��
		//�ַ�������
		String  s="";
		
		//������ɡ���д��ĸ������Сд��ĸ���������֡�
		int m=0;//mȡֵ1��2��3����ʾѡ�񡰴�д��ĸ������Сд��ĸ���������֡�
		while(n>0){
			m=ran.nextInt(3);
			switch(m){
			  case 0:
				  int y=ran.nextInt(26);
				  s+=alpha.subSequence(y, y+1);
				  break;
			  case 1:
				  int h=ran.nextInt(26);
				  CharSequence g=alpha.subSequence(h, h+1);
				  s+=g.toString().toLowerCase();
				  break;
			  case 2:s+=ran.nextInt(10);
				  break;
			  default:
				  break;
			}
			n--;
		}
		//�������ַ���
		return s;
	}
	
	public static void main(String[] args) {
		
		//��ȡ����ַ���
		LCSTest lt = new LCSTest();
		String s1 = lt.random_sequence();
		String s2 = lt.random_sequence();
		System.out.println("�ַ���s1:"+ s1);
		System.out.println("�ַ���s2:"+ s2);
		
		//�ַ���ƥ��
		new LCS(s1, s2);
		//System.out.println("======================");
		new LCS_optimize(s1, s2);
		
	}
}
