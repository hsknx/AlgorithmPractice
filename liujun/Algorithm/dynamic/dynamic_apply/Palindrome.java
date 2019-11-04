package Algorithm.dynamic.dynamic_apply;

import java.util.Scanner;

/** 
 *@author liujun
 *@date： 2018-8-16 下午11:19:38
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。
 *如何删除才能使得回文串最长呢？输出需要删除的字符个数。
 *@version 1.0
 */
public class Palindrome {

	//构造回文串
	private int buildPalindrome(String s) {
		// TODO Auto-generated method stub
		//接受字符串s1
		String s1 = s;
		StringBuffer sb = new StringBuffer(s1);
		//得到反转字符串s2
		String s2 = sb.reverse().toString();
		//得到数组长度
		int no = s1.length();
		//记录的数组
		int a[][] = new int[no+1][no+1];
		//初始化记录数组
		for(int y = 0; y < no+1; y++) {
			a[0][y] = 0;
			a[y][0] = 0;
		}
		//最长公共子序列匹配
		for(int i = 1; i < no+1; i++){
			for(int j = 1; j < no+1; j++){
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					a[i][j] = a[i-1][j-1] + 1;
				}
				else{
					if(a[i][j-1] > a[i-1][j]){
						a[i][j] = a[i][j-1];
					}else{
						a[i][j] = a[i-1][j];
					}
				}
			}
		}
		//匹配的最大长度
		int match = a[no][no];
		//需要删除掉的长度
		match = no - match;
		return match;
	}
	
	//主方法测试
	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(pal.buildPalindrome(str));
	}
}
