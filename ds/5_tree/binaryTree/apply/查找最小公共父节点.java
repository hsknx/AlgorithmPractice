package binaryTree.apply;

import binaryTree.realize.BinaryTreeTraversal;

/**
 *@author liujun
 *@date： 2019-3-23 下午02:54:10
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@URL:
 *@version 1.0
 */
public class 查找最小公共父节点 {

	//查找二叉树中x和y的最小公共父节点
	public BinaryTreeTraversal findxandy(BinaryTreeTraversal root, int x, int y) {
		// TODO Auto-generated method stub

		if (findx(root.left, x) && findx(root.left, y)) {
			return findxandy(root.left, x, y);
			
		}else if (findx(root.right, x) && findx(root.right, y)) {
			return findxandy(root.right, x, y);
			
		}else if (findx(root.left, x) && findx(root.right, y) 
				|| findx(root.right, x) && findx(root.left, y)) {
			return root;
			
		}else {
			return null;
		}
	}
	
	//查找二叉树中是否含有x
	public boolean findx(BinaryTreeTraversal root, int x) {

		if (null == root) {
			return false;
		}
		if (root.value == x) {
			return true;
		}
		return findx(root.left, x)||findx(root.right, x);
	}
}
