package DataStructure.tree.binaryTree.realize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 
 *@author liujun
 *@date 2018-7-21 下午01:13:08
 *@author—Email liujunfirst@outlook.com
 *@description 树、二叉树、二叉树的三种遍历赋值
 *其中二叉树包含：二叉树的数据结构、
 *           二叉树的三种遍历赋值（先序、中序、后序）、
 *           二叉树非递归先序遍历、
 *           二叉树的层次遍历、
 *           二叉树的按行打印。
 *@version 1.0
 */

//二叉树的数据结构
public class BinaryTreeTraversal {
	
	public BinaryTreeTraversal left;   //左孩子
	public BinaryTreeTraversal right;  //右孩子
	public int value = 0;      //默认二叉树的值为0
	public static int count = 0;//定义一个全局静态计数变量
	
	public BinaryTreeTraversal(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public BinaryTreeTraversal() {
		// TODO Auto-generated constructor stub
	}

	//二叉树的三种遍历赋值
	//将数组先序遍历赋值二叉树,约定-1是空指针
	public BinaryTreeTraversal create_preOrder(BinaryTreeTraversal root, int [] tree_num , int i){
		
		if(i < tree_num.length){
			if(-1 == tree_num[i]){
				root = null;
			}else{
				//new root's lchild and rchild
				BinaryTreeTraversal lchild = new BinaryTreeTraversal();
				BinaryTreeTraversal rchild = new BinaryTreeTraversal();
				//preOrder
				root.value = tree_num[i];
				//不用++count，构造的时候或出错
				root.left = create_preOrder(lchild, tree_num, ++count);
				root.right = create_preOrder(rchild, tree_num, ++count);
			}
		}
		
		return root;
	}
	
	//将数组中序遍历赋值二叉树
	public BinaryTreeTraversal create_inOrder(BinaryTreeTraversal root){
		
		return root;
	}
	
	//将数组后序遍历赋值二叉树
	public BinaryTreeTraversal create_postOrder(BinaryTreeTraversal root){
	
	    return root;
    }

	//清零操作
	public void clear(){
		count = 0;
	}


	//二叉树的层次遍历,使用队来辅助实现
	public void levelTraverse(BinaryTreeTraversal root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<BinaryTreeTraversal> queue = new LinkedList<BinaryTreeTraversal>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeTraversal note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				queue.add(note.left);
			}
			if(note.right != null){
				queue.add(note.right);
			}
		}
	}
	
	//二叉树的先序遍历,使用队和栈来辅助实现
	public void preTraverse(BinaryTreeTraversal root){
		// Queue is just an interface, LinkedList is Realization
		if(root == null){
			return;
		}
		Queue<BinaryTreeTraversal> queue = new LinkedList<BinaryTreeTraversal>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeTraversal note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				preTraverse(note.left);
			}
			if(note.right != null){
				preTraverse(note.right);
			}
		}
	}
	
	//二叉树非递归先序遍历
	public void preTraverse_no(BinaryTreeTraversal root) {
		Stack<BinaryTreeTraversal> stack = new Stack<BinaryTreeTraversal>();
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
	
	// 二叉树的按行打印
	public void printTreebyLine(BinaryTreeTraversal root) {
		if(root == null){
			return;
		}
		//设置换行的标志指针：pre,next
		BinaryTreeTraversal pre = null;
		BinaryTreeTraversal next = null;
		//树进队列
		Queue<BinaryTreeTraversal> queue = new LinkedList<BinaryTreeTraversal>();
		queue.offer(root);
		next = pre = root;
		//指针移动操作
		while (!queue.isEmpty()) {
			BinaryTreeTraversal note = queue.poll();
			System.out.print(note.value + " ");
			if(note.left != null){
				pre = note.left;
				queue.add(note.left);
			}
			if(note.right != null){
				pre = note.right;
				queue.add(note.right);
			}
			//换行
			if (note.value == next.value) {
				next = pre;
				System.out.println();
			}
		}
	}
	
	//查找二叉树中x和y的最小公共父节点
	public BinaryTreeTraversal findxandy(BinaryTreeTraversal root, int x, int y) {
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
	
	//查找二叉树中是否含有x
	public boolean findx(BinaryTreeTraversal root, int x) {

		if (null == root) {
			return false;
		}
		if (root.value == x) {
			return true;
		}
		return findx(root.left, x)||findx(root.right, x);
	}
}