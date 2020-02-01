package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-7-8 下午04:57:00
 * @author—Email:liujunfirst@outlook.com
 * @CSDN Blog URL:https://blog.csdn.net/ljfirst/article/details/95072616
 * @description: 设计并实现KMP算法
 */
public class KMP implements StringCompare {
    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? kmp(source, target) : false;
    }

    //kmp 匹配过程
    public boolean kmp(String source, String pattern) {

        //源串指针和目的串指针
        int sourcePoint = 0;
        int patternPoint = 0;
        int[] next = getNext(pattern);

        while (sourcePoint < source.length() && patternPoint < pattern.length()) {
            if (patternPoint == -1 || source.charAt(sourcePoint) == pattern.charAt(patternPoint)) {
                sourcePoint++;
                patternPoint++;
            } else {
                patternPoint = next[patternPoint];
            }
        }

        if (patternPoint == pattern.length()) {
            return true;
        }
        return false;
    }

	//获取next数组:寻找最长前缀
    public int[] getNext(String s) {

        int[] next = new int[s.length()];
		int point = 0;
		int prefix = -1;
		next[0] = -1;

		while (point < s.length() - 1) {//因为求解最后一位的匹配值，所有此处是 <
			if (prefix == -1 || s.charAt(prefix) == s.charAt(point)) {
				point++;
				prefix++;
				next[point] = prefix;
			} else {
				prefix = next[prefix];
			}
		}
        return next;
    }

}