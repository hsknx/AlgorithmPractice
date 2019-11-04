package Algorithm.dynamic.dynamic_apply;

import java.util.Scanner;

/** 
 *@author liujun
 *@date： 2018-8-2 下午01:36:15
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，
 *请问派送员需要选择什么的路线，才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)，
 *派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 *随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 *@version 1.0
 *解题思路：
 *1)prim思路:每次都最短的路径，用这个点再更新距离表，再根据距离表求最短路径，直道所有点遍历结束。
 *2)贪心算法：
 *3)动态规划：
 *4)分支限界：
 */
public class 送货最短路径 {

	//计算最短距离：prim思路
	public int shortPath_greedy(int [] position_row, int [] position_column) {
		// TODO Auto-generated method stub

		//定义总距离和最小值
		int sum = 0;
		int min = Integer.MAX_VALUE;
		//定义最短距离的数组
		int [] short_route_value = new int [position_row.length];
		for (int i = 0; i < short_route_value.length; i++) {
			short_route_value[i] = Integer.MAX_VALUE;
		}
		//p结点代表每次新加入的结点，是数组下标
		int p = 0;
		//第一个点作为起点，置为-1，表示已遍历过。
		short_route_value[0] = -1;
		for (int i = 1; i < position_column.length; i++) {
			//每次加入的新结点p,用来更新最短距离的数组。
			short_route_value = update(p, short_route_value, position_row, position_column);
			
			//遍历数组找出当前最小值的点
			for (int j = 0; j < short_route_value.length; j++) {
				if(short_route_value[j] != -1 && min > short_route_value[j]){
					min = short_route_value[j];
					p = j;
				}
			}
			//将最小值与sum相加,并刷新最小值,设置当前最小值点已访问
			sum += min;
			min = Integer.MAX_VALUE;
			short_route_value[p] = -1;
		}
		
		//最后加上返回值：从最后那个点回到起点
		sum = sum + position_row[p] + position_column[p];
		return sum;
	}
	
	//最短距离数组的更新函数
	private int [] update(int p, int [] short_route_value, int [] position_row, int [] position_column) {

		//定义距离
		int row_value = 0;
		int column_value = 0;
		//int count = 0;
		for (int i = 0; i < position_column.length; i++) {
			//更新所有未访问结点距离
			if(short_route_value[i] != -1){
				//求绝对值,此处有两种不同写法
				column_value = Math.abs(position_column[p] - position_column[i]);
				row_value = position_row[p] - position_row[i] > 0 ? position_row[p] - position_row[i] : position_row[i] - position_row[p];
				//count = column_value + row_value;
				//short_route_value[i] = count < short_route_value[i] ? count : short_route_value[i];
				short_route_value[i] = column_value + row_value;
			}
		}
		return short_route_value;
	}
	
	//动态规划
	public void shortPath_dynamic() {
		// TODO Auto-generated method stub

	}
	
	//主方法测试
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("输入坐标点数");
		int local_num = Integer.parseInt(scan.nextLine());
		
		//初始化行列坐标
		int [] position_row = new int[local_num+1];
		int [] position_column = new int[local_num+1];
		//起点都是0,0
		position_row[0] = 0;
		position_column[0] = 0;
		
		System.out.println("依次输入坐标的横纵坐标，逗号隔开，回车换行：");
		for (int j = 1; j < local_num + 1; j++) {
			String[] locations = scan.nextLine().trim().split(",");
			position_row[j] = Integer.parseInt(locations[0]);
			position_column[j] = Integer.parseInt(locations[1]);
		}
		
		//计算最短路程
		送货最短路径 route = new 送货最短路径();
		int sum = route.shortPath_greedy(position_row, position_column);
		System.out.println(sum);
	}
}