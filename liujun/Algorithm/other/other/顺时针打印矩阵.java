package Algorithm.other.other;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����08:41:46
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 *���磬�����������4*4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 *�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *@version 1.0
 */
public class ˳ʱ���ӡ���� {
	
	public ˳ʱ���ӡ����(){
		
	}
	
	public ˳ʱ���ӡ����(int [][] matrix){
		
		//��ȡ������С��С�����
		int row = matrix.length;
		int column = matrix[0].length;
		int count = row * column;
		
		while(count > 0){
			for (int i = 0; i < matrix[0].length; i++) {
				System.out.print(matrix[0][i]+" ");
				count--;
			}
			matrix = Matrix_transposed(matrix);
		}
	}
	
	//ȥ����һ��֮���ٽ��о���ת��
	public int [][] Matrix_transposed(int [][] matrix){
		
		//��ȡ������С���
		int row = matrix.length;
		int column = matrix[0].length;
		//�½�һ��ת�����飬������һ
		int [][] matrix_transposed = new int [column][row-1];
		for (int i = 1,h=0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix_transposed[column-j-1][h] = matrix[i][j];
			}
			h++;
		}
		/* 
		 * �������
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row-1; j++) {
				System.out.print(matrix_transposed[i][j]+ " ");
			}
			System.out.println();
		}*/
		return matrix_transposed;
	}
	
	public static void main(String[] args) {
		
		int [][] matrix_a = {{1,5,7,6,9},{5,7,8,3,1},{2,4,8,6,1}}; 
		//int [][] matrix_b = {{5,7,6,3},{5,3,1,5},{2,4,1,3},{5,6,8,2},{8,3,1,1}};
	
		new ˳ʱ���ӡ����(matrix_a);
		//s.Matrix_transposed(matrix_a);
	}
}
