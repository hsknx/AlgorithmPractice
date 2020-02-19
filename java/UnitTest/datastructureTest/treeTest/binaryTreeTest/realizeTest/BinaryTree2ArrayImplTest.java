package UnitTest.datastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTree2Array;
import DataStructure.tree.binaryTree.realize.BinaryTree2ArrayImpl;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @date 2020-02-18 18:47
 * @description
 */
public class BinaryTree2ArrayImplTest extends BinaryTreeTestDemo {

    BinaryTree2Array binaryTree2Array = new BinaryTree2ArrayImpl();

    @Test
    public void TestBinary2Array() {
        binaryTreeImplDemo3 = gettreeDemo03();
        int[] array = binaryTree2Array.Binary2Array(binaryTreeImplDemo3);
        assert Arrays.equals(array,treeDemo03);
        //判断数组值相等的错误写法：
        //assert array.equals(treeDemo03);
        //Assert.assertEquals(array,treeDemo03);
    }
}
