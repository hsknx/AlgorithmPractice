package sort;
/** 
 *@author liujun
 *@date�� 2018-7-19 ����01:16:13
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class SortTest {

	public static void main(String[] args) {
		
		//�������ݣ����������123456789
		int [] array = {8,2,4,6,5,7,9,1,3};
		//int [] array1 = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		
		System.out.print("ԭʼ���ݣ�");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("�����    ��");
		
		//Ͱ����
		/*BucketSort sort = new BucketSort();
		System.out.println(sort.getClass().getName());
		sort_num1 = sort.bucketSort(array);*/
		
		//�鲢����
		/*MergeSort sort = new MergeSort();
		 * System.out.println(sort.getClass().getName());
		sort_num = sort.mergesort(array);*/
		
		//��������
		RadixSort sort = new RadixSort();
		System.out.println(sort.getClass().getName());
		sort.radixSort(array);
		
		//��������
		/*CountSort sort = new CountSort();
		System.out.println(sort.getClass().getName());
		sort_num = sort.countsort(array);*/
		
		//�������
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}