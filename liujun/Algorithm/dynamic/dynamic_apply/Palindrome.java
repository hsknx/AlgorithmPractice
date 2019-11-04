package Algorithm.dynamic.dynamic_apply;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-8-16 ����11:19:38
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ���
 *���ɾ������ʹ�û��Ĵ���أ������Ҫɾ�����ַ�������
 *@version 1.0
 */
public class Palindrome {

	//������Ĵ�
	private int buildPalindrome(String s) {
		// TODO Auto-generated method stub
		//�����ַ���s1
		String s1 = s;
		StringBuffer sb = new StringBuffer(s1);
		//�õ���ת�ַ���s2
		String s2 = sb.reverse().toString();
		//�õ����鳤��
		int no = s1.length();
		//��¼������
		int a[][] = new int[no+1][no+1];
		//��ʼ����¼����
		for(int y = 0; y < no+1; y++) {
			a[0][y] = 0;
			a[y][0] = 0;
		}
		//�����������ƥ��
		for(int i = 1; i < no+1; i++){
			for(int j = 1; j < no+1; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					a[i][j] = a[i-1][j-1] + 1;
				}
				else{
					if(a[i][j-1] > a[i-1][j]){
						a[i][j] = a[i][j-1];
					}else{
						a[i][j] = a[i-1][j];
					}
				}
			}
		}
		//ƥ�����󳤶�
		int match = a[no][no];
		//��Ҫɾ�����ĳ���
		match = no - match;
		return match;
	}
	
	//����������
	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(pal.buildPalindrome(str));
	}
}
