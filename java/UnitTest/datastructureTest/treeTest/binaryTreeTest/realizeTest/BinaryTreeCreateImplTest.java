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
public class BinaryTreeCreateImplTest {

    BinaryTreeCreate binaryTreeCreate = new BinaryTreeCreateImpl();

    @Test
    public void testBinaryTreeCreateImpl(){
        BinaryTreeImpl binaryTreeImpl = binaryTreeCreate.createBinaryTree(treeDemo01);
        assert binaryTreeImpl == null;
        binaryTreeImpl = binaryTreeCreate.createBinaryTree(treeDemo02);
        assert binaryTreeImpl == null;
        /*binaryTreeImpl = binaryTreeCreate.createBinaryTree(treeDemo03);
        assert binaryTreeImpl.equals(gettreeDemo03());*/
    }

    int[] treeDemo01 = {};
    int[] treeDemo02 = null;



}
