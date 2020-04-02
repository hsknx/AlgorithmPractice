package DataStructure.tree.binaryTree.realize;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-10-18 01:38
 * @author—Email liujunfirst@outlook.com
 * @description 
 */
//二叉树的数据结构
public class BinaryTree1 {

    public BinaryTree1 left;   //左孩子
    public BinaryTree1 right;  //右孩子
    public int value = 0;      //默认二叉树的值为0
    public static int count = 0;//定义一个全局静态计数变量

    public BinaryTree1(int value) {
        // TODO Auto-generated constructor stub
        this.value = value;
    }

    public BinaryTree1() {
        // TODO Auto-generated constructor stub
    }

    //二叉树的三种遍历赋值
    //将数组先序遍历赋值二叉树,约定-1是空指针
    public BinaryTree1 create_preOrder(BinaryTree1 root, int [] tree_num , int i){

        if(i < tree_num.length){
            if(tree_num[i] == -1){
                return null;
            }else{
                //new root's lchild and rchild
                BinaryTree1 lchild = new BinaryTree1();
                BinaryTree1 rchild = new BinaryTree1();
                //preOrder
                root.value = tree_num[i];
                //不用++count，构造的时候或出错
                root.left = create_preOrder(lchild, tree_num, ++count);
                root.right = create_preOrder(rchild, tree_num, ++count);
            }
        }

        return root;
    }

    //将数组中序遍历赋值二叉树
    public BinaryTree1 create_inOrder(BinaryTree1 root){

        return root;
    }

    //将数组后序遍历赋值二叉树
    public BinaryTree1 create_postOrder(BinaryTree1 root){

        return root;
    }

    //清零操作
    public void clear(){
        count = 0;
    }
    //二叉树的层次遍历,使用栈来辅助实现
    public void levelTraverse(BinaryTree1 root){

        // Queue is just an interface, LinkedList is Realization
        Queue<BinaryTree1> queue = new LinkedList<BinaryTree1>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTree1 note = queue.poll();
            System.out.print(note.value + " ");
            if(note.left != null){
                levelTraverse(note.left);
            }
            if(note.right != null){
                levelTraverse(note.right);
            }
        }
    }

    // 二叉树的按行打印
    public void printTreebyLine(BinaryTree1 root) {
        if(root == null){
            return;
        }
        //设置换行的标志指针：pre,next
        BinaryTree1 pre = null;
        BinaryTree1 next = null;
        //树进队列
        Queue<BinaryTree1> queue = new LinkedList<BinaryTree1>();
        queue.offer(root);
        next = pre = root;
        //指针移动操作
        while (!queue.isEmpty()) {
            BinaryTree1 note = queue.poll();
            System.out.print(note.value + " ");
            if(note.left != null){
                pre = note.left;
                queue.add(note.left);
            }
            if(note.right != null){
                pre = note.right;
                queue.add(note.right);
            }
            //换行
            if (note.value == next.value) {
                next = pre;
                System.out.println();
            }
        }
    }
}
