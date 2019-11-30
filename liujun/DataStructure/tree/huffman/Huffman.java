package DataStructure.tree.huffman;
/** 
 *@author liujun
 *@date�� 2018-8-27 ����09:37:31
 *@author��Email:liujunfirst@outlook.com
 *@description:������ת��Ϊ�շ�������
 *@version 1.0
 */
public class Huffman {

	//Ȩֵ��ָ����
	int weight;
	int left,right,parent;
	
	public Huffman[] buildHuffman(int[] array) {
		
		//����Huffman���鲢��ʼ��
		Huffman[] root = new Huffman[2 * array.length - 1];
		//��ʼ��
		for (int i = 0; i < 2 * array.length - 1; i++) {
			root[i] = new Huffman();
			root[i].left = root[i].right = root[i].parent = -1;
			if (i < array.length) {
				root[i].weight = array[i];
			}
		}
		//Ѱ����Сֵ�ʹ�Сֵ����������ϵ
		int min = 0;
		int minsecond = 0;
		int min_flag = 0;
		int minsecond_flag = 0;
		//ע�⣺j < array.length - 1������ʱΪ�˹���n-1����Ҷ�ӽ�㡣
		//����array�����root����
		for (int j = 0; j < array.length - 1; j++) {
			//ÿ�ζ���Ҫ���¸�ֵ
			min = Integer.MAX_VALUE;
			minsecond = Integer.MAX_VALUE;
			//Ѱ����Сֵ�ʹ�Сֵ
			for (int k = 0; k < array.length + j; k++) {
				if (min > root[k].weight && root[k].parent == -1) {
					minsecond_flag = min_flag;
					min_flag = k;
					minsecond = min;
					min = root[k].weight;
				}else if (minsecond > root[k].weight && root[k].parent == -1) {
					minsecond_flag = k;
					minsecond = root[k].weight;
				}
			}
			//������ϵ
			root[array.length + j].weight = minsecond + min;
			root[array.length + j].left = min_flag;
			root[array.length + j].right = minsecond_flag;
			root[min_flag].parent = array.length + j;
			root[minsecond_flag].parent = array.length + j;
		}
		return root;
	}
	
	public void printHuffman(Huffman[] root) {
		// TODO Auto-generated method stub

		int findnum = 0;
		int findparent = -1;
		//��ӡ���ڵ�
		for (int g = 0; g < root.length; g++) {
			if (root[g].parent == findparent) {
				System.out.print(root[g].weight + " ");
				findnum++;
				findparent = g;
			}
		}
	}
	//����������
	public static void main(String[] args) {
		int[] array = {1,48,17,65,42,34,44,16,41,5};
		Huffman huf = new Huffman();
		//huf.buildHuffmanArray(array);
		huf.printHuffman(huf.buildHuffman(array));
	}
}
