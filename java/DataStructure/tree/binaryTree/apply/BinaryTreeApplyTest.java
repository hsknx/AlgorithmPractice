package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

import java.util.ArrayList;
import java.util.List;

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
		
		System.out.println("��������ת");
		���������� er = new ����������();
		root = er.Mirro(root);
		
		System.out.println("���б���");
		root.printTreebyLine(root);
		System.out.println("============");
		
		//�������к�Ϊĳһֵ��·��_�ݹ�
		�������к�Ϊĳһֵ��·��_�ݹ� r = new �������к�Ϊĳһֵ��·��_�ݹ�();
		ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
		all_list = r.FindPath(root, 60);
		int i = 0;
		while (i < all_list.size()) {
			ArrayList<Integer> route_list = new ArrayList<Integer>();
			route_list = all_list.get(i);
			for (int j = 0; j < route_list.size(); j++) {
				System.out.print(route_list.get(j) + " ");
			}
			System.out.println();
			i++;
		}
		
		//�������������·����
		�������������·���� he = new �������������·����();
		List<Integer> list = he.maxValue(root);
		int max = 0;
		for (int j = 0; j < list.size(); j++) {
			max += list.get(j);
		}
		System.out.println(max);;
	}
}