package other;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-7-29 ����11:55:36
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��ʼ״̬��̰���ߵ���ͷ������(0,0)����������Ϊ10��
 *��β��(-10,0)������һ���ͣ�����һ���ַ���L��ʾ����������һ��R��ʾ����������һ��
 *U��ʾ����������һ��D��ʾ����������һ���ж�����Ĳ�����ʽ�᲻�ᵼ�����������Ϸ�����ײ��
 *�ᷢ�����legal�����ᷢ�����illegal��
 *@version 1.0
 */
public class Retro_Snaker {
	
	public Retro_Snaker() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Retro_Snaker_opera(String opera){
		//�ж������opera�Ƿ�Ϸ�(��������L,R,U,D)
		String match = "[LRUD]+";
		if(!opera.matches(match)){
			System.out.println("illegal input");
			return false;
		}
		//ÿһ����������������꣬ʵ�ַ�ʽ������Ҳ��������ʵ��
		int [] row = {0,-1,-2,-3,-4,-5,-6,-7,-8,-9};
		int [] column = {0,0,0,0,0,0,0,0,0,0};
		
		//��ȡ�ַ������У����в���
		for (int i = 0; i < opera.length(); i++) {
			//���濪ʼʱ��ͷ��λ��
			int head_r = row[0];
			int head_c = column[0];
			//�Բ��������ж�
			switch(opera.charAt(i)){
				case 'L'://����������ƶ���ֻ�к����귢���仯���������һ
					head_r--;
					break;
				case 'R'://����������ƶ���ֻ�к����귢���仯���������һ
					head_r++;
					break;
				case 'U'://����������ƶ���ֻ�������귢���仯���������һ
					head_c++;
					break;
				case 'D'://����������ƶ���ֻ�������귢���仯���������һ
					head_c--;
					break;
				default:
					break;
			}
			//��ÿһ�����������ж��Ƿ�����ײ�����Ҹ����������ȫ������
			for(int j = row.length-2; j >= 0; j--){
				//�ж���ͷ�������ϵ�ĳһ���غϣ�������ײ
				if(head_r == row[j] && head_c == column[j]){
					System.out.println("CRASHED!");
					return false;
				}
				else{//û�з�����ײ������������ڵ�
					row[j+1] = row[j];
					column[j+1] = column[j];
				}
		     }
			//��������ͷ�ڵ�
			row[0] = head_r;
			column[0] = head_c;
		}
		
		System.out.println("legal");
		return true;
	}

	//����������
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String opera = scan.next();
		//̰����
		Retro_Snaker sn = new Retro_Snaker();
		sn.Retro_Snaker_opera(opera);
	}
}
