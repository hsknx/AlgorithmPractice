package binary_tree_apply;
/** 
 *@author liujun
 *@date： 2018-7-21 上午10:46:09
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:操作给定的二叉树，将其变换为源二叉树的镜像（反转二叉树）。
 *@version 1.0
 */
public class 二叉树镜像 {

	public binary_tree Mirro(binary_tree root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}
		binary_tree temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		Mirro(root.left);
		Mirro(root.right);
		
		return root;
	}
}
