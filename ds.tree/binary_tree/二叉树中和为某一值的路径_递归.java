package binary_tree;

import java.util.ArrayList;
import java.util.Stack;

/** 
 *@author liujun
 *@date： 2018-7-24 下午11:25:27
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输
 *入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *(注意: 在返回值的list中，数组长度大的数组靠前)
 *解题思路：
 *1）首先是采用先序遍历二叉树的思想
 *2）先对根节点进行非空判断（非空结点先加进来，如果不合适，后续删除）
 *3）当遍历到叶子结点，并且累加值为target的时候，结束
 *4）左右孩子递归，删除不合适结点。
 *@version 1.0
 */
public class 二叉树中和为某一值的路径_递归{
	
    //路径list
	ArrayList<Integer> route_list = new ArrayList<Integer>();
	//所有路径list组成的all_list
	ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
    
	public ArrayList<ArrayList<Integer>> FindPath(binary_tree root, int target) {
		//遍历根节点
		if(root == null){
			//must have return 
			return all_list;
		}
		//先加进来，如果不合适，后续删除
		route_list.add(root.value);
		//why not keep the routelist and target at same time?
		//because target is not a global variable,stack will do it(the stack level retain the valve).
		target -= root.value;
		
		//解法1：当遍历到叶子结点，并且累加值为target的时候，结束
		/*if(target == 0 && root.left == null && root.right == null){
			//all_list加入的是route_list的引用，不新建容易被后续的修改
			all_list.add(new ArrayList<Integer>(route_list));
		}*/
		
		//解法2：当遍历到某点满足值要求，则不再继续加下去，直接返回
		if (target < 0) {
			return all_list;
		}
		if (target == 0) {
			all_list.add(new ArrayList<Integer>(route_list));
			return all_list;
		}
		//遍历左孩子
		FindPath(root.left, target);
		//遍历右孩子
		FindPath(root.right, target);
		
		//不合适，此处删除(对应最后一个元素)
		route_list.remove(route_list.size() - 1);
		
		return all_list;	
	}
}

class 二叉树中和为某一值的路径_非递归 {

	public ArrayList<ArrayList<Integer>> FindPath(binary_tree root, int target) {
        //路径list
		ArrayList<Integer> route_list = new ArrayList<Integer>();
		//所有路径list组成的list
		ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
        
		//定义累加值sum匹配target
		int sum = 0;
		//定义二叉树结点
		binary_tree note = root;
		//定义栈
		Stack<binary_tree> stack = new Stack<binary_tree>();
		
		//采用先序非递归遍历来累加匹配
		while(!stack.empty() || note != null){
			while (note != null) {
				if(sum + note.value > target){
					break;
				}
				sum += note.value;
				route_list.add(note.value);
				stack.push(note);
				note = note.left;
			}
			
			if(!stack.empty()){
				note = stack.pop();
				note = note.right;
			}
			
			//寻找匹配值target的路径
			while(note != null && sum < target){
				sum += note.value;
				//放入匹配上的路径结点
				route_list.add(note.value);
			}
			//放入匹配上的路径list
			if(sum == target){
				all_list.add(route_list);
			}
		}
        return all_list;
    }
}
