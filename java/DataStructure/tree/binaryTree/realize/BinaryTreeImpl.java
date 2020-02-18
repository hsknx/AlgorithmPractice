package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date： 2020-02-18 16:09
 * 二叉树
 */
public class BinaryTreeImpl {

    public BinaryTreeImpl left;    //左孩子
    public BinaryTreeImpl right;   //右孩子
    public int value = 0;          //默认二叉树的值为0
    public static int count = 0;   //定义一个全局静态计数变量

    BinaryTreeImpl(){
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    BinaryTreeImpl(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }
}
