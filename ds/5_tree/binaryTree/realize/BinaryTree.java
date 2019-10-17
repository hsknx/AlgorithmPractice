package binaryTree.realize;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-18 01:38
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
//�����������ݽṹ
public class BinaryTree {

    public BinaryTree left;   //����
    public BinaryTree right;  //�Һ���
    public int value = 0;      //Ĭ�϶�������ֵΪ0
    public static int count = 0;//����һ��ȫ�־�̬��������

    public BinaryTree(int value) {
        // TODO Auto-generated constructor stub
        this.value = value;
    }

    public BinaryTree() {
        // TODO Auto-generated constructor stub
    }

    //�����������ֱ�����ֵ
    //���������������ֵ������,Լ��-1�ǿ�ָ��
    public BinaryTree create_preOrder(BinaryTree root, int [] tree_num , int i){

        if(i < tree_num.length){
            if(tree_num[i] == -1){
                root = null;
            }else{
                //new root's lchild and rchild
                BinaryTree lchild = new BinaryTree();
                BinaryTree rchild = new BinaryTree();
                //preOrder
                root.value = tree_num[i];
                //����++count�������ʱ������
                root.left = create_preOrder(lchild, tree_num, ++count);
                root.right = create_preOrder(rchild, tree_num, ++count);
            }
        }

        return root;
    }

    //���������������ֵ������
    public BinaryTree create_inOrder(BinaryTree root){

        return root;
    }

    //��������������ֵ������
    public BinaryTree create_postOrder(BinaryTree root){

        return root;
    }

    //�������
    public void clear(){
        count = 0;
    }
    //�������Ĳ�α���,ʹ��ջ������ʵ��
    public void levelTraverse(BinaryTree root){

        // Queue is just an interface, LinkedList is Realization
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTree note = queue.poll();
            System.out.print(note.value + " ");
            if(note.left != null){
                levelTraverse(note.left);
            }
            if(note.right != null){
                levelTraverse(note.right);
            }
        }
    }

    // �������İ��д�ӡ
    public void printTreebyLine(BinaryTree root) {
        if(root == null){
            return;
        }
        //���û��еı�־ָ�룺pre,next
        BinaryTree pre = null;
        BinaryTree next = null;
        //��������
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.offer(root);
        next = pre = root;
        //ָ���ƶ�����
        while (!queue.isEmpty()) {
            BinaryTree note = queue.poll();
            System.out.print(note.value + " ");
            if(note.left != null){
                pre = note.left;
                queue.add(note.left);
            }
            if(note.right != null){
                pre = note.right;
                queue.add(note.right);
            }
            //����
            if (note.value == next.value) {
                next = pre;
                System.out.println();
            }
        }
    }
}
