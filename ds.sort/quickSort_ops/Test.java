package quickSort_ops;
/** 
 *@author liujun
 *@date�� 2019-3-23 ����12:08:06
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@URL:
 *@version 1.0
 */
public class Test {

	public static void main(String[] args) {
		//�������ݣ����������123456789
		int [] sort_num = {8,2,4,6,5,7,9,1,3};
		int [] sort_num1 = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		
		System.out.print("ԭʼ���ݣ�");
		for (int i = 0; i < sort_num.length; i++) {
			System.out.print(sort_num[i]+" ");
		}
		System.out.println();
		System.out.print("�����    ��");
		
		//�����������
		QuickSort quick_s = new QuickSort();
		
		//����������ԡ����������
		//sort_num = quick_s.QuickSortSimplex(sort_num, 0, sort_num.length-1);
		
		//����������ԡ���˫�����
		//sort_num = quick_s.QuickSortDuplexing(sort_num, 0, sort_num.length-1);
		
		//����������ԡ����Ľ�����
		
	}
}
