package tree;
/** 
 *@author liujun
 *@date�� 2018-8-2 ����04:44:26
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�Կ�³˹�����㷨������ķ�㷨���Ͻ�˹�����㷨���е���
 *@version 1.0
 */
public class TreeTest {

	//����������
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//���򹹽�������
		root = root.create_preOrder(root, tree_num, 0);
		BinaryTree k = root.findxandy(root, 7, 3);
		if (k != null) {
			System.out.println(k.value);
		}else {
			System.out.println("��ָ��");
		}
		//�������������
		/*System.out.println("�������������");
		root.preTraverse(root);
		System.out.println();
		//�������ǵݹ��������
		System.out.println("�������ǵݹ��������");
		root.preTraverse_no(root);
		System.out.println();
		//��������α���
		System.out.println("��������α���");
		root.levelTraverse(root);
		System.out.println();
		//���������д�ӡ
		System.out.println("���������д�ӡ");
		root.printTreebyLine(root);*/
	}
}
