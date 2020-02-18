package UnitTest.datastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.Array2BinaryTree;
import DataStructure.tree.binaryTree.realize.Array2BinaryTreeImpl;
import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:02
 * @description
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
    }
}
