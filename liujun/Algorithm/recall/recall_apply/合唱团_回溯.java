package Algorithm.recall.recall_apply;

import java.util.Scanner;

/**
 *@author liujun
 *@date�� 2018-5-2 Time������11:00:55
 *@author��Email:liujunfirst@outlook.com
 *@description:�� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n��ѧ����
 *����˳��ѡȡ k��ѧ����Ҫ����������ѧ����λ�ñ�ŵĲ���� d��
 *ʹ���� k��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 *@version 1.0
 */
public class �ϳ���_���� {

	//ѧ��������ѧ������ֵ����
	static int student_num ;
	static long [] student_power ;
	
	//ɸѡ���ֵ����¼�����ѡ����ֵ�������������
	static long sum_best = 1;
	static long [] student_chosed_power ;
	static long [] student_chosed_num ;
	
	//ɸѡ��ʱֵ����¼��ѡ����ֵ����ʱ��������
	static long sum_temp = 1;
	static long [] student_temp_power ;
	static long [] student_temp_num ;
	
	//��ѡk��ѧ��������d�����
	static int k ,d ;
	
	//��̬�滮��ʼ������ݹ���ȡ�����ʱֵ
	static int depth = 0;
	
	//�ݹ鴫��ݹ���Ⱥ��ֵ���ѧ�����
	public void digui (int depth, int start){
		//�߽������ж�
		if (depth > k) {
			if(sum_temp > sum_best && distance(student_temp_num)){
				sum_best = sum_temp;
				for (int e = 0; e < student_temp_power.length; e++) {
					student_chosed_num[e] = student_temp_num[e];
					student_chosed_power[e] = student_temp_power[e];
				}
			}
			return ;
		}
		
		for (int j = start; j < student_num; j++) {
			if(student_power[j] == 0){
				continue;
			}
			sum_temp *= student_power[j];
			student_temp_power[depth] = student_power[j];
			student_temp_num[depth] = j;
			
			digui(depth+1, j+1);
			
			sum_temp /= student_power[j];
			student_temp_power[depth]= 0;
			student_temp_num[depth] = 0;
		}
		
		return;
	}
	
	public boolean distance(long [] student_chose_num){
		for (int u = 0; u < student_chose_num.length -1; u++) {
			if(student_chose_num[u+1] - student_chose_num[u] > d){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter student_num");
		student_num = scan.nextInt();
		student_power = new long [student_num];
		
		//����ֵ��ֵ
		System.out.println("enter several student_power");
		for (int i = 0; i < student_num; i++) {
			student_power[i] = scan.nextInt();
		}

		//��ȡk��ѧ��������d�����
		System.out.println("set k student");
		k = scan.nextInt();
		System.out.println("set d distance");
		d = scan.nextInt();
		
		//��¼��ѡѧ������ֵ�Ͷ�Ӧ���
		student_temp_power = new long[k];
		student_temp_num = new long[k];
		student_chosed_power = new long[k];
		student_chosed_num = new long[k];
		
		k--;
		
		new �ϳ���_����().digui(0, 0);
		System.out.print(sum_best);
		
	}
	
}
