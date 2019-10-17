package binaryTree.apply;

import binaryTree.realize.BinaryTree;
/**
 *@author liujun
 *@date�� 2019-7-8 ����03:48:46
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *����ƥ���Ż���1���������л�(��������+����)
 *          2�������ַ���ƥ��
 *@URL:
 *@version 1.0
 */
public class TreeJudgeOps {

	/*public boolean treeJudgeOps(BinaryTree tree1, BinaryTree tree2) {

		String s1PreOrder = subTreePreOrderSequence(tree1);
		String s2PreOrder = subTreePreOrderSequence(tree2);
		String s1InOrder = subTreeInOrderSequence(tree1);
		String s2InOrder = subTreeInOrderSequence(tree2);
		
		return subTreeKmp(s1PreOrder, s2PreOrder) && subTreeKmp(s1InOrder, s2InOrder);
	}*/
	
	//�������л�(����)
	public String subTreePreOrderSequence(BinaryTree tree) {

		if(tree == null){
			return "";
		}
		return tree.value + subTreePreOrderSequence(tree.left) + subTreePreOrderSequence(tree.right);
	}
	
	//�������л�(����)
	public String subTreeInOrderSequence(BinaryTree tree) {

		if(tree == null){
			return "";
		}
		return subTreeInOrderSequence(tree.left) + tree.value + subTreeInOrderSequence(tree.right);
	}
	
	//�����ַ���ƥ��
/*	public boolean subTreeKmp(String source, String pattern) {

		KMP kmp = new KMP();
		return kmp.kmp(source, pattern);
	}*/

	public static void main(String[] args) {
		TreeJudge g = new TreeJudge();

	}
}
