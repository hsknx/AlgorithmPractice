package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

/** 
 *@author liujun
 *@date�� 2018-7-21 ����01:13:08
 *@author��Email:liujunfirst@outlook.com
 *@description:������test
 *@version 1.0
 */
public class BinaryTreeApplyTest {

	public static void main(String[] args) {
		BinaryTree1 root = new BinaryTree1();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//���򹹽�������
		root = root.create_preOrder(root, tree_num, 0);
		System.out.println("��α���");
		root.levelTraverse(root);
		System.out.println();

		
		System.out.println("���б���");
		root.printTreebyLine(root);
		System.out.println("============");


	}
}