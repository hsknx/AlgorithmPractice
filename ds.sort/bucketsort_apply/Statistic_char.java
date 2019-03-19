package bucketsort_apply;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/** 
 *@author liujun
 *@date�� 2018-7-30 ����05:13:23
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ��Ӣ���ַ���,
 *��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ�(��Ҫ���ִ�Сд)��
 *����˼·��
 *1��map������
 *  �ж��ַ��Ƿ���map�У��ڵĻ���һ�����ж��Ƿ������������ֱ�����
 *  map��û�У�����һ��
 *2��Ͱ����
 *  ����26*2��Ͱ����Ӧλ��һ��
 *ע�����
 *1���ж��Ƿ��ǿմ�
 *2��Ҫ����ͳ����ĸ������ĸ��Ҫ���ˡ�
 *@version 1.0
 */
public class Statistic_char {

	//map������
	public char statisticChar(String s) {
		// TODO Auto-generated constructor stub
		char [] ch = s.toCharArray();
		Map<Character, Integer> map_char = new HashMap<Character, Integer>();
		String s1 = "[a-zA-Z]+";
		for (int i = 0; i < ch.length; i++) {
			CharSequence cd = s.subSequence(i, i+1);
			//����˴��������򣬿���ʹ��if(s.charAt(i)-'A'>0 && s.charAt(i)-'z'<0)
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
	//Ͱ����
	public char Statistic_char_bucket(String s) {
		int [] bucket = new int[58];
		for (int i = 0; i < s.length(); i++) {
			//ע��������м����ַ���������ĸ
			if(s.charAt(i)-'A'>0 && s.charAt(i)-'z'<0){
				bucket[s.charAt(i)-'A']++;
				if(bucket[s.charAt(i)-'A']>3){
					return s.charAt(i);
				}
			}
		}
		return ' ';
	}
	
	//����������  ��Have you ever gone shopping and��
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		Statistic_char st = new Statistic_char();
		System.out.println(st.statisticChar(s));
		System.out.println(st.Statistic_char_bucket(s));
	}
}
