package DataStructure.tree.binaryTree.realize;

import sun.reflect.generics.tree.Tree;

/**
 * @author liujun
 * @date  2020-02-18 16:09
 * @description  ���ݰ���/��/��/�������������   ����  ������
 */
public interface Array2BinaryTree extends Tree {

    //���㹹��������
    public BinaryTreeImpl createBinaryTree(int[] array);

    //���򴴽�������
    public BinaryTreeImpl createPreOrder(BinaryTree root, int[] array);

    //���򴴽�������
    public BinaryTreeImpl createInOrder(BinaryTree root, int[] array);

    //���򴴽�������
    public BinaryTreeImpl createPostOrder(BinaryTree root, int[] array);

    default boolean check(int[] array) {

        return array == null ? false : array.length != 0;
    }
}