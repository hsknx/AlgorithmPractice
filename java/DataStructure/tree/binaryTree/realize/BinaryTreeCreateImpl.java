package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date 2020-02-18 16:42
 * @description 二叉树的实现
 * 根据按层/先/中/后序遍历的数组   创建  二叉树
 */
public class BinaryTreeCreateImpl implements BinaryTreeCreate {
    @Override
    public BinaryTreeImpl createBinaryTree(int[] array) {
        if(!check(array)){
            return null;
        }

        return null;
    }

    @Override
    public BinaryTreeImpl createPreOrder(BinaryTree root, int[] array) {
        return null;
    }

    @Override
    public BinaryTreeImpl createInOrder(BinaryTree root, int[] array) {
        return null;
    }

    @Override
    public BinaryTreeImpl createPostOrder(BinaryTree root, int[] array) {
        return null;
    }



}
