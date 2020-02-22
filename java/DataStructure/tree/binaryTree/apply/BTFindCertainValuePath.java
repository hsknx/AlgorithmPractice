package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @date 2020-02-21 09:08
 * @description ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��
 * *������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * *(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * *����˼·��
 * *1�������ǲ������������������˼��
 * *2���ȶԸ��ڵ���зǿ��жϣ��ǿս���ȼӽ�������������ʣ�����ɾ����
 * *3����������Ҷ�ӽ�㣬�����ۼ�ֵΪtarget��ʱ�򣬽���
 * *4�����Һ��ӵݹ飬ɾ�������ʽ�㡣
 * <p>
 * ע�⣺���·���д��ڸ������޸Ĵ��룬������Ҷ�ӽڵ㡣
 */
//�������к�Ϊĳһֵ��·��
public class BTFindCertainValuePath {

    //·��list
    ArrayList<Integer> route_list;
    //����·��list��ɵ�all_list
    ArrayList<ArrayList<Integer>> all_list;

    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeImpl root, int Value) {
        route_list = new ArrayList<Integer>();
        all_list = new ArrayList<ArrayList<Integer>>();
        if (Value <= 0 || root == null) {
            return all_list;
        }
        //���� �� �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ
        all_list = FindPathComponent(root, Value);
        sort();
        return all_list;
    }

    public void sort() {
        if (all_list.size() >= 2) {
            /*Collections.sort(all_list, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int diff = o1.size() - o2.size();
                    if (diff == 0) {
                        return 0;
                    }
                    return diff > 0 ? 1 : -1;
                }
            });*/

            all_list= (ArrayList<ArrayList<Integer>>) all_list.stream().sorted(Comparator.comparing(ArrayList::size)).collect(Collectors.toList());
        }
    }

    private ArrayList<ArrayList<Integer>> FindPathComponent(BinaryTreeImpl root, int Value) {
        if (root == null) {
            return all_list;
        }
        route_list.add((Integer) root.value);
        //why not keep the routelist and Value at same time?
        //because Value is not a global variable,stack will do it(the stack level retain the valve).
        Value -= root.value;

        //�ⷨ1����������Ҷ�ӽ�㣬�����ۼ�ֵΪtarget��ʱ�򣬽���
		/*if(target == 0 && root.left == null && root.right == null){
			//all_list�������route_list�����ã����½����ױ��������޸�
			all_list.add(new ArrayList<Integer>(route_list));
		}*/

        //�ⷨ2����������ĳ������ֵҪ�����ټ�������ȥ��ֱ�ӷ���
        if (Value <= 0) {
            //����д����all_list.add(route_list);
            if (Value == 0) {
                all_list.add(new ArrayList<Integer>(route_list));
            }
            route_list.remove(route_list.size() - 1);//�˳�ʱ��������ǰֵ
            return all_list;
        }

        FindPathComponent(root.left, Value);
        FindPathComponent(root.right, Value);

        route_list.remove(route_list.size() - 1);
        return all_list;
    }

    public ArrayList<ArrayList<Integer>> FindPathStack(BinaryTreeImpl root, int Value) {

        route_list = new ArrayList<Integer>();
        all_list = new ArrayList<ArrayList<Integer>>();
        if (Value <= 0 || root == null) {
            return all_list;
        }
        Stack<BinaryTreeImpl> stack = new Stack<>();
        int sum = 0;
        BinaryTreeImpl node = root;

        //����������ӣ��ٱ����Һ���
        while (!stack.empty() || node != null) {

            while (node != null && sum + node.value < Value) {
                sum += node.value;
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {//��ջ���
                if(node != null && sum + node.value == Value){
                    stack.push(node);
                    route_list = (ArrayList<Integer>) stack.stream().map(x -> x.value).collect(Collectors.toList());
                    all_list.add(route_list);
                    stack.pop();
                }
                node = stack.peek();
                node = node.right;
            }
            if (node != null && sum + node.value == Value) {
                stack.push(node);
                route_list = (ArrayList<Integer>) stack.stream().map(x -> x.value).collect(Collectors.toList());
                all_list.add(route_list);
                stack.pop();
            }


        }
        return all_list;
    }
}
