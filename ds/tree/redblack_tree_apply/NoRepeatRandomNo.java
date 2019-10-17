package redblack_tree_apply;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tree.RedBlackTree;

/**
 *@author liujun
 *@date： 2018-5-2 Time：下午10:20:41
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机
 *生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，
 *把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
 *按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 *@change: 如果不需要知道具体的重复数据，考虑用红黑树
 *         如果需要知道具体的重复数据，考虑用桶排序
 *@version: 1.0
 *@notice:注意map的三种输出方式。
 */
public class NoRepeatRandomNo {

	//使用红黑树
	private void useMap(int[] array) {
		//红黑树
		/*TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0 ; i < array.length ; i++){
            int curr = array[i];
            set.add(curr);
        }
        //循环输出
        for(Integer i : set){
            System.out.print(i);
        }*/
		
		//自创红黑树
		RedBlackTree rbt = new RedBlackTree();
		rbt = rbt.add(array);
		rbt.print(rbt);
		System.out.println(rbt.containsKey(81));
		System.out.println(rbt.containsKey(8));
	}
	
	//使用桶排序：为防止数据超大，使用map来当做桶。
	public void useBucket(int[] array) {

		Map<Integer, Integer> Bucket = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if(Bucket.containsKey(array[i])){
				Bucket.put(array[i], Bucket.get(array[i])+1);
			}else {
				Bucket.put(array[i],1);
			}
		}
		//map的三种输出方式
		//方式1、
		System.out.println("方式一：");
		System.out.println(Bucket);//默认调用toString
		//方式2、
		System.out.println("方式二：");
		Set<Integer> keys = Bucket.keySet();
		for (Object key : keys) {
			System.out.print(key+"="+Bucket.get(key));
		}
		//方式3、
		System.out.println("方式三：");
		Set<Map.Entry<Integer,Integer>> ms =Bucket.entrySet();
		for (Map.Entry<Integer,Integer> entry : ms) {
			System.out.print(entry.getKey()+"="+entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		int[] num = {8,2,4,6,9,5,7,3,1};
		NoRepeatRandomNo np = new NoRepeatRandomNo();
		np.useMap(num);
		
		int[] num1 = {81,22,43,64,95,56,77,38,19};
		np.useMap(num1);
		//np.useBucket(num);
	}
}
