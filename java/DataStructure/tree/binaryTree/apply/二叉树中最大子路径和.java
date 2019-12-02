package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/** 
 *@author liujun
 *@date： 2018-8-25 下午02:36:07
 *@author—Email:liujunfirst@outlook.com
 *@description:求二叉树中最大子路径和。
 *@version 1.0
 */
public class 二叉树中最大子路径和 {

	int max = 0;
	int maxtemp = 0;
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> listtemp = new ArrayList<Integer>();
	
	//maxValue
	public List<Integer> maxValue(BinaryTree root) {

		if (root == null) {
			return list;
		}
		maxtemp += root.value;
		listtemp.add(root.value);
		
		if (max < maxtemp) {
			max = maxtemp;
			//list = listtemp,赋值是错误的，容易导致list跟随listtemp，而不是副本
			list = new ArrayList<Integer>(listtemp);
		}
		maxValue(root.left);
		maxValue(root.right);
		
		maxtemp -= root.value;
		listtemp.remove(listtemp.size() - 1);
		return list;
	}
	
	//主方法测试
	public static void main(String[] args) {
		//见Tree
	}
}
