package DataStructure.string.stringApply;

/**
 *@author liujun
 *@date 2018-12-17 下午02:14:33
 *@author—Email liujunfirst@outlook.com
 *@description  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *@URLhttps: //leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 *@version 1.0
 */
//LongestnoRepeatSubstring
//含有重复字符的 最长子串 的长度内存

public class LNRSubstring {

	public int lengthOfLongestSubstring(String s) {
	    
		//用于记录的桶
	    int[] bottle = new int[128];
	    int count = 0;

		for (int begin = 0, j = 0; j < s.length(); j++) {
			//找出子串起始位置
			begin = Math.max(bottle[s.charAt(j)], begin);
			//更新记录值
			count = Math.max(count, j - begin +1);
			//更新桶序号对应的子串起始位置
			bottle[s.charAt(j)] = j + 1;
		}
		return count;
    }
}
