package UnitTest.DatastructureTest.treeTest.binaryTreeTest.realizeTest;

import DataStructure.tree.binaryTree.realize.BinaryTree2Array;
import DataStructure.tree.binaryTree.realize.BinaryTree2ArrayImpl;
import UnitTest.DatastructureTest.treeTest.BinaryTreeTestDemo;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @date 2020-02-18 18:47
 * @description ���Զ�����
 * ���ݰ���/��/��/���������  ���  ����
 */
public class BinaryTree2ArrayImplTest extends BinaryTreeTestDemo {

    BinaryTree2Array binaryTree2Array = new BinaryTree2ArrayImpl();

    @Test
    public void TestBinary2Array() {

        int[] array = binaryTree2Array.Binary2Array(gettreeDemo03());
        assert Arrays.equals(array, treeDemo03);
        //�ж�����ֵ��ȵĴ���д����
        //assert array.equals(treeDemo03);
        //Assert.assertEquals(array,treeDemo03);
        array = binaryTree2Array.Binary2Array(gettreeDemo04());
        treeDemo04 = Arrays.stream(treeDemo04).filter(x -> x != -1).toArray();
        assert Arrays.equals(array, treeDemo04);

        array = binaryTree2Array.Binary2Array(gettreeDemo05());
        treeDemo05 = Arrays.stream(treeDemo05).filter(x -> x != -1).toArray();
        assert Arrays.equals(array, treeDemo05);
    }
}
