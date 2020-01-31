package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 *@author liujun
 *@date： 2019-7-8 下午04:57:00
 *@author—Email:liujunfirst@outlook.com
 *@CSDN Blog URL:https://blog.csdn.net/ljfirst/article/details/95072616
 *@description: 设计并实现KMP算法
 *@version 1.0
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
			if(patternPoint == -1 || source.charAt(sourcePoint) == pattern.charAt(patternPoint)){
				sourcePoint++;
				patternPoint++;
			}else{
				patternPoint = next[patternPoint];
			}
		}

		if(patternPoint == pattern.length()){
			return true;
		}
		return false;
	}

	public static int[] getNext(String s) {

		int[] next = new int[s.length()];
		getNext(s, next);
		return next;
	}

	//获取next数组:寻找最长前缀
	public static void getNext(String s, int[] next) {

		int point = 0;
		int pointmatch = -1;
		next[0] = -1;
		int slength = s.length();
		
		while (point < slength - 1) {
			if(pointmatch == -1 || s.charAt(pointmatch) == s.charAt(point)){
				point++;
				pointmatch++;
				next[point] = pointmatch;
			}else{
				pointmatch = next[pointmatch];
			}
		}
	}
	

}