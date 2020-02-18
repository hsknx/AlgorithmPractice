package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date： 2020-02-18 16:09
 * 二叉树
 */
public class BinaryTreeImpl implements BinaryTree {

    public BinaryTreeImpl left;    //左孩子
    public BinaryTreeImpl right;   //右孩子
    public int value = 0;          //默认二叉树的值为0
    public static int count = 0;   //定义一个全局静态计数变量

    public BinaryTreeImpl() {
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    public BinaryTreeImpl(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    @Override
    public boolean equal(BinaryTreeImpl source, BinaryTreeImpl target) {

        return source == null ? target == null : simple(source, target);
    }

    public boolean simple(BinaryTreeImpl source, BinaryTreeImpl target) {
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
