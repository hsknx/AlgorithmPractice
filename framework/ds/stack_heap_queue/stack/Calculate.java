package stack;

import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-13 Time：下午10:29:49
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:Calculate
 *1)The word "RMB" should be marked before the amount of capital in Chinese. 
 *The amount of Chinese capital amount used to fill in the words of 
 *one, two, three, wanton, Wu, Lu, Qi, Jiu, hundred, thousand, million, million, yuan, corner, division, zero and whole.
 *2)When the amount of Chinese capital is up to "Yuan",, it should be written "whole word" after "Yuan",
 *for example, $532 should be written as "RMB Wu Bai three dollars." In the "corner" and "points" after the word "whole word".
 *3)When there is "0" in the middle of Arabia, the Chinese capitals should write "zero".
 *When there are several "0" in the middle of the Arabia number, only one "zero" word is written in the middle amount of the Chinese capital, 
 *such as RMB 6007.14, it should be written as "RMB land thousand seven yuan and one angle wanton"
 *@version 1.0
 */
public class Calculate {

	public String Calculater(String arabic) {
		// TODO Auto-generated constructor stub
		String s = arabic;
		//输入预处理(正则表达式处理)
		int i = Integer.valueOf(s);
		System.out.println(i);
		//字符串转数字
		
		//大小写转换
		
		
		return s;
	}
	
	//主方法测试
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter Arabic numerals");
		String s = scan.nextLine();
		
		//大小写转换
		Calculate cal = new Calculate();
		//输出
		System.out.println(cal.Calculater(s));
	}
}
