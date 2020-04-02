package DataStructure.tree.binaryTree.realize;

import sun.reflect.generics.tree.Tree;

/**
 * @author liujun
 * @date 2020-02-18 18:44
 * @description  二叉树根据按层/先/中/后序遍历的  输出  数组
 */
public interface BinaryTree2Array extends Tree {
    //二叉树按层输出
    public int[] Binary2Array(BinaryTreeImpl root);

    //先序遍历二叉树输出数组
    public int[] Binary2ArrayPreOrder(BinaryTreeImpl root);

    //中序遍历二叉树输出数组
    public int[] Binary2ArrayInOrder(BinaryTreeImpl root);

    //后序遍历二叉树输出数组
    public int[] Binary2ArrayPostOrder(BinaryTreeImpl root);

    default boolean check(int[] array) {
        return array == null ? false : array.length == 0;
    }

}

