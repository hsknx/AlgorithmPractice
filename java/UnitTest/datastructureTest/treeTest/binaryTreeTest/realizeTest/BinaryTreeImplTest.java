package UnitTest.datastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:47
 * @description 测试二叉树的equal方法
 */
public class BinaryTreeImplTest extends BinaryTreeTestDemo {

    @Test
    public void testequals() {

        BinaryTreeImpl binaryTreeDemo = new BinaryTreeImpl();

        binaryTreeImplDemo1 = null;
        binaryTreeImplDemo2 = null;
        binaryTreeImplDemo3 = gettreeDemo03();
        binaryTreeImplDemo4 = gettreeDemo03();

        assert binaryTreeDemo.equal(binaryTreeImplDemo1, binaryTreeImplDemo2);
        assert !binaryTreeDemo.equal(binaryTreeImplDemo1, binaryTreeImplDemo3);
        assert !binaryTreeDemo.equal(binaryTreeImplDemo1, binaryTreeImplDemo4);
        assert !binaryTreeDemo.equal(binaryTreeImplDemo2, binaryTreeImplDemo3);
        assert !binaryTreeDemo.equal(binaryTreeImplDemo2, binaryTreeImplDemo4);
        assert binaryTreeDemo.equal(binaryTreeImplDemo3, binaryTreeImplDemo4);
    }
}
