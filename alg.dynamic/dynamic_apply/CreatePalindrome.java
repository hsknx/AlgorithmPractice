package dynamic_apply;
/** 
 *@author liujun
 *@date： 2018-8-19 上午01:34:47
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *方法一：设置两个指针，头指针指向字符串首部，尾指针指向字符串尾部。若头尾指针相等，
 *     头指针加加，尾指针减减，向中间靠拢，若不相等，则进一步判断（头指针++，尾指针）
 *     和（头指针，尾指针--）中是否存在回文，运用递归完成。
 *方法二：既然可以通过添加构造回文，那么也可以通过删除一个构造回文。
 *方法三：判断原字符串和翻转字符串的最长公共子序列长度是否比原字符串长度小1或相等
 *注意：单独写一个回文判断函数。
 *@version 1.0
 */
public class CreatePalindrome {

	//方法一：首位对比
	public void headAndTail(String test) {
		// TODO Auto-generated method stub
		System.out.println("方法一：首位对比，测试");
		int length = test.length();
		for (int head = 0, tail = length - 1; head < tail; head++, tail--) {
			if(test.charAt(head) != test.charAt(tail)){
				if(PalindromeJudge(test.substring(head, tail)) ||
						PalindromeJudge(test.substring(head + 1, tail+ 1))){
					System.out.println("OK!");
					return;
				}else {
					System.out.println("NO Match!");
					return;
				}
			}
		}
	}
	
	//方法二：删除构造
	public void useDelete(String test) {
		// TODO Auto-generated method stub
		System.out.println("方法二：删除构造，测试");
		
		for (int i = 0; i < test.length(); i++) {
			char[] test_char = test.toCharArray();
			test_char[i] = ' ';
			String test_copy = String.valueOf(test_char).replace(" ", "");
			if(PalindromeJudge(test_copy)){
				System.out.println("OK!");
				return;
			}
		}
		System.out.println("NO Match!");
	}
	
	//方法三：LCS思想
	public void useLCS(String test) {
		// TODO Auto-generated method stub
		System.out.println("方法三：LCS思想，测试");
		//首先获取字符串长度和反转字符串
		int length = test.length();
		String test2 = new StringBuffer(test).reverse().toString();
		//进行LCS匹配
		int[][] matrix = new int[length + 1][length + 1];
		for (int i = 0; i < length; i++) {
			matrix[i][0] = 0;
			matrix[0][i] = 0;
		}
		for (int i = 1; i < length + 1; i++) {
			for (int j = 1; j < length + 1; j++) {
				if(test.charAt(i - 1) == test2.charAt(j - 1)){
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				}else {
					matrix[i][j] = matrix[i - 1][j] > matrix[i][j - 1] ? 
							matrix[i - 1][j] : matrix[i][j - 1];
				}
			}
		}
		//判断匹配书是否等于长度或者长度减一
		if(matrix[length][length] == length || matrix[length][length] == length - 1){
			System.out.println("OK!");
			return;
		}
		System.out.println("NO Match!");
	}
	
	//回文判断
	public boolean PalindromeJudge(String s) {
		// TODO Auto-generated method stub
		boolean flag = new StringBuffer(s).reverse().toString().equals(s);
	    return flag;
	}
	
	//主方法测试
	public static void main(String[] args) {
		String test1 = "asdsqa";
		String test2 = "abcdbca";
		String test3 = "bhuuhbo";
		CreatePalindrome cp = new CreatePalindrome();
		//方法一
		cp.headAndTail(test1);
		cp.headAndTail(test2);
		cp.headAndTail(test3);
		//方法二
		cp.useDelete(test1);
		cp.useDelete(test2);
		cp.useDelete(test3);
		//方法三
		cp.useLCS(test1);
		cp.useLCS(test2);
		cp.useLCS(test3);
	}
}
