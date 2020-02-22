package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @date 2020-02-21 09:08
 * @description 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输
 * *入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * *(注意: 在返回值的list中，数组长度大的数组靠前)
 * *解题思路：
 * *1）首先是采用先序遍历二叉树的思想
 * *2）先对根节点进行非空判断（非空结点先加进来，如果不合适，后续删除）
 * *3）当遍历到叶子结点，并且累加值为target的时候，结束
 * *4）左右孩子递归，删除不合适结点。
 * <p>
 * 注意：如果路径中存在负数，修改代码，遍历到叶子节点。
 */
//二叉树中和为某一值的路径
public class BTFindCertainValuePath {

    //路径list
    ArrayList<Integer> route_list;
    //所有路径list组成的all_list
    ArrayList<ArrayList<Integer>> all_list;

    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeImpl root, int Value) {
        route_list = new ArrayList<Integer>();
        all_list = new ArrayList<ArrayList<Integer>>();
        if (Value <= 0 || root == null) {
            return all_list;
        }
        //排序 ： 在返回值的list中，数组长度大的数组靠前
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

        //解法1：当遍历到叶子结点，并且累加值为target的时候，结束
		/*if(target == 0 && root.left == null && root.right == null){
			//all_list加入的是route_list的引用，不新建容易被后续的修改
			all_list.add(new ArrayList<Integer>(route_list));
		}*/

        //解法2：当遍历到某点满足值要求，则不再继续加下去，直接返回
        if (Value <= 0) {
            //错误写法：all_list.add(route_list);
            if (Value == 0) {
                all_list.add(new ArrayList<Integer>(route_list));
            }
            route_list.remove(route_list.size() - 1);//退出时不保留当前值
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

        //先序遍历左孩子，再遍历右孩子
        while (!stack.empty() || node != null) {

            while (node != null && sum + node.value < Value) {
                sum += node.value;
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {//出栈检查
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
