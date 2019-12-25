package Algorithm.dynamic.dynamicPrimary;

import Logic.check.MatrixCheck;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 16:44
 * @author��Email: liujunfirst@outlook.com
 * @description: ����һ����ά���飬�䱣����һ������������ triangleMatrix[] []��
 * ������������ζ��˵��׶˸����ֺ���С��·��֮�ͣ�
 * ÿ�ο������������ڵ�����λ��
 * @blogURL:
 */
public class MiniValuePathofTriangle {

    public int method(int[][] matrix){
        //��������Ƿ�Ϊnull,�Ƿ�Ϊ������
        if(!MatrixCheck.judgeisTriangle(matrix)){
            return -1;
        }

        //����Ƿ������һ������
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix[0][0];
        }
        int bestValue = 0;
        int[][] bestMatrix = new int[matrix.length][matrix[matrix.length-1].length];
        //�ײ�����
        for (int i = 0; i < matrix.length; i++) {
            bestMatrix[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                bestMatrix[i][j] = Math.min(bestMatrix[i+1][j+1],bestMatrix[i+1][j]) + matrix[i][j];
            }
        }
        return bestMatrix[0][0];
    }
}
