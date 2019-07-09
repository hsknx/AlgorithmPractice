package binary_tree_apply;

/** 
 *@author liujun
 *@date： 2018-7-21 上午10:57:09
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:输入两棵二叉树A，B，判断B是不是A的子结构。
 *（ps：我们约定空树不是任意一个树的子结构）
 *思路：如果当前结点相同，则通过compare函数进行对比。
 *compare函数对两个树进行相似判断。
 *@version 1.0
 */
public class TreeJudge {

	boolean flag = false;
	
	//子树判断
	public boolean judgeTree(binary_tree tree1, binary_tree tree2) {
		
		if(tree1 == null || tree2 == null){
			//此处直接return，否则进入下一个if,产生空指针异常
			return false;
		}
		//如果值相等，进行子树判断。
		if(tree1.value == tree2.value && compare(tree1, tree2)){
			flag = true;
		}else {
			if(judgeTree(tree1.left, tree2) ||
					judgeTree(tree1.right, tree2)){
				flag = true;
			}
		}
		return flag;
	}
	
	//二叉树比对，判断二叉树是否完全一致
	public boolean compare(binary_tree tree1, binary_tree tree2){
		
		//判断根节点是否相等,方法采用tree2匹配tree1，
	    //当tree2为空时，无论tree1为何值，均可判断tree2匹配tree1。
		if(tree2 ==null){
			return true;
		}
		
		//当tree1为空，但是tree2不为空，判断tree2不是tree1的一部分。
		if(tree1 == null && tree2 !=null){
			return false;
		}
		//当tree1和tree2均不为空，且值相等，递归判断相同
		if(tree1.value == tree2.value){
			return compare(tree1.left, tree2.left)
			&&compare(tree1.right, tree2.right);
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		//test
		//A数组
		int [] A = {8,8,9,-1,-1,2,4,7,-1,-1,7,-1,-1,-1,-1};
		//B数组
		int [] B = {8,9,-1,-1,2,-1,-1};
		//int [] B = {9,-1,-1};

		binary_tree bta = new binary_tree();
		binary_tree btb = new binary_tree();
		
		//A数组先序遍历形成A树
		bta.create_preOrder(bta, A, 0);
		//B数组先序遍历形成B树
		bta.clear();
		btb.create_preOrder(btb, B, 0);
		
		//子树判断
		TreeJudge zishu = new TreeJudge();
	    System.out.println(zishu.judgeTree(bta,btb));
		
		/*TreeJudgeOps tjo = new TreeJudgeOps();
		System.out.println(tjo.treeJudgeOps(bta, btb));
		*/
	}
}