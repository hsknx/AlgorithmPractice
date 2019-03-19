package binary_tree;

import java.util.ArrayList;
import java.util.Stack;

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
    
	public ArrayList<ArrayList<Integer>> FindPath(binary_tree root, int target) {
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

class �������к�Ϊĳһֵ��·��_�ǵݹ� {

	public ArrayList<ArrayList<Integer>> FindPath(binary_tree root, int target) {
        //·��list
		ArrayList<Integer> route_list = new ArrayList<Integer>();
		//����·��list��ɵ�list
		ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();
        
		//�����ۼ�ֵsumƥ��target
		int sum = 0;
		//������������
		binary_tree note = root;
		//����ջ
		Stack<binary_tree> stack = new Stack<binary_tree>();
		
		//��������ǵݹ�������ۼ�ƥ��
		while(!stack.empty() || note != null){
			while (note != null) {
				if(sum + note.value > target){
					break;
				}
				sum += note.value;
				route_list.add(note.value);
				stack.push(note);
				note = note.left;
			}
			
			if(!stack.empty()){
				note = stack.pop();
				note = note.right;
			}
			
			//Ѱ��ƥ��ֵtarget��·��
			while(note != null && sum < target){
				sum += note.value;
				//����ƥ���ϵ�·�����
				route_list.add(note.value);
			}
			//����ƥ���ϵ�·��list
			if(sum == target){
				all_list.add(route_list);
			}
		}
        return all_list;
    }
}
