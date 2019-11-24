package DataStructure.sort.innerSort.innerSortApply;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/** 
 *@author liujun
 *@date�� 2018-7-30 ����05:13:23
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: ����һ��Ӣ���ַ���,
 *��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ�(��Ҫ���ִ�Сд)��
 *����˼·��
 *1��map������
 *  �ж��ַ��Ƿ���map�У��ڵĻ���һ�����ж��Ƿ������������ֱ�����
 *  map��û�У�����һ��
 *2��Ͱ��������
 *  ����26*2��Ͱ����Ӧλ��һ��
 *ע�����
 *1���ж��Ƿ��ǿմ�
 *2��Ҫ����ͳ����ĸ������ĸ��Ҫ���ˡ�
 *@version 1.0
 */
//ͳ���״γ��ֵ�������ĸ
public class StatisticFirstThreeChar {

	//map������
	public char statisticCharbyMap(String s) {
		if(s == null || s.length() == 0){
			return ' ';
		}
		char [] ch = s.toCharArray();
		Map<Character, Integer> map_char = new HashMap<Character, Integer>();
		String s1 = "[a-zA-Z]+";
		for (int i = 0; i < ch.length; i++) {
			CharSequence cd = s.subSequence(i, i+1);
			//����˴��������򣬿���ʹ��if(c1-'A'>0 && c1-'z'<0)
			if(Pattern.matches(s1, cd)) {
				char c1 = s.charAt(i);
				if(map_char.containsKey(c1)){
					map_char.put(c1, map_char.get(c1)+1);
					if(map_char.get(c1) == 3){
						return c1;
					}
				}else {
					map_char.put(c1, 1);
				}
			}
		}
		return ' ';
	}

	//Ͱ��������
	public char statisticCharbyBucket(String s) {
		if(s == null || s.length() == 0){
			return ' ';
		}
		int [] bucket = new int[58];
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			//ע��������м����ַ���������ĸ
			if((c1-'A'>=0 && c1-'Z'<=0) || (c1-'a'>=0 && c1-'z'<=0)){
				bucket[c1-'A']++;
				if(bucket[c1-'A'] == 3){
					return c1;
				}
			}
		}
		return ' ';
	}
	

}
