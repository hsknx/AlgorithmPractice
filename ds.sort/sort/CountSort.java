package sort;
/** 
 *@author liujun
 *@date： 2019-3-23 下午12:10:15
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:1、统计原始数组的频率(用最小值优化)
 *2、输出统计后的数组。
 *@URL:
 *@version 1.0
 */
public class CountSort {

	public  int[] countsort(int[] array) {
		//1、找出原始数组的最大最小值
		int max = array[0];
		int min = array[0];
		
		for(int i: array){
			if(max < i){
				max = i;
			}
			if(min > i){
				min = i;
			}
		}
		//2、定义新的数组大小  min到max之间，闭区间，有（max-min+1）个数字
		int[] newarray = new int[max - min + 1];
		
		//3、一次循环统计数据——优化掉最小值之前的无用存储
		for (int i = 0; i < array.length; i++) {
			newarray[array[i]-min]++;
		}
		//4、输出数据
		/*for (int i = 0; i < newarray.length; i++) {
			while(newarray[i] != 0){
				System.out.print(i+min+" ");
				newarray[i]--;
			}
		}*/
		//4、返回新数组
		int[] b = new int[array.length];
		
		//优化前方案——两次循环，需判空,浪费循环次数
		/*int count = 0;
		for (int i = 0; i < newarray.length; i++) {
			while(newarray[i] != 0){
				b[count++] = i + min;
				newarray[i]--;
			}
		}*/
		
		/*优化后方案:1、找出对应位有多少累加的统计数据；
		          2、根据累积数据填充b数组。
		 *注意事项:1、i必须到0，否则array[0]无法遍历到
		         2、b数组，必须先--，考虑到newarray中最小的统计位存的是1，
		                             对应b数组的最小值(即0位)，所以必须先--*/
		for (int i = 1; i < newarray.length; i++) {
			newarray[i] += newarray[i-1];
		}
		
		for (int i = array.length-1; i >= 0; i--) {
			b[--newarray[array[i]-min]] = array[i];
		}
		return b;
	}
}
