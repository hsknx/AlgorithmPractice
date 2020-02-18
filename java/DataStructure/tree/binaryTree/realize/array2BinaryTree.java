package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date  2020-02-18 16:09
 * @description 根据按层/先/中/后序遍历的数组   创建  二叉树
 */
public interface array2BinaryTree {

    //按层构建二叉树
    public BinaryTreeImpl createBinaryTree(int[] array);

    //先序创建二叉树
    public BinaryTreeImpl createPreOrder(BinaryTree root, int[] array);

    //中序创建二叉树
    public BinaryTreeImpl createInOrder(BinaryTree root, int[] array);

    //后序创建二叉树
    public BinaryTreeImpl createPostOrder(BinaryTree root, int[] array);

    default boolean check(int[] array) {

        return array == null ? false : array.length != 0;
    }
}
