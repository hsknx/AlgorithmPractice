package DataStructure.tree.binaryTree.realize;

/**
 * @author liujun
 * @date�� 2020-02-18 16:09
 * ������
 */
public class BinaryTreeImpl implements BinaryTree {

    public BinaryTreeImpl left;    //����
    public BinaryTreeImpl right;   //�Һ���
    public int value = 0;          //Ĭ�϶�������ֵΪ0
    public static int count = 0;   //����һ��ȫ�־�̬��������

    public BinaryTreeImpl() {
        this.left = null;
        this.right = null;
        this.value = 0;
    }

    public BinaryTreeImpl(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    @Override
    public boolean equal(BinaryTreeImpl source, BinaryTreeImpl target) {

        return source == null ? target == null : simple(source, target);
    }

    public boolean simple(BinaryTreeImpl source, BinaryTreeImpl target) {
        if (target == null) {
            return false;
        }
        if (source.value != target.value) {
            return false;
        } else {
            return equal(source.left, target.left) && equal(source.right, target.right);
        }
    }
}
