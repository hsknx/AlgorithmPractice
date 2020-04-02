package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 *@author liujun
 *@date 2019-8-26 下午07:32:21
 *@author—Email liujunfirst@outlook.com
 *@CSDN Blog URL:
 *@description  Sunday算法是一种比KMP算法更快捷的算法。
 *@version 1.0
 */
public class Sunday implements StringCompare {
	@Override
	public boolean compare(String source, String target) {
		return check(source, target) ? SundaySolution(source, target) : false;
	}

	//字符串匹配串匹配
	public boolean SundaySolution(String source, String pattern) {
		
		int sourceIndex = 0;
		int patternIndex = 0;

		while(sourceIndex < source.length()){
			int temp = sourceIndex + pattern.length();
			while (sourceIndex < source.length() && patternIndex < pattern.length()) {
				if(source.charAt(sourceIndex) == pattern.charAt(patternIndex)){
					sourceIndex++;
					patternIndex++;
				}else{
					if(temp < source.length() && pattern.lastIndexOf(source.charAt(temp)) != -1){
						//这里指的是右移位数
						sourceIndex = temp - pattern.lastIndexOf(source.charAt(temp));
					}else{
						sourceIndex = temp +1;
					}
					patternIndex = 0;
					break;
				}
			}
			if(patternIndex == pattern.length()){
				return true;
			}
		}
		return false;
	}
}
