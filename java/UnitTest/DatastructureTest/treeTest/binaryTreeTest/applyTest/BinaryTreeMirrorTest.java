package UnitTest.datastructureTest.treeTest.binaryTreeTest.applyTest;

import DataStructure.tree.binaryTree.apply.BinaryTreeMirror;
import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;
import UnitTest.datastructureTest.treeTest.BinaryTreeTestDemo;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-20 10:17
 * @description Test of Mirror BinaryTree
 */
public class BinaryTreeMirrorTest extends BinaryTreeTestDemo {

    BinaryTreeMirror binaryTreeMirror = new BinaryTreeMirror();
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    @Test
    public void TestMirror() {

        //null
        assert binaryTree.equal(binaryTreeImplDemo1,binaryTreeMirror.Mirror(binaryTreeImplDemo1));

        //empty BinaryTreeImpl
        assert binaryTree.equal(new BinaryTreeImpl(),binaryTreeMirror.Mirror(new BinaryTreeImpl()));

        binaryTreeImplDemo3 = gettreeDemo03();
        assert binaryTree.equal(gettreeDemo03_Mirror(), binaryTreeMirror.Mirror(binaryTreeImplDemo3));

        binaryTreeImplDemo4 = gettreeDemo04();
        assert binaryTree.equal(gettreeDemo04_Mirror(), binaryTreeMirror.Mirror(binaryTreeImplDemo4));
    }

    public BinaryTreeImpl gettreeDemo03_Mirror() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree5 = new BinaryTreeImpl(5);
        BinaryTreeImpl binaryTree6 = new BinaryTreeImpl(6);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);

        binaryTree1.left = binaryTree3;
        binaryTree1.right = binaryTree2;
        binaryTree2.left = binaryTree5;
        binaryTree2.right = binaryTree4;
        binaryTree3.left = binaryTree7;
        binaryTree3.right = binaryTree6;
        return binaryTree1;
    }

    public BinaryTreeImpl gettreeDemo04_Mirror() {
        BinaryTreeImpl binaryTree1 = new BinaryTreeImpl(1);
        BinaryTreeImpl binaryTree2 = new BinaryTreeImpl(2);
        BinaryTreeImpl binaryTree3 = new BinaryTreeImpl(3);
        BinaryTreeImpl binaryTree4 = new BinaryTreeImpl(4);
        BinaryTreeImpl binaryTree7 = new BinaryTreeImpl(7);

        binaryTree1.left = binaryTree3;
        binaryTree1.right = binaryTree2;
        binaryTree2.left = null;
        binaryTree2.right = binaryTree4;
        binaryTree3.left = binaryTree7;
        binaryTree3.right = null;
        return binaryTree1;
    }
}
