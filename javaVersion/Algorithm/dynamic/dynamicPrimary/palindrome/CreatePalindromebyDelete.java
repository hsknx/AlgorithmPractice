package Algorithm.dynamic.dynamicPrimary.palindrome;

/** 
 *@author liujun
 *@date 2018-8-16 ����11:19:38
 *@author��Email liujunfirst@outlook.com
 *@description  ����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ���
 *���ɾ������ʹ�û��Ĵ���أ������Ҫɾ�����ַ�������
 *@version 1.0
 */

//CreatePalindromebyDelete
public class CreatePalindromebyDelete {

	//������Ĵ�
	public int useLcs(String testString) {
		if(testString == null || testString.length() == 0){
			return -1;
		}
		//�õ���ת�ַ���s2
		String s2 = new StringBuffer(testString).reverse().toString();
		//�õ����鳤��
		int length = testString.length();
		//��¼������
		int a[][] = new int[length+1][length+1];
		//�����������ƥ��
		for(int i = 1; i < length+1; i++){
			for(int j = 1; j < length+1; j++){
				if(testString.charAt(i - 1) == s2.charAt(j - 1)) {
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
		int match = a[length][length];
		//��Ҫɾ�����ĳ���
		match = length - match;
		return match;
	}
}
