package DataStructure.tree.binaryTree.apply;

import DataStructure.string.stringCompare.KMP;
import DataStructure.tree.binaryTree.realize.BinaryTree1;

/**
 *@author liujun
 *@date 2019-7-8 下午03:48:46
 *@author—Email liujunfirst@outlook.com
 *@description 
 *子树匹配优化；1）子树序列化(采用先序+中序)
 *          2）子树字符串匹配
 *@URL
 *@version 1.0
 */
public class TreeJudgeOps {

	public boolean treeJudgeOps(BinaryTree1 tree1, BinaryTree1 tree2) {

		String s1PreOrder = subTreePreOrderSequence(tree1);
		String s2PreOrder = subTreePreOrderSequence(tree2);
		String s1InOrder = subTreeInOrderSequence(tree1);
		String s2InOrder = subTreeInOrderSequence(tree2);
		
		return subTreeKmp(s1PreOrder, s2PreOrder) && subTreeKmp(s1InOrder, s2InOrder);
	}
	
	//子树序列化(先序)
	public String subTreePreOrderSequence(BinaryTree1 tree) {

		if(tree == null){
			return "";
		}
		return tree.value + subTreePreOrderSequence(tree.left) + subTreePreOrderSequence(tree.right);
	}
	
	//子树序列化(中序)
	public String subTreeInOrderSequence(BinaryTree1 tree) {

		if(tree == null){
			return "";
		}
		return subTreeInOrderSequence(tree.left) + tree.value + subTreeInOrderSequence(tree.right);
	}
	
	//子树字符串匹配
	public boolean subTreeKmp(String source, String pattern) {

        KMP kmp = new KMP();
        return kmp.kmp(source, pattern);
    }

	public static void main(String[] args) {
		SubTreeJudge g = new SubTreeJudge();
	}
}
