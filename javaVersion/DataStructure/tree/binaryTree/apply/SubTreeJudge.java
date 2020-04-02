package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

/**
 *@author liujun
 *@date 2018-7-21 上午10:57:09
 *@author—Email liujunfirst@outlook.com
 *@description 输入两棵二叉树A，B，判断B是不是A的子结构。
 *（ps：我们约定空树不是任意一个树的子结构）
 *思路：如果当前结点相同，则通过compare函数进行对比。
 *compare函数对两个树进行相似判断。
 *@version 1.0
 */
public class SubTreeJudge {

	boolean flag = false;
	
	//子树判断
	public boolean judgeTree(BinaryTree1 tree, BinaryTree1 subtree) {

		if(tree == null && subtree == null){
			//此处直接return，否则进入下一个if,产生空指针异常
			return true;
		}
		if(tree == null || subtree == null){
			//此处直接return，否则进入下一个if,产生空指针异常
			return false;
		}
		//如果值相等，进行子树判断。
		if(tree.value == subtree.value && compare(tree, subtree)){
			flag = true;
		}else {
			if(judgeTree(tree.left, subtree) ||
					judgeTree(tree.right, subtree)){
				flag = true;
			}
		}
		return flag;
	}
	
	//二叉树比对，判断二叉树是否完全一致
	public boolean compare(BinaryTree1 tree, BinaryTree1 subtree){
		
		//判断根节点是否相等,方法采用subtree匹配tree，
	    //当subtree为空时，无论tree为何值，均可判断subtree匹配tree。
		if(subtree ==null){
			return true;
		}
		
		//当tree为空，但是subtree不为空，判断subtree不是tree的一部分。
		if(tree == null && subtree !=null){
			return false;
		}
		//当tree和subtree均不为空，且值相等，递归判断相同
		if(tree.value == subtree.value){
			return compare(tree.left, subtree.left)
			&&compare(tree.right, subtree.right);
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		//test
		//A数组
		int [] A = {8,8,9,-1,-1,2,4,7,-1,-1,7,-1,-1,-1,-1};
		//B数组
		int [] B = {8,9,-1,-1,2,-1,-1};
		//int [] B = {9,-1,-1};

		BinaryTree1 bta = new BinaryTree1();
		BinaryTree1 btb = new BinaryTree1();
		
		//A数组先序遍历形成A树
		bta.create_preOrder(bta, A, 0);
		//B数组先序遍历形成B树
		bta.clear();
		btb.create_preOrder(btb, B, 0);
		
		//子树判断
		SubTreeJudge zishu = new SubTreeJudge();
	    System.out.println(zishu.judgeTree(bta,btb));
		
		/*TreeJudgeOps tjo = new TreeJudgeOps();
		System.out.println(tjo.treeJudgeOps(bta, btb));
		*/
	}
}