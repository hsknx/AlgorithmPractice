package DataStructure.tree.binaryTree.realize;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @date： 2020-02-18 16:09
 * 二叉树
 */
public class BinaryTreeImpl implements BinaryTree {

    public BinaryTreeImpl left;    //左孩子
    public BinaryTreeImpl right;   //右孩子
    public BinaryTreeImpl parent;  //父指针
    public int value = 0;          //默认二叉树的值为0
    public static int count = 0;   //定义一个全局静态计数变量

    public BinaryTreeImpl() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = 0;
    }

    public BinaryTreeImpl(int value) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = value;
    }

    //判断两个二叉树是否相等
    @Override
    public boolean equal(BinaryTreeImpl source, BinaryTreeImpl target) {

        return source == null ? target == null : same(source, target);
    }

    //按行打印二叉树
    @Override
    public void printTreebyLine(BinaryTreeImpl root) {

        if (root==null) {
            return;
        }
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTreeImpl head;
        BinaryTreeImpl tail;
        head = tail = root;
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.value + " ");
            if (root.left != null) {
                tail = root.left;
                queue.offer(root.left);
            }
            if (root.right != null) {
                tail = root.right;
                queue.offer(root.right);
            }
            if (root == head) {
                System.out.println();
                head = tail;
            }
        }
    }

    public boolean same(BinaryTreeImpl source, BinaryTreeImpl target) {
        if (target == null) {
            return false;
        }
        if (source.value != target.value) {
            return false;
        } else {
            return equal(source.left, target.left) && equal(source.right, target.right);
        }
    }
}
