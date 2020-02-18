package DataStructure.tree;

/**
 * @author liujun
 * @date�� 2020-02-18 16:09
 */
public interface BinaryTreeCreate {

    /*
     * 1�����ݰ���/��/��/�������������   ����  ������
     * 2�����������ݰ���/��/��/���������  ���  ����
     * */
    //���㹹��������
    public BinaryTree createBinaryTree(BinaryTree root, int[] array);

    //���򴴽�������
    public BinaryTree createPreOrder(BinaryTree root, int[] array);

    //���򴴽�������
    public BinaryTree createInOrder(BinaryTree root, int[] array);

    //���򴴽�������
    public BinaryTree createPostOrder(BinaryTree root, int[] array);

    //�������������
    public int[] Binary2Array(BinaryTree root);

    //��������������������
    public int[] Binary2ArrayPreOrder(BinaryTree root);

    //��������������������
    public int[] Binary2ArrayInOrder(BinaryTree root);

    //��������������������
    public int[] Binary2ArrayPostOrder(BinaryTree root);
}
