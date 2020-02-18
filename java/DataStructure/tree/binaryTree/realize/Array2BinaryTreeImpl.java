package DataStructure.tree.binaryTree.realize;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @date 2020-02-18 16:42
 * @description 二叉树的实现
 * 根据按层/先/中/后序遍历的数组   创建  二叉树
 */
public class Array2BinaryTreeImpl implements Array2BinaryTree {
    @Override
    public BinaryTreeImpl createBinaryTree(int[] array) {
        if (!check(array)) {
            return null;
        }
        BinaryTreeImpl root = null;

        //借助队列实现
        Queue<BinaryTreeImpl> queue = new LinkedList();
        int depth = 0;
        root = new BinaryTreeImpl(array[depth]);
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeImpl binaryTree = queue.poll();
            //left child exist
            if (++depth < array.length && array[depth] != -1) {
                binaryTree.left = new BinaryTreeImpl(array[depth]);
                queue.offer(binaryTree.left);
            }
            //right child exist
            if (++depth < array.length && array[depth] != -1) {
                binaryTree.right = new BinaryTreeImpl(array[depth]);
                queue.offer(binaryTree.right);
            }
        }
         return root;


    }

    @Override
    public BinaryTreeImpl createPreOrder(BinaryTree root, int[] array) {
        return null;
    }

    @Override
    public BinaryTreeImpl createInOrder(BinaryTree root, int[] array) {
        return null;
    }

    @Override
    public BinaryTreeImpl createPostOrder(BinaryTree root, int[] array) {
        return null;
    }


}
