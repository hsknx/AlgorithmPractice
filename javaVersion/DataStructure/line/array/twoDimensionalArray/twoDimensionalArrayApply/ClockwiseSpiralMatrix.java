package DataStructure.line.array.twoDimensionalArray.twoDimensionalArrayApply;

import Logic.check.MatrixCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujun
 * @version 1.0
 * @date 2019-11-09 22:22
 * @author��Email liujunfirst@outlook.com
 * @description  ˳ʱ����������
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * *���磬�����������4*4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * *�����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockwiseSpiralMatrix {

    //��λ���㷨
    public int[] print(int[][] matrix) {
        if (!MatrixCheck.judgeisRectangle(matrix)) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        //���Ͻ�(a, b),���½�(c, d)
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        int[] target = new int[(c + 1) * (d + 1)];
        while (a <= c && b <= d) {
            //�����һȦ��ӡ
            //��������������С�������
            if (a == c) {
                for (int i = b; i <= d; i++) {
                    list.add(matrix[a][i]);
                }
            } else if (b == d) {
                for (int i = a; i <= c; i++) {
                    list.add(matrix[i][b]);
                }
            } else {
                //�ĸ�ѭ�����ֱ��Ǵ����ң����ϵ��£����ҵ��󣬴��µ���
                for (int i = b; i < d; i++) {
                    list.add(matrix[a][i]);
                }
                for (int i = a; i < c; i++) {
                    list.add(matrix[i][d]);
                }
                for (int i = d; i > b; i--) {
                    list.add(matrix[c][i]);
                }
                for (int i = c; i > a; i--) {
                    list.add(matrix[i][b]);
                }
            }
            //��Сһ��
            a++;
            b++;
            c--;
            d--;
        }
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        //target = list.toArray(new int[0]);
        return target;
    }

    //ת�÷�
    public int[] TranspositionPrint(int[][] matrix) {
        if (!MatrixCheck.judgeisRectangle(matrix)) {
            return null;
        }
        //��ȡ������С��С�����
        int row = matrix.length;
        int column = matrix[0].length;
        int count = row * column;
        List<Integer> list = new ArrayList<Integer>();
        int[] target = new int[row * column];

        while (count > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
                count--;
            }
            matrix = Matrix_transposed(matrix);
        }
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }

    //ת�ú�����ȥ����һ��֮���ٽ��о���ת��
    public int[][] Matrix_transposed(int[][] matrix) {

        //��ȡ������С���
        int row = matrix.length;
        int column = matrix[0].length;
        //�½�һ��ת�����飬������һ
        int[][] matrix_transposed = new int[column][row - 1];
        for (int i = 1, h = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix_transposed[column - j - 1][h] = matrix[i][j];
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
}