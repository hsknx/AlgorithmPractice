package UnitTest.DatastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import UnitTest.DatastructureTest.treeTest.BinaryTreeTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-18 18:47
 * @description 测试二叉树的equal方法、二叉树的按行打印
 */
public class BinaryTreeImplTest extends BinaryTreeTestDemo {

    BinaryTreeImpl binaryTreeDemo = new BinaryTreeImpl();

    @Test
    public void Testequals() {

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

    @Test
    public void TestprintTreebyLine() {

        binaryTreeDemo.printTreebyLine(binaryTreeImplDemo1);
        binaryTreeDemo.printTreebyLine(binaryTreeImplDemo2);
        binaryTreeImplDemo3 = gettreeDemo03();
        binaryTreeImplDemo4 = gettreeDemo04();
        System.out.println("===3==");
        binaryTreeDemo.printTreebyLine(binaryTreeImplDemo3);
        System.out.println("===4==");
        binaryTreeDemo.printTreebyLine(binaryTreeImplDemo4);
    }

}
