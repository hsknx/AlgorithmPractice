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
public class Tree {

	public static void main(String[] args) {
		binary_tree root = new binary_tree();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};

		//���򹹽�������
		root = root.create_preOrder(root, tree_num, 0);
		//�������������
		System.out.println("�������������");
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
		root.printTreebyLine(root);
	}
}

//�����������ݽṹ
class binary_tree{
	
	binary_tree left;   //����
	binary_tree right;  //�Һ���
	int value = 0;      //Ĭ�϶�������ֵΪ0
	public static int count = 0;//����һ��ȫ�־�̬��������
	
	public binary_tree(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public binary_tree() {
		// TODO Auto-generated constructor stub
	}

	//�����������ֱ�����ֵ
	//���������������ֵ������,Լ��-1�ǿ�ָ��
	public binary_tree create_preOrder(binary_tree root, int [] tree_num ,int i){
		
		if(i < tree_num.length){
			if(-1 == tree_num[i]){
				root = null;
			}else{
				//new root's lchild and rchild
				binary_tree lchild = new binary_tree();
				binary_tree rchild = new binary_tree();
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
	public binary_tree create_inOrder(binary_tree root){
		
		return root;
	}
	
	//��������������ֵ������
	public binary_tree create_postOrder(binary_tree root){
	
	    return root;
    }

	//�������
	public void clear(){
		count = 0;
	}
	//�������Ĳ�α���,ʹ�ö�������ʵ��
	public void levelTraverse(binary_tree root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			binary_tree note = queue.poll();
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
	public void preTraverse(binary_tree root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			binary_tree note = queue.poll();
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
	public void preTraverse_no(binary_tree root) {
		Stack<binary_tree> stack = new Stack<binary_tree>();
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
	public void printTreebyLine(binary_tree root) {
		if(root == null){
			return;
		}
		//���û��еı�־ָ�룺pre,next
		binary_tree pre = null;
		binary_tree next = null;
		//��������
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		next = pre = root;
		//ָ���ƶ�����
		while (!queue.isEmpty()) {
			binary_tree note = queue.poll();
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