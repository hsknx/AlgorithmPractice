package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

/** 
 *@author liujun
 *@date： 2018-7-21 下午01:13:08
 *@author—Email:liujunfirst@outlook.com
 *@description:二叉树test
 *@version 1.0
 */
public class BinaryTreeApplyTest {

	public static void main(String[] args) {
		BinaryTree1 root = new BinaryTree1();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//先序构建二叉树
		root = root.create_preOrder(root, tree_num, 0);
		System.out.println("层次遍历");
		root.levelTraverse(root);
		System.out.println();

		
		System.out.println("按行遍历");
		root.printTreebyLine(root);
		System.out.println("============");


	}
}