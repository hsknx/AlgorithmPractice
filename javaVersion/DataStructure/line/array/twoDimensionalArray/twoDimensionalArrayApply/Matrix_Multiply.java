package DataStructure.line.array.twoDimensionalArray.twoDimensionalArrayApply;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-7-19 ����03:07:41
 * @author��Email liujunfirst@outlook.com
 * @description  ������ˡ�
 */
public class Matrix_Multiply {

    public int[][] MatrixMultiply(int[][] materix_a, int[][] materix_b) {

        //������˺�ľ���
        int row = materix_a.length;//��ȡ�������
        int column = materix_b[0].length;//��ȡ�������
        int[][] materix_c = new int[row][column];
        int k = materix_b.length;//������˵��м�Ԫ�ظ���

        //�������
        //����ѭ��A�������,ʱ�临�Ӷȣ�O(materix_a.length)
        for (int i = 0; i < row; i++) {
            //��ѭ��B�������,ʱ�临�Ӷȣ�O(materix_b[0].length)
            for (int j = 0; j < column; j++) {
                //A�������Ԫ�غ�B������Ԫ��������,
                //ע��materix_b.length=materix_a[0].length != materix_c���κ�ֵ
                for (int h = 0; h < k; h++) {
                    materix_c[i][j] += materix_a[i][h] * materix_b[h][j];
                }
            }
        }
		return materix_c;
    }

    public void printMatrix(int[][] materix_c){
		int row = materix_c.length;//��ȡ�������
		int column = materix_c[0].length;//��ȡ�������
		//��ӡ���c����
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(materix_c[i][j] + " ");
			}
			System.out.println();
		}
	}
}