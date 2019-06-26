package sort_apply;

import java.util.Arrays;
import java.util.Scanner;

/** 
 *@author liujun
 *@date： 2018-9-5 下午08:35:45
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:将一段压缩后的字符串解压缩，并且排序输出。
 *解压：字符串后续跟着的数字表示该字符串需要重复几次。
 *排序：若相同的数字，如“c2a2”,按照ASCII编码排序，应输出“aacc”
 *@version 1.0
 */
public class Compress {

	public String decompression(String s) {

		//匹配表达式，alpha是所有分割出来的字母，number是所有分割出来的数字
		String[] alpha = s.split("[0-9]+");
		String[] number = s.split("[a-zA-Z]+");
		//num是为了后续排序，numreally是排序不影响跟alpha一对一
		int[] num = new int[number.length];
		int[] numreally  = new int[number.length];
		int flag = 0;
		//string转int
		for (int i = 0; i < number.length; i++) {
			if (number[i].matches("[0-9]+")) {
				num[flag] = Integer.parseInt(number[i]);
				numreally[flag] = Integer.parseInt(number[i]);
				flag++;
			}
		}
		//排序，从小到大
		Arrays.sort(num);
		StringBuffer sb = new StringBuffer();
		//选择排序，按照字母顺序排列相同数量的字母
		for (int i = 0; i < numreally.length - 1; i++) {
			for (int j = i; j < numreally.length; j++) {
				if (numreally[j] == numreally[i]) {
					if (alpha[i].hashCode() > alpha[j].hashCode()) {
						String sd = alpha[i];
						alpha[i] =  alpha[j];
						alpha[j] = sd;
					}
				}
			}
		}
		//生成字符串
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < numreally.length; j++) {
				if (numreally[j] == num[i]) {
					numreally[j] = -1;
					for (int j2 = 0; j2 < num[i]; j2++) {
						sb.append(alpha[j]);
					}
				}
			}
		}
		return sb.toString();
	}
	
	//主方法测试
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().trim();
		//打印
		System.out.println(new Compress().decompression(s));
	}
	
}
