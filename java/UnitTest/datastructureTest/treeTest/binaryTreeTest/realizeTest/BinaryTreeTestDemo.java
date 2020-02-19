package UnitTest.datastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

/**
 * @author liujun
 * @date 2020-02-18 19:02
 * @description
 */
public class BinaryTreeTestDemo {

    BinaryTreeImpl binaryTreeImplDemo1 = null;
    BinaryTreeImpl binaryTreeImplDemo2 = null;
    BinaryTreeImpl binaryTreeImplDemo3 = null;
    BinaryTreeImpl binaryTreeImplDemo4 = null;

    int[] treeDemo01 = {};
    int[] treeDemo02 = null;
    int[] treeDemo03 = {
            1,
            2, 3,
            4, 5, 6, 7};
    int[] treeDemo04 = {
            1,
            2, 3,
            4, -1, -1, 7};

    public BinaryTreeImpl gettreeDemo03() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);

        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = binaryTree4;
        binaryTree2.right = binaryTree5;
        binaryTree3.left = binaryTree6;
        binaryTree3.right = binaryTree7;
        return binaryTree1;
    }

    public BinaryTreeImpl gettreeDemo04() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);

        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = binaryTree4;
        binaryTree2.right = null;
        binaryTree3.left = null;
        binaryTree3.right = binaryTree7;
        return binaryTree1;
    }
}
