package tree;

import java.util.LinkedList;
import java.util.Queue;


/** 
 *@author liujun
 *@date�� 2018-7-21 ����01:13:08
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:���������������������ֵ��������
 *���������ֵ�����������������ֵ������
 *���ж����������������������ݽṹ�������������ֱ�����ֵ���������Ĳ�α������������İ��д�ӡ	
 *@version 1.0
 */
public class Tree {

	public static void main(String[] args) {
		binary_tree root = new binary_tree();
		int [] tree_num ={1,5,7,-1,-1,-1,8,6,3,-1,-1,2,-1,-1,9,-1,-1};
	
		//���򹹽�������
		root = root.create_preOrder(root, tree_num, 0);
		root.levelTraverse(root);
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
			if(tree_num[i] == -1){
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
	//�������Ĳ�α���,ʹ��ջ������ʵ��
	public void levelTraverse(binary_tree root){
		
		// Queue is just an interface, LinkedList is Realization
		Queue<binary_tree> queue = new LinkedList<binary_tree>();
		queue.offer(root);
		while(!queue.isEmpty()){
			binary_tree note = queue.poll();
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
}