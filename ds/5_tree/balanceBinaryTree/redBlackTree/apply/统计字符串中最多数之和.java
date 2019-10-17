package balanceBinaryTree.redBlackTree.apply;

import java.util.HashMap;
import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-4-24 Time：上午12:01:35
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:写段代码，定义一个字符串常量，字符串中只有大小写字母和整数，输出字符串中的出现
 *最多的数字的和？例如 ” 9fil3dj11P0jAsf11j ” 中出现最多的是11两次，输出22.
 *@version 1.0
 */
public class 统计字符串中最多数之和 {

	/*需掌握：
	 * 1.三种正则表达式
	 * 2.字符串常量的比较方法
	 * 3.hashmap用法
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer>  count_map = new HashMap<String, Integer>();
		int num = 0;
		int max = 0;
		
		while (scan.hasNext()) {
			String s = scan.next();
			//三种正则表达式
			//String[] s1 = s.split("[\\D]{1,}");
			//String[] s1 = s.split("[^0-9]");
			String[] s1 = s.split("[a-zA-Z]");
			for (String string : s1) {
				//注意不可用 ==
				if(!(string.equals(" ")||string.equals(""))){
					if(count_map.containsKey(string)){
						//此处会更新map
						count_map.put(string, count_map.get(string)+1);
						//保存最大最小值
						if (num<count_map.get(string)) {
							num = count_map.get(string);
							max = Integer.parseInt(string);
						}
					}else{
						count_map.put(string, 1);
					}
				}
			}
			System.out.println(max*num);
		}
	}
}
