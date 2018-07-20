package lcs;
/** 
 *@author liujun
 *@date�� 2018-7-19 ����10:52:22
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:lcs�Ľ��㷨��ֻ��һ�����鼴���Ի�ȡƥ�������ֵ����ʡ�˿ռ䣬
 *�����޷���ȡƥ��ƥ����ַ�����
 *@version 1.0
 */
public class LCS_optimize {

	public LCS_optimize(String s1, String s2){
		
		//��ȡ�ַ�������,�����ھ�����n1��ʾ����,n2��ʾ����
		int n1 = s1.length();
		int n2 = s2.length();
		
		//��ֵ���� ����ַ�ƥ�����������ֵ
		int [] lcs_opt_matrix = new int [n2+1];
		//��ʼ������
		lcs_opt_matrix[0] = 0;
		
		//temp����������һ�α���ʱ��ǰλ�����ֵ
		int temp = 0;
		int temp1 = 0;
		//����ƥ��
		for (int i = 0; i < n1; i++) {
			for (int j = 1; j <= n2; j++) {
				temp1 = lcs_opt_matrix[j];
				
				if(s1.charAt(i) == s2.charAt(j-1)){
					lcs_opt_matrix[j] = temp + 1;
				}else {
					lcs_opt_matrix[j] = lcs_opt_matrix[j] > lcs_opt_matrix[j-1] ? 
							lcs_opt_matrix[j] : lcs_opt_matrix[j-1];
				}
				temp = temp1;
			}
		}
		//������ַ�ƥ�����������ֵ
		System.out.println("������ַ�������Ϊ��"+lcs_opt_matrix[n2]);
	}
}
