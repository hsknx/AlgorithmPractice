package DataStructure.tree.binaryTree.apply;

import DataStructure.tree.binaryTree.realize.BinaryTreeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @date 2020-02-20 11:39
 * @description  ��������������·���͡�
 * ���������·������·����
 */
public class BinaryTreeLargestSubPath {

    int sum;
    int sumTemp;
    List<Integer> list;
    List<Integer> listTemp;

    public int countLargestSum(BinaryTreeImpl binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        sumTemp += binaryTree.value;
        if (sumTemp > sum) {
            sum = sumTemp;
        }

        countLargestSum(binaryTree.left);
        countLargestSum(binaryTree.right);

        sumTemp -= binaryTree.value;
        return sum;
    }

    public int[] countLargestSubPath(BinaryTreeImpl binaryTree) {
        //init
        list = new ArrayList<>();
        listTemp = new ArrayList<>();
        sum = 0;
        sumTemp = 0;
        //count
        countPath(binaryTree);
        int[] arrayValue = list.stream().mapToInt(Integer::intValue).toArray();
        return arrayValue;
    }

    private List countPath(BinaryTreeImpl binaryTree) {
        if (binaryTree == null) {
            return list;
        }

        sumTemp += binaryTree.value;
        listTemp.add((Integer) binaryTree.value);
        if (sumTemp > sum) {
            sum = sumTemp;
            list = new ArrayList<>(listTemp);
        }
        countPath(binaryTree.left);
        countPath(binaryTree.right);

        sumTemp -= binaryTree.value;
        //�˴���Ҫע�� list �� remove �÷�
        listTemp.remove((Integer) binaryTree.value);
        return list;
    }
}
