package DataStructure.tree.binaryTree.realize;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liujun
 * @date 2020-02-18 18:46
 * @description  ���������ݰ���/��/��/���������  ���  ����
 */
public class BinaryTree2ArrayImpl implements BinaryTree2Array {

    @Override//����������������
    public int[] Binary2Array(BinaryTreeImpl root) {
        List<Integer> list = new LinkedList<>();
        Queue<BinaryTreeImpl> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.value);
        while (!queue.isEmpty()) {
            BinaryTreeImpl binaryTree = queue.poll();
            if (binaryTree.left != null) {
                queue.offer(binaryTree.left);
                list.add(binaryTree.left.value);
            }
            if (binaryTree.right != null) {
                queue.offer(binaryTree.right);
                list.add(binaryTree.right.value);
            }
        }
        int[] binaryTrees = list.stream().mapToInt(Integer::intValue).toArray();
        return binaryTrees;
    }

    @Override
    public int[] Binary2ArrayPreOrder(BinaryTreeImpl root) {
        return new int[0];
    }

    @Override
    public int[] Binary2ArrayInOrder(BinaryTreeImpl root) {
        return new int[0];
    }

    @Override
    public int[] Binary2ArrayPostOrder(BinaryTreeImpl root) {
        return new int[0];
    }
}
