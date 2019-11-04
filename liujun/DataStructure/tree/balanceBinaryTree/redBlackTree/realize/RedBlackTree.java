package DataStructure.tree.balanceBinaryTree.redBlackTree.realize;

/** 
 *@author liujun
 *@date： 2018-8-29 下午10:29:42
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:红黑树
 *包括方法：containsKey(), get(), put(), remove()。
 *本文只处理int类型值的红黑树。
 *@version 1.0
 */
public class RedBlackTree {

	int value;
	RedBlackTree left;
	RedBlackTree right;
	RedBlackTree parent;
	String color ;
	
	static RedBlackTree root = new RedBlackTree(-1);
	
	//构造函数
	public RedBlackTree() {

		this.value = -1;
		color = "RED";
	}
	
	public RedBlackTree(int value) {
		this.value = value;
		color = "RED";
	}

	public RedBlackTree add(int[] array) {
		
		root.clear();
		for (int i = 0; i < array.length; i++) {
			root = add(root, array[i]);
		}
		return root;
	}

	public RedBlackTree add(int value) {
		
		root.clear();
		return root = add(root, value);
	}
	
	//放入元素
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
		//寻找插入点
		while (search != null) {
			search_bef = search;
			if (search.value < value) {
				search = search.right;
			}else {
				search = search.left;
			}
		}
		//结点插入
		point.parent = search_bef;
		if (search_bef.value < value) {
			search_bef.right = point;
		}else {
			search_bef.left = point;
		}
		// 每次插入进行结点调整,此处仅对point.paren进行判断，后续判断在insertFixup中进行?
		if (null != point.parent) {
			root = insertFixup(root, point);
		}
		return root;
	}
	
	//返回这个元素在树中的排序数(从小到大)
	//仅仅找到该节点，并计算其左子树有多少节点即可
	public int get(int value) {

		return get(root, value);
	}
	
	public int get(RedBlackTree root, int value) {

		if(!root.containsKey(value)){
			return -1;
		}
		if(root.value == value){
			return countTreeNum(root.left) + 1;
		}
		if(value < root.value){
			return get(root.left, value);
		}else{
			return countTreeNum(root.left) + 1 + get(root.right, value);
		}
	}
	
	public int countTreeNum(RedBlackTree root) {

		if(root == null){
			return 0;
		}
		return 1 + countTreeNum(root.left) + countTreeNum(root.right);
	}
	
	public boolean containsKey(int value) {
		
		return root.containsKey(root, value);
	}

	//元素检查
	public boolean containsKey(RedBlackTree root, int value) {

		if(root == null){
			return false;
		}
		if(root.value == value){
			return true;
		}
		if(value < root.value){
			return containsKey(root.left, value);
		}else{
			return containsKey(root.right, value);
		}
	}
	
	public void remove(int value) {
		remove(root, value);
	}
	
	//移除元素,共两种情况：1.叶子结点    2、仅有左孩子或者右孩子的结点
	public void remove(RedBlackTree root, int value) {

		if(!root.containsKey(value)){
			return ;
		}
		
		
	}
	
	//判断类型的时候，1、先看待删除的节点的颜色，
	//           2、再看兄弟节点的颜色，
	//           3、再看侄子节点的颜色（侄子节点3.1、先看远侄子3.2、再看近侄子），
	//           4、最后看父亲节点的颜色
	
	//情况一：删除叶子节点为红色，直接删除的情况
	public void deleteRedLeaf(RedBlackTree root) {

		if(root == null){
			return ;
		}
		if(root.parent.left == root){
			root.parent.left = null;
		}else{
			root.parent.right = null;
		}
	}
	
	//情况二：删除叶子节点为黑色
	//情况2.1：待删除节点D的兄弟节点S为红色
	public void deleteBlackLeafwithRedBrother(RedBlackTree root, RedBlackTree point){
		if(point == null){
			return ;
		}
		//待删除结点为左孩子
		if(point.parent.left == point){
			RedBlackTree tempRight = point.parent.right;
			//颜色互换
			String s = tempRight.color;
			tempRight.color = point.parent.color;
			point.parent.color = s;
			//LL
			rotateLeft(root, point.parent);
			deleteBlackLeafwithBlackBrother(root, point);
		}else{//待删除结点为右孩子
			RedBlackTree tempRight = point.parent.left;
			//颜色互换
			String s = tempRight.color;
			tempRight.color = point.parent.color;
			point.parent.color = s;
			//RR
			rotateRight(root, point.parent);
			deleteBlackLeafwithBlackBrother(root, point);
		}
		
	}
	//情况2.2：待删除节点D的兄弟节点S为黑色。
	public void deleteBlackLeafwithBlackBrother(RedBlackTree root, RedBlackTree point){
		if(root == null){
			return ;
		}
		
		if(point.parent.left == point){
			//RedBlackTree tempRight = point.parent.right;
			//有一个侄子结点为红色
			
			//判断父亲结点颜色
			
		}
	}
	
	//情况2.2.1：且远侄子节点为红色
	public void rightNephewisRed(RedBlackTree point){
		
	}
	
	//情况2.2.2：近侄子结点为红色且远侄子节点为黑色
	public void leftNephewisRed(RedBlackTree point){
		
	}
	
	//情况2.2.3：父节点为红色(当前节点为黑色，兄弟节点为黑色)
	public void fatherisRed(RedBlackTree point){
		RedBlackTree temppoint;
		if(point.parent.left == point){
			temppoint = point.parent.right;
			//删除结点
			point.parent.left = null;
		}else{
			temppoint = point.parent.left;
			point.parent.right = null;
		}
		String s = point.parent.color;
		point.parent.color = temppoint.color;
		point.color = s;
		temppoint.color = s;
	}

	//情况2.2.4：父节点为黑色(当前节点为黑色，兄弟节点为黑色)
	public void fatherisBlack(RedBlackTree point){
	
		if(point.parent.left == point){
			point.right.color = "RED";
			point.parent.left = null;
		}else{
			point.left.color = "RED";
			point.parent.right = null;
		}
		fixcolor(point.parent);
	}
	
	public void fixcolor(RedBlackTree point) {

		//根节点
		if(point.parent == null){
			
		}else{
			if("RED".equals(point.parent.color)){
				if(point.parent.left == point){
					point.right.color = "RED";
					point.parent.color = "BLACK";
				}else{
					point.left.color = "RED";
					point.parent.color = "BLACK";
				}
			}else{
				
			}
		}
	}
	
	//情况三：删除节点为黑色，子节点为红色(只有右子树或只有左子树的节点)
	public void deleteOnlyleftorOnlyright(RedBlackTree point){
		if(point == null){
			return ;
		}
		RedBlackTree pointTemp;
		if(point.left != null){
			pointTemp = point.left;
			if(point.parent.left == point){
				point.parent.left = pointTemp;
			}else{
				point.parent.right = pointTemp;
			}
		}else{
			pointTemp = point.right;
			if(root.parent.right == root){
				root.parent.right = pointTemp;
			}else{
				root.parent.left = pointTemp;
			}
		}
		pointTemp.parent = point.parent;
		pointTemp.color = point.color;
	}

	//清理
	public void clear() {

		root = new RedBlackTree();
	}
	
	//中序输出红黑树，从小到大
	public void print(RedBlackTree root) {

		if (null == root) {
			return;
		}
		print(root.left);
		System.out.print(root.value + " ");
		print(root.right);
	}
	
	//调整红黑树的颜色：红叔问题和黑叔问题，其中黑叔问题继续分为左右孩子问题
	public RedBlackTree insertFixup(RedBlackTree root, RedBlackTree point) {

		RedBlackTree uncle;
		//父节点是红色
		while (null != point.parent && "RED".equals(point.parent.color)) {
			//父节点位置。问题一：为什么“祖父节点”之前是黑色？
			//这个应该很容易想明白，因为在变换操作之前，该树是红黑树，“父节点”是红色,那么“祖父节点”一定是黑色。
			//问题二：为什么将“祖父节点”由“黑色”变成红色，同时，将“叔叔节点”由“红色”变成“黑色”？
			//能解决“包含“父节点”和“叔叔节点”的分支的黑色节点的总数增加了1”的问题。
			if (root == point.parent) {
				root.color = "BLACK";
				return root;
			}else {
				//else间接说明point.parent.parent！=null
				//红黑叔问题
				if (point.parent == point.parent.parent.left) {
					//父节点是祖父节点的左孩子，叔叔是右孩子
					uncle = point.parent.parent.right;
					//因为空指针的颜色默认是黑色，所以先解决黑叔问题
					if (null == uncle || "BLACK".equals(uncle.color)) {
						//黑叔问题:右孩子问题
						//(01) 将“父节点”设为“黑色”。(02) 将“祖父节点”设为“红色”。(03) 以“祖父节点”为支点进行右旋。
						//(01)避免了两个红结点，(02)避免了经过父节点分支的黑色节点的个数增加了1
						//(03)避免了经过uncle分支的黑色节点的个数增加了1
						if (point == point.parent.right) {
							root = rotateLeft(root, point.parent);
							point = point.left;//注意当前结点更新
						}//右孩子问题转化为左孩子问题
						//黑叔问题:左孩子问题
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						//此处右旋跟左右孩子无关，仅跟(03)相关
						root = rotateRight(root, point.parent.parent);
						return root;
						
					//红叔问题
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
					//父节点是祖父节点的右孩子，叔叔是左孩子
					uncle = point.parent.parent.left;
					//黑叔
					if (null == uncle || "BLACK".equals(uncle.color)) {
						if (point == point.parent.left) {
							root = rotateRight(root, point.parent);
							point = point.right;//注意当前结点更新
						}
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						root = rotateLeft(root, point.parent.parent);
						return root;
						
					//红叔	
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
	
	//右旋函数,注意：右旋使用当且仅当结点的左孩子存在时，因此，不需要对point.right进行判断。
	private RedBlackTree rotateRight(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pleft = point.left;
		//处理point左孩子的右孩子问题
		point.left = pleft.right;
		if (null != pleft.right) {
			pleft.right.parent = point;
		}
		//处理point的父节点问题
		pleft.parent = point.parent;
		if (null == point.parent) {
			root = pleft;
		}else if(point.parent.left == point){
			point.parent.left = pleft;
		}else {
			point.parent.right = pleft;
		}
		//处理point自身问题
		pleft.right = point;
		point.parent = pleft;
		return root;
	}
	
	//左旋函数,注意：左旋使用当且仅当结点的右孩子存在时，因此，不需要对point.right进行判断。
	private RedBlackTree rotateLeft(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pright = point.right;
		//处理point右孩子的左孩子问题
		point.right = pright.left;
		if (null != pright.left) {
			pright.left.parent = point;
		}
		//处理point的父节点问题
		pright.parent = point.parent;
		if (null == point.parent) {
			root = pright;
		}else if(point.parent.left == point){
			point.parent.left = pright;
		}else {
			point.parent.right = pright;
		}
		//处理point自身问题
		pright.left = point;
		point.parent = pright;
		return root;
	}
	
	//主方法测试
	public static void main(String[] args) {
		//RedBlackTree root = new RedBlackTree();
		//int[] array1 = {8,2,4,6,5,7,9,1,3};
		
		int[] array = {0, 2, 2, 3, 3, 3, 4, 5, 9, 9, 9, 10, 10, 12, 12, 13, 14, 15, 15, 15, 16, 17, 19, 19, 20, 21, 21, 21, 25, 25, 26, 26, 26, 27, 28, 30, 31, 31, 32, 34, 34, 35, 37, 39, 40, 41, 41, 42, 42, 42, 42, 45, 46, 46, 46, 46, 47, 50, 51, 54, 54, 55, 56, 59, 62, 65, 65, 65, 67, 67, 69, 71, 74, 75, 76, 77, 77, 78, 78, 79, 79, 80, 80, 80, 80, 82, 82, 82, 82, 84, 85, 85, 85, 89, 89, 91, 95, 98, 98, 100};
		System.out.println(array.length);
		root.add(array);
		System.out.println(root.containsKey(45));
		root.print(root);
		System.out.println();
		System.out.println(root.get(16));
		System.out.println(root.get(95));
		System.out.println(root.get(45));
	}
}
