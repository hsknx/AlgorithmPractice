package Logic.logic;

/** 
 *@author liujun
 *@date 2018-12-17 ����05:30:46
 *@author��Email liujunfirst@outlook.com
 *@description  ������Ʊ�����ʱ��
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ����
 *���һ���㷨�����������ܻ�ȡ���������ע���㲻���������Ʊǰ������Ʊ��
 *@URLhttps://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 *@version 1.0
 */
//������Ʊ�����ʱ��
public class SaleStocks {

	//ֻ��������һ�ι�Ʊ
	public int justAllowOnce(int[] prices) {

	    if(prices == null || prices.length == 0){
	        return -1;
        }
		int maxprofit = 0;
		int minfrice = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if(minfrice > prices[i]){
				minfrice = prices[i];
			}else if(prices[i] - minfrice > maxprofit){
				maxprofit = prices[i] - minfrice;
			}
		}
		return maxprofit;
	}
	
	//����������ι�Ʊ
	public int allowMany(int[] prices) {
        if(prices == null || prices.length == 0){
            return -1;
        }
		int peak = 0;
		int valley = prices[0];
		int count = 0;
		int flag = 0;
		while(flag < prices.length){
			//�����ж�
			while(flag < prices.length && prices[flag] < valley){
				valley = prices[flag];
				peak = prices[flag];//ˢ�²���
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
			//Ϊ�˷�ֹԽ�磬�˴����������ֵ��ʾ
			valley = Integer.MAX_VALUE;
		}
		return count;
	}
}