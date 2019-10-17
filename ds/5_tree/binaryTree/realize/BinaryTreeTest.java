package binaryTree.realize;

import binaryTree.realize.BinaryTreeTraversal;

/**
 *@author liujun
 *@date： 2018-8-2 下午04:44:26
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class BinaryTreeTest {

	//主方法测试
	public static void main(String[] args) {
		BinaryTreeTraversal root = new BinaryTreeTraversal();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//先序构建二叉树
		root = root.create_preOrder(root, tree_num, 0);
		BinaryTreeTraversal k = root.findxandy(root, 5, 3);
		if (k != null) {
			System.out.println(k.value);
		}else {
			System.out.println("空指针");
		}
		//二叉树先序遍历
		/*System.out.println("二叉树先序遍历");
		root.preTraverse(root);
		System.out.println();
		//二叉树非递归先序遍历
		System.out.println("二叉树非递归先序遍历");
		root.preTraverse_no(root);
		System.out.println();
		//二叉树层次遍历
		System.out.println("二叉树层次遍历");
		root.levelTraverse(root);
		System.out.println();
		//二叉树按行打印
		System.out.println("二叉树按行打印");
		root.printTreebyLine(root);*/
	}
}
