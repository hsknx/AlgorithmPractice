package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date�� 2020-02-18 16:09
 * ������
 */
public class BinaryTreeImpl {

    public BinaryTreeImpl left;    //����
    public BinaryTreeImpl right;   //�Һ���
    public int value = 0;          //Ĭ�϶�������ֵΪ0
    public static int count = 0;   //����һ��ȫ�־�̬��������

    BinaryTreeImpl(){
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    BinaryTreeImpl(int value){
        this.left = null;
        this.right = null;
        this.value = value;
    }
}
