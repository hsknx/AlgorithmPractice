package DataStructure.tree.binaryTree.realize;

import sun.reflect.generics.tree.Tree;

/**
 * @author liujun
 * @date 2020-02-18 16:13
 * @description  ������
 */
public interface BinaryTree extends Tree {

    //�ж������������Ƿ����
    public boolean equal(BinaryTreeImpl source, BinaryTreeImpl target);

    //���д�ӡ������
    public void printTreebyLine(BinaryTreeImpl root);

}
