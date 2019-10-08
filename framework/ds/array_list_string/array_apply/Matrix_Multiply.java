package array_apply;
/** 
 *@author liujun
 *@date�� 2018-7-19 ����03:07:41
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:������ˡ�
 *@version 1.0
 */
public class Matrix_Multiply {

	public Matrix_Multiply(int [][] materix_a, int [][] materix_b) {

		//������˺�ľ���
		//��ȡ�������
		int row = materix_a.length;
		//��ȡ�������
		int column = materix_b[0].length;
		int [][] materix_c = new int [row][column];
		
		//�������
		//����ѭ��A�������,ʱ�临�Ӷȣ�O(materix_a.length)
		for (int i = 0; i < materix_a.length; i++) {
			//��ѭ��B�������,ʱ�临�Ӷȣ�O(materix_b[0].length)
			for (int j = 0; j < materix_b[0].length; j++) {
				//A�������Ԫ�غ�B������Ԫ��������,
				//ע��materix_b.length=materix_a[0].length=materix_c[0].length
				for (int h = 0; h < materix_b.length; h++) {
					materix_c[i][j] += materix_a[i][h]*materix_b[h][j];
				}
			}
		}
		
		//��ӡ���c����
		for (int i = 0; i < materix_c.length; i++) {
			for (int j = 0; j < materix_c[0].length; j++) {
				System.out.print(materix_c[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		//׼���������󣨶�ά���飩:a��3*5��b��5*4
		int [][] materix_a = {{1,5,7,6,9},{5,7,8,3,1},{2,4,8,6,1}}; 
		int [][] materix_b = {{5,7,6,3},{5,3,1,5},{2,4,1,3},{5,6,8,2},{8,3,1,1}};
		
		new Matrix_Multiply(materix_a, materix_b);
	}
}