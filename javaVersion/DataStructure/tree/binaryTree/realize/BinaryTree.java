package DataStructure.tree.binaryTree.realize;

import sun.reflect.generics.tree.Tree;

/**
 * @author liujun
 * @date 2020-02-18 16:13
 * @description  二叉树
 */
public interface BinaryTree extends Tree {

    //判断两个二叉树是否相等
    public boolean equal(BinaryTreeImpl source, BinaryTreeImpl target);

    //按行打印二叉树
    public void printTreebyLine(BinaryTreeImpl root);

}
