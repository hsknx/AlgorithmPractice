package binaryTree.apply;

import binaryTree.realize.BinaryTree;

/**
 *@author liujun
 *@date�� 2018-7-21 ����10:46:09
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:���������Ķ�����������任ΪԴ�������ľ��񣨷�ת����������
 *@version 1.0
 */
public class ���������� {

	public BinaryTree Mirro(BinaryTree root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}
		BinaryTree temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		Mirro(root.left);
		Mirro(root.right);
		
		return root;
	}
}
