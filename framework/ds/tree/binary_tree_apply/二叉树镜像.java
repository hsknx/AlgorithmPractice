package binary_tree_apply;
/** 
 *@author liujun
 *@date�� 2018-7-21 ����10:46:09
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:���������Ķ�����������任ΪԴ�������ľ��񣨷�ת����������
 *@version 1.0
 */
public class ���������� {

	public binary_tree Mirro(binary_tree root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return root;
		}
		binary_tree temp = null;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		Mirro(root.left);
		Mirro(root.right);
		
		return root;
	}
}
