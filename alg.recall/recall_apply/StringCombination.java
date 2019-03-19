package recall_apply;
/** 
 *@author liujun
 *@date�� 2018-8-23 ����09:56:39
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�������ַ�������ȫ���еķ�ʽ��ӡ���
 *@version 1.0
 *@attation:1.Java�ַ�����������:2�ַ�ʽ��
 *          2.ѭ����i = depth
 */
public class StringCombination {

	//
	public void Permutation(char[] c, int depth) {
		// TODO Auto-generated method stub

		//�߽�ֵ�ж�
		if (depth == c.length - 1) {
			//System.out.println(c);
			System.out.println(String.valueOf(c));
			return;
		}
		//ע�⣺�˴�i = depth��i֮ǰ��Ԫ���Ѿ�����ֻ�Ժ���Ԫ�ؽ���ȫ����
		for (int i = depth; i < c.length; i++) {
			//����Ԫ�ؽ���
			char ch_temp = c[i];
			c[i] = c[depth];
			c[depth] = ch_temp;
			Permutation(c, depth + 1);
		}
	}
	
	//����������
	public static void main(String[] args) {
		String s = "ABCD";
		char[] c = s.toCharArray();
		StringCombination sc = new StringCombination();
		sc.Permutation(c, 0);
	}
}
