package sort;
/** 
 *@author liujun
 *@date�� 2019-3-23 ����12:10:15
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:1��ͳ��ԭʼ�����Ƶ��(����Сֵ�Ż�)
 *2�����ͳ�ƺ�����顣
 *@URL:
 *@version 1.0
 */
public class CountSort {

	public  int[] countsort(int[] array) {
		//1���ҳ�ԭʼ����������Сֵ
		int max = array[0];
		int min = array[0];
		
		for(int i: array){
			if(max < i){
				max = i;
			}
			if(min > i){
				min = i;
			}
		}
		//2�������µ������С  min��max֮�䣬�����䣬�У�max-min+1��������
		int[] newarray = new int[max - min + 1];
		
		//3��һ��ѭ��ͳ�����ݡ����Ż�����Сֵ֮ǰ�����ô洢
		for (int i = 0; i < array.length; i++) {
			newarray[array[i]-min]++;
		}
		//4���������
		/*for (int i = 0; i < newarray.length; i++) {
			while(newarray[i] != 0){
				System.out.print(i+min+" ");
				newarray[i]--;
			}
		}*/
		//4������������
		int[] b = new int[array.length];
		
		//�Ż�ǰ������������ѭ�������п�,�˷�ѭ������
		/*int count = 0;
		for (int i = 0; i < newarray.length; i++) {
			while(newarray[i] != 0){
				b[count++] = i + min;
				newarray[i]--;
			}
		}*/
		
		/*�Ż��󷽰�:1���ҳ���Ӧλ�ж����ۼӵ�ͳ�����ݣ�
		          2�������ۻ��������b���顣
		 *ע������:1��i���뵽0������array[0]�޷�������
		         2��b���飬������--�����ǵ�newarray����С��ͳ��λ�����1��
		                             ��Ӧb�������Сֵ(��0λ)�����Ա�����--*/
		for (int i = 1; i < newarray.length; i++) {
			newarray[i] += newarray[i-1];
		}
		
		for (int i = array.length-1; i >= 0; i--) {
			b[--newarray[array[i]-min]] = array[i];
		}
		return b;
	}
}
