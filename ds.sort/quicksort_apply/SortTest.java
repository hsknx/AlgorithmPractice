package quicksort_apply;
/** 
 *@author liujun
 *@date�� 2018-8-25 ����04:58:55
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class SortTest {

	//����������
	public static void main(String[] args) {
		int [] test = {1,2,3,2,2,2,5,5,4,2};
		//int [] test = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		/*�ҳ������������Ǹ����� g = new �ҳ������������Ǹ�����();
		System.out.println("˼·һ������ԭ��=====");
		g.method_pigeon(test);
		System.out.println("˼·��������ԭ��=====");
		g.method_quicksort(test);
		System.out.println("˼·����map����=====");
		g.method_map(test);*/
		int k = 6;
		ReturnKMin km = new ReturnKMin();
		//km.kMinQuickSort(test, k, 0, test.length - 1);
		km.kMinHeap(test, k);
		
		for (int i = 0; i < k; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
