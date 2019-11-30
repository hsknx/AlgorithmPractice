package Algorithm.other.other;

/** 
 *@author liujun
 *@date�� 2018-12-17 ����05:30:46
 *@author��Email:liujunfirst@outlook.com
 *@description:����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ����
 *���һ���㷨�����������ܻ�ȡ���������ע���㲻���������Ʊǰ������Ʊ��
 *@URL:https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 *@version 1.0
 */
public class ������Ʊ�����ʱ�� {

	//ֻ��������һ�ι�Ʊ
	public int justAllowOnce(int[] array) {

		int maxprofit = 0;
		int minfrice = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(minfrice > array[i]){
				minfrice = array[i];
			}
			if(array[i] - minfrice > maxprofit){
				maxprofit = array[i] - minfrice;
			}
		}
		return maxprofit;
	}
	
	//����������ι�Ʊ
	private int allowMany(int[] prices) {
		
		int peak = 0;
		int valley = Integer.MAX_VALUE;
		int count = 0;
		int flag = 0;
		while(flag < prices.length){
			//�����ж�
			while(flag < prices.length && prices[flag] < valley){
				valley = prices[flag];
				peak = prices[flag];
				flag++;
			}
			//�����ж�
			while(flag < prices.length && prices[flag] > peak){
				peak = prices[flag];
				flag++;
			}
			count += (peak - valley);
			//ˢ�²��岨��
			peak = 0;
			valley = Integer.MAX_VALUE;
		}
		return count;
	}
	
	//test
	public static void main(String[] args) {
	
		int[] prices = {1,2,3,4,5,6,7};
		������Ʊ�����ʱ�� h = new ������Ʊ�����ʱ��();
		System.out.println(h.allowMany(prices));
	}
}
