package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-04 17:00
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class 二叉树中和为某一值的路径_非递归 {
    public ArrayList<ArrayList<Integer>> FindPath(BinaryTree root, int target) {
        //路径list
        ArrayList<Integer> route_list = new ArrayList<Integer>();
        //所有路径list组成的list
        ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();

        //定义累加值sum匹配target
        int sum = 0;
        //定义二叉树结点
        BinaryTree note = root;
        //定义栈
        Stack<BinaryTree> stack = new Stack<BinaryTree>();

        //采用先序非递归遍历来累加匹配
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

            //寻找匹配值target的路径
            while(note != null && sum < target){
                sum += note.value;
                //放入匹配上的路径结点
                route_list.add(note.value);
            }
            //放入匹配上的路径list
            if(sum == target){
                all_list.add(route_list);
            }
        }
        return all_list;
    }
}