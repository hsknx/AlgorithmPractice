package Algorithm.dynamic.dynamicOrdinary;
/** 
 *@author liujun
 *@date�� 2018-12-18 ����07:03:04
 *@author��Email:liujunfirst@outlook.com
 *@description:��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������
 *@URL:��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������
 *@version 1.0
 */
public class �ҳ������������ {

	//�ǵݹ�д��
	public int maximalSquare(char[][] matrix) {
		
		//�߽��ж�
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
			return 0;
		}
		int count_best = 0;
		//ѭ������
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] != '0'){
					int f = serach(matrix,i,j);
					if( f > count_best){
						count_best = f;
					}
				}
			}
		}
        return count_best * count_best;
    }
	
	private int serach(char[][] matrix, int row, int column) {

		int count_temp = 1;
		int row_bound = row + 1;
		int column_bound = column + 1;
		while(row_bound < matrix.length && column_bound < matrix[0].length && judge(matrix, row, column, row_bound, column_bound)){
			count_temp++;
			row_bound++;
			column_bound++;
		}
		return count_temp;
	}
	
	private boolean judge(char[][] matrix, int row, int column, int row_bound, int column_bound) {

		for (int i = row; i <= row_bound; i++) {
			for (int j = column; j <= column_bound; j++) {
				if(matrix[i][j] != '1'){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
						   {'1','0','1','1','1'},
						   {'1','1','1','1','1'},
						   {'1','0','1','0','0'},
						   {'1','0','0','1','0'}};
		�ҳ������������ h = new �ҳ������������();
		System.out.println(h.maximalSquare(matrix));;
	}
}
