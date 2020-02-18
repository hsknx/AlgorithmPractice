package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

/**
 *@author liujun
 *@date�� 2018-7-21 ����10:57:09
 *@author��Email:liujunfirst@outlook.com
 *@description:�������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 *��ps������Լ��������������һ�������ӽṹ��
 *˼·�������ǰ�����ͬ����ͨ��compare�������жԱȡ�
 *compare���������������������жϡ�
 *@version 1.0
 */
public class TreeJudge {

	boolean flag = false;
	
	//�����ж�
	public boolean judgeTree(BinaryTree1 tree1, BinaryTree1 tree2) {
		
		if(tree1 == null || tree2 == null){
			//�˴�ֱ��return�����������һ��if,������ָ���쳣
			return false;
		}
		//���ֵ��ȣ����������жϡ�
		if(tree1.value == tree2.value && compare(tree1, tree2)){
			flag = true;
		}else {
			if(judgeTree(tree1.left, tree2) ||
					judgeTree(tree1.right, tree2)){
				flag = true;
			}
		}
		return flag;
	}
	
	//�������ȶԣ��ж϶������Ƿ���ȫһ��
	public boolean compare(BinaryTree1 tree1, BinaryTree1 tree2){
		
		//�жϸ��ڵ��Ƿ����,��������tree2ƥ��tree1��
	    //��tree2Ϊ��ʱ������tree1Ϊ��ֵ�������ж�tree2ƥ��tree1��
		if(tree2 ==null){
			return true;
		}
		
		//��tree1Ϊ�գ�����tree2��Ϊ�գ��ж�tree2����tree1��һ���֡�
		if(tree1 == null && tree2 !=null){
			return false;
		}
		//��tree1��tree2����Ϊ�գ���ֵ��ȣ��ݹ��ж���ͬ
		if(tree1.value == tree2.value){
			return compare(tree1.left, tree2.left)
			&&compare(tree1.right, tree2.right);
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		//test
		//A����
		int [] A = {8,8,9,-1,-1,2,4,7,-1,-1,7,-1,-1,-1,-1};
		//B����
		int [] B = {8,9,-1,-1,2,-1,-1};
		//int [] B = {9,-1,-1};

		BinaryTree1 bta = new BinaryTree1();
		BinaryTree1 btb = new BinaryTree1();
		
		//A������������γ�A��
		bta.create_preOrder(bta, A, 0);
		//B������������γ�B��
		bta.clear();
		btb.create_preOrder(btb, B, 0);
		
		//�����ж�
		TreeJudge zishu = new TreeJudge();
	    System.out.println(zishu.judgeTree(bta,btb));
		
		/*TreeJudgeOps tjo = new TreeJudgeOps();
		System.out.println(tjo.treeJudgeOps(bta, btb));
		*/
	}
}