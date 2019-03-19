package bucketsort_apply;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/** 
 *@author liujun
 *@date： 2018-7-30 下午05:13:23
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:给定一个英文字符串,
 *请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
 *解题思路：
 *1）map方法：
 *  判断字符是否在map中，在的话加一并且判断是否等于三，等于直接输出
 *  map中没有，则置一。
 *2）桶排序：
 *  设置26*2个桶，对应位加一。
 *注意事项：
 *1）判断是否是空串
 *2）要求是统计字母，非字母需要过滤。
 *@version 1.0
 */
public class Statistic_char {

	//map的做法
	public char statisticChar(String s) {
		// TODO Auto-generated constructor stub
		char [] ch = s.toCharArray();
		Map<Character, Integer> map_char = new HashMap<Character, Integer>();
		String s1 = "[a-zA-Z]+";
		for (int i = 0; i < ch.length; i++) {
			CharSequence cd = s.subSequence(i, i+1);
			//如果此处不用正则，可以使用if(s.charAt(i)-'A'>0 && s.charAt(i)-'z'<0)
			if(Pattern.matches(s1, cd)) {
				if(map_char.containsKey(s.charAt(i))){
					map_char.put(s.charAt(i), map_char.get(s.charAt(i))+1);
					if(map_char.get(s.charAt(i)) == 3){
						return s.charAt(i);
					}
				}else {
					map_char.put(s.charAt(i), 1);
				}
			}
		}
		return ' ';
	}
	//桶排序
	public char Statistic_char_bucket(String s) {
		int [] bucket = new int[58];
		for (int i = 0; i < s.length(); i++) {
			//注意此区间有几个字符不属于字母
			if(s.charAt(i)-'A'>0 && s.charAt(i)-'z'<0){
				bucket[s.charAt(i)-'A']++;
				if(bucket[s.charAt(i)-'A']>3){
					return s.charAt(i);
				}
			}
		}
		return ' ';
	}
	
	//主方法测试  “Have you ever gone shopping and”
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		Statistic_char st = new Statistic_char();
		System.out.println(st.statisticChar(s));
		System.out.println(st.Statistic_char_bucket(s));
	}
}
