package stringApply.lcs;

import java.util.ArrayList;
import java.util.List;

/**
 *@author 
 *@date�� 2018-7-19 Time������10:15:35
 *@author��Email:@mail.ustc.edu.cn
 *@description:LCS�㷨���ҳ������ַ������ƥ���Ӵ���
 *@version 1.0
 */

public class LCSforcompare {

	//��ȡ�ַ�������,�����ھ�����n1��ʾ����,n2��ʾ����
	int n1;
	int n2;
	//��ֵ���� ����ַ�ƥ�����������ֵ
	int [][] num_matrix;
	//��Ǿ��� ����ַ�ƥ����
	char [][] char_matrix;
	//��Ѱƥ���ϵ��ַ���
	List <Character> ComparedList = new ArrayList<Character>();

	public LCSforcompare(){
	}

	public void Lcsforcompare(String s1, String s2) {

		//��ȡ�ַ�������,�����ھ�����n1��ʾ����,n2��ʾ����
		n1 = s1.length();
		n2 = s2.length();
		
		//��ֵ���� ����ַ�ƥ�����������ֵ
		num_matrix = new int [n1+1][n2+1];
		//��Ǿ��� ����ַ�ƥ����
		char_matrix = new char[n1+1][n2+1];
		
		//��ֵ�����ʼ������δ��ʼ��,��ֵ������ʾΪ0,��Ǿ�����ʾΪ�ڣ�
		for (int i = 0; i < n1; i++) {
			num_matrix[i][0] = 0;
			char_matrix[i][0] = 0;
		}
		for (int j = 0; j < n2; j++) {
			num_matrix[0][j] = 0;
			char_matrix[0][j] = 0;
		}
		
		//����ƥ��,��ÿһ�У����У���ʼƥ��
	    //��ʼ���Ĳ��ֲ��ÿ��ǣ�ƥ���1��ʼ
		for(int row = 1;row <= n1; row++){
			//������
			for(int column = 1; column <= n2; column++){
				num_matrix[row][column]=0;//��ʼ����ֵ����
				char_matrix[row][column]=0;//��ʼ����Ǿ���
				
				if(s1.charAt(row-1) == s2.charAt(column-1)){//�ַ���Ԫ��ƥ�����
					num_matrix[row][column] = num_matrix[row-1][column-1]+1;//ȡ�������Ͻ���ֵ��һ
					char_matrix[row][column] = '�I';//ƥ���ǣ��������Ѱ�ң�
				}
				else{//�ַ���Ԫ��ƥ�䲻��
					if(num_matrix[row-1][column] > num_matrix[row][column-1]){
						num_matrix[row][column] = num_matrix[row-1][column];//ȡ������һ����ֵ
						char_matrix[row][column] = '��';//����Ѱ�ұ��
					}else{
						num_matrix[row][column] = num_matrix[row][column-1];//ȡ���������ֵ
						char_matrix[row][column] = '��';//����Ѱ�ұ��
					}
				}
			}
		}

		//��Ѱƥ���ϵ��ַ���
		for(int i = n1,j = n2; i > 0&&j > 0;){
			if(char_matrix[i][j] == '�I'){
				ComparedList.add(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(char_matrix[i][j] == '��'){
				    i--;
			     }
			     else{
				    j--;
			     }
		}
		
	}

	public int getCompareLength(){

		//System.out.println("LCS's length:");
		return num_matrix[n1][n2];
	}

	public String getCompareSequence(){
		//��ӡƥ���ϵ��ַ����������ӡ��
		//System.out.print("LCS:");
		StringBuffer sb = new StringBuffer();
		for(int as = ComparedList.size()-1; as >= 0; as--){
			sb.append(ComparedList.get(as));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LCSforcompare l = new LCSforcompare();
		l.Lcsforcompare("���˿ͻ����ݷ���Ӧ��","2017��ȴ������ھ�ģ����");
		System.out.println(l.getCompareLength());
		System.out.println(l.getCompareSequence());
	}
}
