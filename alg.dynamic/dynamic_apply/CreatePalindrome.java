package dynamic_apply;
/** 
 *@author liujun
 *@date�� 2018-8-19 ����01:34:47
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *����һ����������ָ�룬ͷָ��ָ���ַ����ײ���βָ��ָ���ַ���β������ͷβָ����ȣ�
 *     ͷָ��Ӽӣ�βָ����������м俿£��������ȣ����һ���жϣ�ͷָ��++��βָ�룩
 *     �ͣ�ͷָ�룬βָ��--�����Ƿ���ڻ��ģ����õݹ���ɡ�
 *����������Ȼ����ͨ����ӹ�����ģ���ôҲ����ͨ��ɾ��һ��������ġ�
 *���������ж�ԭ�ַ����ͷ�ת�ַ���������������г����Ƿ��ԭ�ַ�������С1�����
 *ע�⣺����дһ�������жϺ�����
 *@version 1.0
 */
public class CreatePalindrome {

	//����һ����λ�Ա�
	public void headAndTail(String test) {
		// TODO Auto-generated method stub
		System.out.println("����һ����λ�Աȣ�����");
		int length = test.length();
		for (int head = 0, tail = length - 1; head < tail; head++, tail--) {
			if(test.charAt(head) != test.charAt(tail)){
				if(PalindromeJudge(test.substring(head, tail)) ||
						PalindromeJudge(test.substring(head + 1, tail+ 1))){
					System.out.println("OK!");
					return;
				}else {
					System.out.println("NO Match!");
					return;
				}
			}
		}
	}
	
	//��������ɾ������
	public void useDelete(String test) {
		// TODO Auto-generated method stub
		System.out.println("��������ɾ�����죬����");
		
		for (int i = 0; i < test.length(); i++) {
			char[] test_char = test.toCharArray();
			test_char[i] = ' ';
			String test_copy = String.valueOf(test_char).replace(" ", "");
			if(PalindromeJudge(test_copy)){
				System.out.println("OK!");
				return;
			}
		}
		System.out.println("NO Match!");
	}
	
	//��������LCS˼��
	public void useLCS(String test) {
		// TODO Auto-generated method stub
		System.out.println("��������LCS˼�룬����");
		//���Ȼ�ȡ�ַ������Ⱥͷ�ת�ַ���
		int length = test.length();
		String test2 = new StringBuffer(test).reverse().toString();
		//����LCSƥ��
		int[][] matrix = new int[length + 1][length + 1];
		for (int i = 0; i < length; i++) {
			matrix[i][0] = 0;
			matrix[0][i] = 0;
		}
		for (int i = 1; i < length + 1; i++) {
			for (int j = 1; j < length + 1; j++) {
				if(test.charAt(i - 1) == test2.charAt(j - 1)){
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				}else {
					matrix[i][j] = matrix[i - 1][j] > matrix[i][j - 1] ? 
							matrix[i - 1][j] : matrix[i][j - 1];
				}
			}
		}
		//�ж�ƥ�����Ƿ���ڳ��Ȼ��߳��ȼ�һ
		if(matrix[length][length] == length || matrix[length][length] == length - 1){
			System.out.println("OK!");
			return;
		}
		System.out.println("NO Match!");
	}
	
	//�����ж�
	public boolean PalindromeJudge(String s) {
		// TODO Auto-generated method stub
		boolean flag = new StringBuffer(s).reverse().toString().equals(s);
	    return flag;
	}
	
	//����������
	public static void main(String[] args) {
		String test1 = "asdsqa";
		String test2 = "abcdbca";
		String test3 = "bhuuhbo";
		CreatePalindrome cp = new CreatePalindrome();
		//����һ
		cp.headAndTail(test1);
		cp.headAndTail(test2);
		cp.headAndTail(test3);
		//������
		cp.useDelete(test1);
		cp.useDelete(test2);
		cp.useDelete(test3);
		//������
		cp.useLCS(test1);
		cp.useLCS(test2);
		cp.useLCS(test3);
	}
}
