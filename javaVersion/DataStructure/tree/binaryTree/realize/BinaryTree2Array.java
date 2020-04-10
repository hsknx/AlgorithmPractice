package DataStructure.tree.binaryTree.realize;

import sun.reflect.generics.tree.Tree;

/**
 * @author liujun
 * @date 2020-02-18 18:44
 * @description  ���������ݰ���/��/��/���������  ���  ����
 */
public interface BinaryTree2Array extends Tree {
    //�������������
    public int[] Binary2Array(BinaryTreeImpl root);

    //��������������������
    public int[] Binary2ArrayPreOrder(BinaryTreeImpl root);

    //��������������������
    public int[] Binary2ArrayInOrder(BinaryTreeImpl root);

    //��������������������
    public int[] Binary2ArrayPostOrder(BinaryTreeImpl root);

    default boolean check(int[] array) {
        return array == null ? false : array.length == 0;
    }

}

