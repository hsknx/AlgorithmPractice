package DataStructure.tree;

/**
 * @author liujun
 * @date： 2020-02-18 16:09
 */
public interface BinaryTreeCreate {

    /*
     * 1、根据按层/先/中/后序遍历的数组   创建  二叉树
     * 2、二叉树根据按层/先/中/后序遍历的  输出  数组
     * */
    //按层构建二叉树
    public BinaryTree createBinaryTree(BinaryTree root, int[] array);

    //先序创建二叉树
    public BinaryTree createPreOrder(BinaryTree root, int[] array);

    //中序创建二叉树
    public BinaryTree createInOrder(BinaryTree root, int[] array);

    //后序创建二叉树
    public BinaryTree createPostOrder(BinaryTree root, int[] array);

    //二叉树按层输出
    public int[] Binary2Array(BinaryTree root);

    //先序遍历二叉树输出数组
    public int[] Binary2ArrayPreOrder(BinaryTree root);

    //中序遍历二叉树输出数组
    public int[] Binary2ArrayInOrder(BinaryTree root);

    //后序遍历二叉树输出数组
    public int[] Binary2ArrayPostOrder(BinaryTree root);
}
