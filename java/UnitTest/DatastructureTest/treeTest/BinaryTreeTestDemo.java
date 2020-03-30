package UnitTest.DatastructureTest.treeTest;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

/**
 * @author liujun
 * @date 2020-02-18 19:02
 * @description
 */
public class BinaryTreeTestDemo {

    public BinaryTreeImpl binaryTreeImplDemo1 = null;
    public BinaryTreeImpl binaryTreeImplDemo2 = null;
    public BinaryTreeImpl binaryTreeImplDemo3 = null;
    public BinaryTreeImpl binaryTreeImplDemo4 = null;

    public int[] treeDemo01 = {};
    public int[] treeDemo02 = null;
    public int[] treeDemo03 = {
            1,
            2, 3,
            4, 5, 6, 7};
    public int[] treeDemo04 = {
            1,
            2, 3,
            4, -1, -1, 7};

    public int[] treeDemo05 = {
            1,
            2, 3,
            4, 6, 7, 8,
            9, -1, -1, -1, 10, 11, 12, -1,
            13, -1, 15, 16, -1, -1, 5, -1,
            14, -1, -1, -1, 17, -1, -1, 20,
            -1, -1, -1, 18, -1, -1,
            19, -1,
            -1, -1
    };

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
        binaryTree3.right = binaryTree7;
        return binaryTree1;
    }

    public BinaryTreeImpl gettreeDemo05() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);
        BinaryTreeImpl binaryTree8 = new BinaryTreeImpl(8);
        BinaryTreeImpl binaryTree9 = new BinaryTreeImpl(9);
        BinaryTreeImpl binaryTree10 = new BinaryTreeImpl(10);
        BinaryTreeImpl binaryTree11 = new BinaryTreeImpl(11);
        BinaryTreeImpl binaryTree12 = new BinaryTreeImpl(12);
        BinaryTreeImpl binaryTree13 = new BinaryTreeImpl(13);
        BinaryTreeImpl binaryTree14 = new BinaryTreeImpl(14);
        BinaryTreeImpl binaryTree15 = new BinaryTreeImpl(15);
        BinaryTreeImpl binaryTree16 = new BinaryTreeImpl(16);
        BinaryTreeImpl binaryTree17 = new BinaryTreeImpl(17);
        BinaryTreeImpl binaryTree18 = new BinaryTreeImpl(18);
        BinaryTreeImpl binaryTree19 = new BinaryTreeImpl(19);
        BinaryTreeImpl binaryTree20 = new BinaryTreeImpl(20);

        binaryTree1.left = binaryTree2;
        binaryTree1.right = binaryTree3;
        binaryTree2.left = binaryTree4;
        binaryTree2.right = binaryTree6;
        binaryTree3.left = binaryTree7;
        binaryTree3.right = binaryTree8;
        binaryTree4.left = binaryTree9;
        binaryTree7.left = binaryTree10;
        binaryTree7.right = binaryTree11;
        binaryTree8.left = binaryTree12;
        binaryTree9.left = binaryTree13;
        binaryTree10.left = binaryTree15;
        binaryTree10.right = binaryTree16;
        binaryTree12.left = binaryTree5;
        binaryTree13.left = binaryTree14;
        binaryTree16.left = binaryTree17;
        binaryTree5.right = binaryTree20;
        binaryTree17.right = binaryTree18;
        binaryTree18.left = binaryTree19;

        return binaryTree1;
    }
}
