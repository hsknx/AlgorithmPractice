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

        binaryTreeDemo1 = null;
        binaryTreeDemo2 = null;
        binaryTreeDemo3 = gettreeDemo03();
        binaryTreeDemo4 = gettreeDemo03();

        assert binaryTreeDemo.equal(binaryTreeDemo1, binaryTreeDemo2);
        assert !binaryTreeDemo.equal(binaryTreeDemo1, binaryTreeDemo3);
        assert !binaryTreeDemo.equal(binaryTreeDemo1, binaryTreeDemo4);
        assert !binaryTreeDemo.equal(binaryTreeDemo2, binaryTreeDemo3);
        assert !binaryTreeDemo.equal(binaryTreeDemo2, binaryTreeDemo4);
        assert binaryTreeDemo.equal(binaryTreeDemo3, binaryTreeDemo4);
    }
}
