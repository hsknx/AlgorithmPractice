package Algorithm.dynamic.dynamicPrimary.palindrome;
/** 
 *@author liujun
 *@date�� 2018-8-19 ����01:34:47
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: ����һ���ַ���s������Դ��� ��� һ�� �ַ���ʹ��ʣ�µĴ���һ�����Ĵ���
 * ���ͨ�����һ���ַ��õ����ģ��򷵻�ɾ��Ԫ�ص�λ��(��ʼ��ַ��1)�����򷵻� -1��
 * ��������ǻ��ģ������м��λ�ã�
 *
 *����һ����������ָ�룬ͷָ��ָ���ַ����ײ���βָ��ָ���ַ���β������ͷβָ����ȣ�
 *     ͷָ��Ӽӣ�βָ����������м俿£��������ȣ����һ���жϣ�ͷָ��++��βָ�룩
 *     �ͣ�ͷָ�룬βָ��--�����Ƿ���ڻ��ģ����õݹ���ɡ�
 *����������Ȼ����ͨ����ӹ�����ģ���ôҲ����ͨ��ɾ��һ��������ġ�
 *���������ж�ԭ�ַ����ͷ�ת�ַ���������������г����Ƿ��ԭ�ַ�������С1�����
 *ע�⣺����дһ�������жϺ�����
 *
 * ��֤�����ͨ�����һ���ַ��õ����ģ��򷵻�ɾ��Ԫ�ص�λ��(��ʼ��ַ��0)�����򷵻� -1.
 *@version 1.0
 */
public class CreatePalindromebyAdd {

	//����һ����λ�Ա�
	public int headAndTailCompare(String testString) {
		if(testString == null || testString.length() == 0){
			return -1;
		}
		if(PalindromeJudge(testString)){
			return testString.length()/2;
		}
		int length = testString.length();
		for (int head = 0, tail = length - 1; head < tail; head++, tail--) {
			if(testString.charAt(head) != testString.charAt(tail)){
				//�����ͷָ�벻���
				if(PalindromeJudge(testString.substring(head, tail))){
					return tail;
				}else if(PalindromeJudge(testString.substring(head + 1, tail+ 1))){
					return head;
				}else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	//��������ɾ������
	public int useDelete(String testString) {

		if(testString == null || testString.length() == 0){
			return -1;
		}
		if(PalindromeJudge(testString)){
			return testString.length()/2;
		}
		for (int i = 0; i < testString.length(); i++) {
			String SourceString = testString.replaceFirst(String.valueOf(testString.charAt(i)),"");
			if(PalindromeJudge(SourceString)){
				return i;
			}
		}
		return -1;
	}
	
	//��������LCS˼��
	public int useLCS(String testString) {

		if(testString == null || testString.length() == 0){
			return -1;
		}
		if(PalindromeJudge(testString)){
			return testString.length()/2;
		}
		//���Ȼ�ȡ�ַ������Ⱥͷ�ת�ַ���
		int length = testString.length();
		String test2 = new StringBuffer(testString).reverse().toString();
		//����LCSƥ��
		int[][] matrix = new int[length + 1][length + 1];
		for (int i = 1; i < length + 1; i++) {
			for (int j = 1; j < length + 1; j++) {
				if(testString.charAt(i - 1) == test2.charAt(j - 1)){
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				}else {
					matrix[i][j] = matrix[i - 1][j] > matrix[i][j - 1] ? 
							matrix[i - 1][j] : matrix[i][j - 1];
				}
			}
		}
		int flag = 0;
		for (int i = 1, j = 1; j < length; i++, j++) {
			if(matrix[i][j] == matrix[i+1][j+1]){
				flag = i + 1;
				break;
			}
		}
		//�ж�ƥ�����Ƿ���ڳ��Ȼ��߳��ȼ�һ
		if(matrix[length][length] == length - 1){
			return flag;
		}
		return -1;
	}
	
	//�����ж�
	public boolean PalindromeJudge(String testString) {
		if(testString == null || testString.length() == 0){
			return false;
		}
		boolean flag = new StringBuffer(testString).reverse().toString().equals(testString);
	    return flag;
	}
}
