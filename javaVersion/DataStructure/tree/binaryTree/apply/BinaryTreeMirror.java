package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

/**
 * @author liujun
 * @date 2020-02-20 10:17
 * @description  操作给定的二叉树，将其变换为原二叉树的镜像（反转二叉树）。
 */

//BinaryTreeReversal
public class BinaryTreeMirror {

    public BinaryTreeImpl Mirror(BinaryTreeImpl root){

        if(root == null){
            return root;
        }
        //exchange left child and rght child
        BinaryTreeImpl binaryTree = root.left;
        root.left = root.right;
        root.right = binaryTree;
        //miror left child and rght child
        Mirror(root.left);
        Mirror(root.right);
        return root;
    }
}
