package Algorithm.dynamic.lcs;

/**
 *@author 
 *@date�� 2018-7-19 ����10:52:22
 *@author��Email:@mail.ustc.edu.cn
 *@description:lcs�Ľ��㷨��ֻ��һ�����鼴���Ի�ȡƥ�������ֵ����ʡ�˿ռ䣬
 *�����޷���ȡƥ��ƥ����ַ�����
 *@version 1.0
 */
public class LCS_optimize {
	public static void main(String[] args) {
		new LCS_optimize("75C70a3G", "7Md0Iltj2R");
	}

	public LCS_optimize(String s1, String s2){
		
		//��ȡ�ַ�������,�����ھ�����n1��ʾ����,n2��ʾ����
		int n1 = s1.length();
		int n2 = s2.length();
		
		//��ֵ���� ����ַ�ƥ�����������ֵ
		int [] lcs_opt_matrix = new int [n2+1];
		//��ʼ������
		lcs_opt_matrix[0] = 0;
		
		//temp����������һ�α���ʱ��ǰλ�����ֵ
		int temp_before = 0;
		int temp_after = 0;
		
		//����ƥ��
		for (int i = 0; i < n1; i++) {
			for (int j = 1; j <= n2; j++) {
				//�ݴ浱ǰֵ
				temp_before = lcs_opt_matrix[j];
				//���ַ�ƥ����ȣ��Խ���ֵ��һ
				if(s1.charAt(i) == s2.charAt(j-1)){
					//�ر�ע�⣺��ѭ����1ʱ��temp_after�����Ͻ���0����������һ�е�ĩβ
					if(j == 1){
						temp_after = 0;
					}
					lcs_opt_matrix[j] = temp_after + 1;
				}else {
					//������ֵ˭��
					lcs_opt_matrix[j] = lcs_opt_matrix[j] > lcs_opt_matrix[j-1] ? 
							lcs_opt_matrix[j] : lcs_opt_matrix[j-1];
				}
				//�ݴ�ֵ����
				temp_after = temp_before;
			}
		}
		//������ַ�ƥ�����������ֵ
		System.out.println("LCS_optimize������ַ�������Ϊ��"+lcs_opt_matrix[n2]);
	}
}
