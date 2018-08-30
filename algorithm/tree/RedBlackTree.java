package tree;

import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date�� 2018-8-29 ����10:29:42
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�����
 *����������containsKey(), get(), put(), remove()��
 *����ֻ����int����ֵ�ĺ������
 *@version 1.0
 */
public class RedBlackTree {

	int value;
	RedBlackTree left;
	RedBlackTree right;
	RedBlackTree parent;
	String color ;
	
	//���캯��
	public RedBlackTree() {
		// TODO Auto-generated constructor stub
		this.value = -1;
		color = "RED";
	}
	
	public RedBlackTree(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		color = "RED";
	}

	//��������,ע�⣺����ʹ�õ��ҽ����������Ӵ���ʱ����ˣ�����Ҫ��point.right�����жϡ�
	private RedBlackTree rotateRight(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pleft = point.left;
		//����point���ӵ��Һ�������
		point.left = pleft.right;
		if (null != pleft.right) {
			pleft.right.parent = point;
		}
		//����point�ĸ��ڵ�����
		pleft.parent = point.parent;
		if (null == point.parent) {
			root = pleft;
		}else if(point.parent.left == point){
			point.parent.left = pleft;
		}else {
			point.parent.right = pleft;
		}
		//����point��������
		pleft.right = point;
		point.parent = pleft;
		return root;
	}
	
	//��������,ע�⣺����ʹ�õ��ҽ��������Һ��Ӵ���ʱ����ˣ�����Ҫ��point.right�����жϡ�
	private RedBlackTree rotateLeft(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pright = point.right;
		//����point�Һ��ӵ���������
		point.right = pright.left;
		if (null != pright.left) {
			pright.left.parent = point;
		}
		//����point�ĸ��ڵ�����
		pright.parent = point.parent;
		if (null == point.parent) {
			root = pright;
		}else if(point.parent.left == point){
			point.parent.left = pright;
		}else {
			point.parent.right = pright;
		}
		//����point��������
		pright.left = point;
		point.parent = pright;
		return root;
	}
	
	//����Ԫ��
	public RedBlackTree add(RedBlackTree root, int value) {

		//init
		if (-1 == root.value) {
			root.value = value;
			root.color = "BLACK";
			return root;
		}
		RedBlackTree point = new RedBlackTree(value);
		RedBlackTree search = root;
		RedBlackTree search_bef = root;
		//Ѱ�Ҳ����
		while (search != null) {
			search_bef = search;
			if (search.value < value) {
				search = search.right;
			}else {
				search = search.left;
			}
		}
		//������
		point.parent = search_bef;
		if (search_bef.value < value) {
			search_bef.right = point;
		}else {
			search_bef.left = point;
		}
		// ÿ�β�����н�����,�˴�����point.paren�����жϣ������ж���insertFixup�н���?
		if (null != point.parent) {
			root = insertFixup(root, point);
		}
		return root;
	}
	
	//�������������ɫ����������ͺ������⣬���к������������Ϊ���Һ�������
	public RedBlackTree insertFixup(RedBlackTree root, RedBlackTree point) {

		RedBlackTree uncle;
		//���ڵ��Ǻ�ɫ
		while (null != point.parent && "RED".equals(point.parent.color)) {
			//���ڵ�λ�á�����һ��Ϊʲô���游�ڵ㡱֮ǰ�Ǻ�ɫ��
			//���Ӧ�ú����������ף���Ϊ�ڱ任����֮ǰ�������Ǻ�����������ڵ㡱�Ǻ�ɫ,��ô���游�ڵ㡱һ���Ǻ�ɫ��
			//�������Ϊʲô�����游�ڵ㡱�ɡ���ɫ����ɺ�ɫ��ͬʱ����������ڵ㡱�ɡ���ɫ����ɡ���ɫ����
			//�ܽ�������������ڵ㡱�͡�����ڵ㡱�ķ�֧�ĺ�ɫ�ڵ������������1�������⡣
			if (root == point.parent) {
				root.color = "BLACK";
				return root;
			}else {
				//else���˵��point.parent.parent��=null
				//���������
				if (point.parent == point.parent.parent.left) {
					//���ڵ����游�ڵ�����ӣ��������Һ���
					uncle = point.parent.parent.right;
					//��Ϊ��ָ�����ɫĬ���Ǻ�ɫ�������Ƚ����������
					if (null == uncle || "BLACK".equals(uncle.color)) {
						//��������:�Һ�������
						//(01) �������ڵ㡱��Ϊ����ɫ����(02) �����游�ڵ㡱��Ϊ����ɫ����(03) �ԡ��游�ڵ㡱Ϊ֧�����������
						//(01)�������������㣬(02)�����˾������ڵ��֧�ĺ�ɫ�ڵ�ĸ���������1
						//(03)�����˾���uncle��֧�ĺ�ɫ�ڵ�ĸ���������1
						if (point == point.parent.right) {
							root = rotateLeft(root, point.parent);
							point = point.left;//ע�⵱ǰ������
						}//�Һ�������ת��Ϊ��������
						//��������:��������
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						//�˴����������Һ����޹أ�����(03)���
						root = rotateRight(root, point.parent.parent);
						return root;
						
					//��������
					}else {
						uncle.color = "BLACK";
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						point = point.parent.parent;
						if (root == point) {
							root.color = "BLACK";
							return root;
						}
					}
				}else {
					//���ڵ����游�ڵ���Һ��ӣ�����������
					uncle = point.parent.parent.left;
					//����
					if (null == uncle || "BLACK".equals(uncle.color)) {
						if (point == point.parent.left) {
							root = rotateRight(root, point.parent);
							point = point.right;//ע�⵱ǰ������
						}
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						root = rotateLeft(root, point.parent.parent);
						return root;
						
					//����	
					}else {
						uncle.color = "BLACK";
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						point = point.parent.parent;
						if (root == point) {
							root.color = "BLACK";
							return root;
						}
					}
				}
			}
		}
		return root;
	}
	
	//Ԫ�ؼ��
	public boolean containsKey(int value) {

		return false;
	}
	
	//�Ƴ�Ԫ��
	public void remove() {

	}
	
	//����������������С����
	public void print(RedBlackTree root) {

		if (null == root) {
			return;
		}
		print(root.left);
		System.out.print(root.value + " ");
		print(root.right);
	}
	
	//����������
	public static void main(String[] args) {
		RedBlackTree root = new RedBlackTree();
		int[] array = {8,2,4,6,5,7,9,1,3};
		for (int i = 0; i < array.length; i++) {
			root = root.add(root, array[i]);
		}
		System.out.println(root.containsKey(45));
		root.print(root);
	}
}
