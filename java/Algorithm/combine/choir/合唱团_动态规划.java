package Algorithm.combine.choir;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-6-19 ����11:40:18
 *@author��Email:liujunfirst@outlook.com
 *@description:�� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
 *Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 *@version 1.0
 */
public class �ϳ���_��̬�滮 {

	//ѧ�������Լ�ÿ��ѧ��������ֵ
	static int student_num ;
	static long [] student_power ;
	
	//��ѡk��ѧ��������d�����
	static int k ,d ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//ѧ��������ѧ������ֵ����
		System.out.println("������ѧ������:");
		student_num = scan.nextInt();
		System.out.println("������ÿ��ѧ������ֵ:");
		student_power = new long [student_num];
		
		//����ֵ��ֵ
		for (int i = 0; i < student_num; i++) {
			student_power[i] = scan.nextInt();
		}

		//��ȡk��ѧ��������d�����
		System.out.println("�������ѡȡ��ѧ������kֵ:");
		k = scan.nextInt();
		System.out.println("��������ֵd:");
		d = scan.nextInt();
		
		//����ֵ
		//��ά���飬����ֵ��ʾ��ǰ���Ž��ֵ,������ʾ��ѡ������k��ѧ����������ʾѧ������
		//ά��һ���������ֵ�б�
		long [][] max_matrix = new long[k+1][student_num+1];
		//ά��һ��������Сֵ�б�������Сֵ*��Сֵ���Եõ����ֵ��
		long [][] min_matrix = new long[k+1][student_num+1];	
		
		//��ʼ�����󡪡��г�ʼ��
		for(int i=0;i<k+1;i++){
			max_matrix[i][0] = 0;
			min_matrix[i][0] = 0;
		}
		//��ʼ�����󡪡��г�ʼ��
		for(int j=0;j<student_num+1;j++){
			max_matrix[0][j] = 0;
			min_matrix[0][j] = 0;
		}
		

		
		
	}
}
