package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTree1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-04 17:00
 * @author—Email liujunfirst@outlook.com
 * @description 
 */
public class 二叉树中和为某一值的路径_非递归 {

    static class Staff {
        private String name;
        private int age;
        private BigDecimal salary;
        Staff(String s, int i, BigDecimal b){
            this.name=s;
            this.age=i;
            this.salary=b;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Java 8
        List<Integer> collect = staff.stream().map(x -> x.getAge()).collect(Collectors.toList());
        System.out.println(collect); //[mkyong, jack, lawrence]
    }


    public ArrayList<ArrayList<Integer>> FindPath(BinaryTree1 root, int target) {
        //路径list
        ArrayList<Integer> route_list = new ArrayList<Integer>();
        //所有路径list组成的list
        ArrayList<ArrayList<Integer>> all_list = new ArrayList<ArrayList<Integer>>();

        //定义累加值sum匹配target
        int sum = 0;
        //定义二叉树结点
        BinaryTree1 note = root;
        //定义栈
        Stack<BinaryTree1> stack = new Stack<BinaryTree1>();

        //采用先序非递归遍历来累加匹配
        while (!stack.empty() || note != null) {
            while (note != null) {
                if (sum + note.value > target) {
                    break;
                }
                sum += note.value;
                route_list.add(note.value);
                stack.push(note);
                note = note.left;
            }

            if (!stack.empty()) {
                note = stack.pop();
                note = note.right;
            }

            //寻找匹配值target的路径
            while (note != null && sum < target) {
                sum += note.value;
                //放入匹配上的路径结点
                route_list.add(note.value);
            }
            //放入匹配上的路径list
            if (sum == target) {
//                ArrayList<Integer> route_list_ = new ArrayList<Integer>(stack);
//                all_list.add(route_list_);
                ArrayList<Integer> route_list_ = (ArrayList<Integer>) stack.stream().map(x->x.value).collect(Collectors.toList());
                }
        }
        return all_list;
    }
}