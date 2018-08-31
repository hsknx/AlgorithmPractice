package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 
 *@author liujun
 *@date�� 2018-7-21 ����01:13:08
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:�����������������������ֱ�����ֵ
 *���ж����������������������ݽṹ��
 *           �����������ֱ�����ֵ���������򡢺��򣩡�
 *           �������ǵݹ����������
 *           �������Ĳ�α�����
 *           �������İ��д�ӡ��
 *@version 1.0
 */

//�����������ݽṹ
public class BinaryTree{
	
	BinaryTree left;   //����
	BinaryTree right;  //�Һ���
	int value = 0;      //Ĭ�϶�������ֵΪ0
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
	public BinaryTree create_preOrder(BinaryTree root, int [] tree_num ,int i){
		
		if(i < tree_num.length){
			if(-1 == tree_num[i]){
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
	//�������Ĳ�α���,ʹ�ö�������ʵ��
	public void levelTraverse(BinaryTree root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTree note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				queue.add(note.left);
			}
			if(note.right != null){
				queue.add(note.right);
			}
		}
	}
	
	//���������������,ʹ�öӺ�ջ������ʵ��
	public void preTraverse(BinaryTree root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTree note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				preTraverse(note.left);
			}
			if(note.right != null){
				preTraverse(note.right);
			}
		}
	}
	
	//�������ǵݹ��������
	public void preTraverse_no(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.print(root.value + " ");
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
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
	
	//���Ҷ�������x��y����С�������ڵ�
	public BinaryTree findxandy(BinaryTree root, int x, int y) {
		// TODO Auto-generated method stub

		if (findx(root.left, x) && findx(root.left, y)) {
			return findxandy(root.left, x, y);
			
		}else if (findx(root.right, x) && findx(root.right, y)) {
			return findxandy(root.right, x, y);
			
		}else if (findx(root.left, x) && findx(root.right, y) 
				|| findx(root.right, x) && findx(root.left, y)) {
			return root;
			
		}else {
			return null;
		}
	}
	
	//���Ҷ��������Ƿ���x
	public boolean findx(BinaryTree root, int x) {

		if (null == root) {
			return false;
		}
		if (root.value == x) {
			return true;
		}
		return findx(root.left, x)||findx(root.right, x);
	}
}