package DataStructure.string.stringApply;

/** 
 *@author liujun
 *@date�� 2018-12-17 ����02:14:33
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 *@URL:https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 *@version 1.0
 */
//LongestnoRepeatSubstring
public class LNRSubstring {

	public int lengthOfLongestSubstring(String s) {
	    
		//���ڼ�¼��Ͱ
	    int[] bottle = new int[128];
	    int count = 0;
	    
		for (int begin = 0, j = 0; j < s.length(); j++) {
			//�ҳ��Ӵ���ʼλ��
			begin = Math.max(bottle[s.charAt(j)], begin);
			//���¼�¼ֵ
			count = Math.max(count, j - begin +1);
			//����Ͱ��Ŷ�Ӧ���Ӵ���ʼλ��
			bottle[s.charAt(j)] = j + 1;
		}
		return count;
    }
}
