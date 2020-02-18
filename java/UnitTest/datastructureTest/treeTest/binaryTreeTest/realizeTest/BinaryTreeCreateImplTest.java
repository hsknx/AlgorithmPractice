package UnitTest.datastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTreeCreate;
import DataStructure.tree.binaryTree.realize.BinaryTreeCreateImpl;
import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:02
 * @description
 */
public class BinaryTreeCreateImplTest extends BinaryTreeTestDemo {

    BinaryTreeCreate binaryTreeCreate = new BinaryTreeCreateImpl();

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
