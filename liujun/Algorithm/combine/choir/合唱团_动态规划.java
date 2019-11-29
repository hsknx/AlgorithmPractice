package Algorithm.combine.choir;

import java.util.Scanner;

/** 
 *@author liujun
 *@date： 2018-6-19 下午11:40:18
 *@author—Email:liujunfirst@outlook.com
 *@description:有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 *要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 *@version 1.0
 */
public class 合唱团_动态规划 {

	//学生人数以及每个学生的能力值
	static int student_num ;
	static long [] student_power ;
	
	//挑选k个学生和设置d个间距
	static int k ,d ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		//学生数量、学生能力值数组
		System.out.println("请输入学生数量:");
		student_num = scan.nextInt();
		System.out.println("请输入每个学生能力值:");
		student_power = new long [student_num];
		
		//能力值赋值
		for (int i = 0; i < student_num; i++) {
			student_power[i] = scan.nextInt();
		}

		//获取k个学生和设置d个间距
		System.out.println("请输入带选取的学生数量k值:");
		k = scan.nextInt();
		System.out.println("请输入间距值d:");
		d = scan.nextInt();
		
		//矩阵赋值
		//二维数组，数组值表示当前最优解的值,行数表示挑选出来的k个学生，列数表示学生人数
		//维护一个正数最大值列表
		long [][] max_matrix = new long[k+1][student_num+1];
		//维护一个负数最小值列表（负数最小值*最小值可以得到最大值）
		long [][] min_matrix = new long[k+1][student_num+1];	
		
		//初始化矩阵——行初始化
		for(int i=0;i<k+1;i++){
			max_matrix[i][0] = 0;
			min_matrix[i][0] = 0;
		}
		//初始化矩阵——列初始化
		for(int j=0;j<student_num+1;j++){
			max_matrix[0][j] = 0;
			min_matrix[0][j] = 0;
		}
		

		
		
	}
}
