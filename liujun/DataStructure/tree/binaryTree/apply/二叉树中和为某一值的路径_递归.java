package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree;
import java.util.ArrayList;

/** 
 *@author liujun
 *@date�� 2018-7-24 ����11:25:27
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��
 *������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 *(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 *����˼·��
 *1�������ǲ������������������˼��
 *2���ȶԸ��ڵ���зǿ��жϣ��ǿս���ȼӽ�������������ʣ�����ɾ����
 *3����������Ҷ�ӽ�㣬�����ۼ�ֵΪtarget��ʱ�򣬽���
 *4�����Һ��ӵݹ飬ɾ�������ʽ�㡣
 *@version 1.0
 */
public class �������к�Ϊĳһֵ��·��_�ݹ�{
	
    //·��list
	ArrayList<Integer> route_list = new ArrayList<Integer>();
	//����·��list��ɵ�all_list
	ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
    
	public ArrayList<ArrayList<Integer>> FindPath(BinaryTree root, int target) {
		//�������ڵ�
		if(root == null){
			//must have return 
			return all_list;
		}
		//�ȼӽ�������������ʣ�����ɾ��
		route_list.add(root.value);
		//why not keep the routelist and target at same time?
		//because target is not a global variable,stack will do it(the stack level retain the valve).
		target -= root.value;
		
		//�ⷨ1����������Ҷ�ӽ�㣬�����ۼ�ֵΪtarget��ʱ�򣬽���
		/*if(target == 0 && root.left == null && root.right == null){
			//all_list�������route_list�����ã����½����ױ��������޸�
			all_list.add(new ArrayList<Integer>(route_list));
		}*/
		
		//�ⷨ2����������ĳ������ֵҪ�����ټ�������ȥ��ֱ�ӷ���
		if (target < 0) {
			return all_list;
		}
		if (target == 0) {
			all_list.add(new ArrayList<Integer>(route_list));
			return all_list;
		}
		//��������
		FindPath(root.left, target);
		//�����Һ���
		FindPath(root.right, target);
		
		//�����ʣ��˴�ɾ��(��Ӧ���һ��Ԫ��)
		route_list.remove(route_list.size() - 1);
		
		return all_list;	
	}
}