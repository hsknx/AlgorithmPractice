package DataStructure.tree.binaryTree.apply;


import DataStructure.tree.binaryTree.realize.BinaryTree1;

/**
 *@author liujun
 *@date�� 2018-7-21 ����10:46:09
 *@author��Email:liujunfirst@outlook.com
 *@description:���������Ķ�����������任ΪԴ�������ľ��񣨷�ת����������
 *@version 1.0
 */
public class ���������� {

	public BinaryTree1 Mirro(BinaryTree1 root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}
		BinaryTree1 temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		Mirro(root.left);
		Mirro(root.right);
		
		return root;
	}
}
