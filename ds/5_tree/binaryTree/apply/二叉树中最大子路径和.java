package binaryTree.apply;

import binaryTree.realize.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/** 
 *@author liujun
 *@date�� 2018-8-25 ����02:36:07
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��������������·���͡�
 *@version 1.0
 */
public class �������������·���� {

	int max = 0;
	int maxtemp = 0;
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> listtemp = new ArrayList<Integer>();
	
	//maxValue
	public List<Integer> maxValue(BinaryTree root) {

		if (root == null) {
			return list;
		}
		maxtemp += root.value;
		listtemp.add(root.value);
		
		if (max < maxtemp) {
			max = maxtemp;
			//list = listtemp,��ֵ�Ǵ���ģ����׵���list����listtemp�������Ǹ���
			list = new ArrayList<Integer>(listtemp);
		}
		maxValue(root.left);
		maxValue(root.right);
		
		maxtemp -= root.value;
		listtemp.remove(listtemp.size() - 1);
		return list;
	}
	
	//����������
	public static void main(String[] args) {
		//��Tree
	}
}
