package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-04 17:00
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class �������к�Ϊĳһֵ��·��_�ǵݹ� {
    public ArrayList<ArrayList<Integer>> FindPath(BinaryTree root, int target) {
        //·��list
        ArrayList<Integer> route_list = new ArrayList<Integer>();
        //����·��list��ɵ�list
        ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();

        //�����ۼ�ֵsumƥ��target
        int sum = 0;
        //������������
        BinaryTree note = root;
        //����ջ
        Stack<BinaryTree> stack = new Stack<BinaryTree>();

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