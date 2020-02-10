package Logic.check;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-25 22:44
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
//������
public class MatrixCheck {

    //����Ƿ�Ϊ�վ���
    public static boolean judgeisNull(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return true;
        }
        return false;
    }

    //����Ƿ�Ϊ������
    public static boolean judgeisSquare(int[][] matrix){

        if(judgeisNull(matrix)){
            return false;
        }
        //�������Ƿ�Ϊ������
        int matrixLength = matrix.length;
        long p = Arrays.stream(matrix).filter(x -> x.length == matrixLength).count();
        return matrixLength == p;
    }

    //����Ƿ�Ϊ������
    public static boolean judgeisRectangle(int[][] matrix){
        if(judgeisNull(matrix)){
            return false;
        }
        //�������Ƿ�Ϊ������
        int length = matrix[0].length;
        long p = Arrays.stream(matrix).filter(x -> x.length == length).count();
        return matrix.length == p;
    }

    //����Ƿ�Ϊ������
    public static boolean judgeisTriangle(int[][] matrix){
        if(judgeisNull(matrix)){
            return false;
        }
        //��������Ƿ�Ϊ������
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != i + 1){
                return false;
            }
        }
        return true;
    }
}