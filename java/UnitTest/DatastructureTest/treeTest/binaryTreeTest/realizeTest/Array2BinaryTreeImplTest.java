package UnitTest.DatastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.Array2BinaryTree;
import DataStructure.tree.binaryTree.realize.Array2BinaryTreeImpl;
import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import UnitTest.DatastructureTest.treeTest.BinaryTreeTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:02
 * @description 测试二叉树的实现
 * 根据按层/先/中/后序遍历的 数组   创建  二叉树
 */
public class Array2BinaryTreeImplTest extends BinaryTreeTestDemo {

    Array2BinaryTree binaryTreeCreate = new Array2BinaryTreeImpl();

    @Test
    public void testBinaryTreeCreateImpl() {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();

        binaryTreeImplDemo1 = binaryTreeCreate.createBinaryTree(treeDemo01);
        assert binaryTreeImplDemo1 == null;

        binaryTreeImplDemo1 = binaryTreeCreate.createBinaryTree(treeDemo02);
        assert binaryTreeImplDemo1 == null;

        binaryTreeImplDemo1 = binaryTreeCreate.createBinaryTree(treeDemo03);
        binaryTreeImplDemo3 = gettreeDemo03();
        assert binaryTree.equal(binaryTreeImplDemo1, binaryTreeImplDemo3);

        binaryTreeImplDemo1 = binaryTreeCreate.createBinaryTree(treeDemo04);
        binaryTreeImplDemo4 = gettreeDemo04();
        assert binaryTree.equal(binaryTreeImplDemo1, binaryTreeImplDemo4);

        binaryTreeImplDemo1 = binaryTreeCreate.createBinaryTree(treeDemo05);
        binaryTreeImplDemo4 = gettreeDemo05();
        assert binaryTree.equal(binaryTreeImplDemo1, binaryTreeImplDemo4);
    }
}
