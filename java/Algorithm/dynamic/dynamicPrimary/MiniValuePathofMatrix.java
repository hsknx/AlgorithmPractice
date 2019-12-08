package Algorithm.dynamic.dynamicPrimary;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-25 17:00
 * @author��Email: liujunfirst@outlook.com
 * @description: ��֪һ����ά���飬���д洢�˷Ǹ�������
 * �ҵ������Ͻǵ����½ǵ�һ��·����
 * ʹ��·���ϵĺ���С��(�ƶ�������ֻ�����»�����)
 * @blogURL:
 */
public class MiniValuePathofMatrix {

    public int method(int[][] matrix){
        int matrixLength = matrix.length;
        //��������Ƿ�Ϊnull
        if(matrix == null || matrixLength == 0){
            return -1;
        }
        //��������Ƿ�Ϊ����
        for (int i = 0; i < matrixLength; i++) {
            if(matrix[i].length != matrixLength){
                return -1;
            }
        }
        //����Ƿ������һ������
        if(matrixLength == 1 && matrix[0].length == 1){
            return matrix[0][0];
        }
        //initial
        int bestValue = 0;
        int[][] bestMatrix = new int[matrixLength][matrixLength];
        bestMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < matrixLength; i++) {
            bestMatrix[0][i] = bestMatrix[0][i-1] + matrix[0][i];
            bestMatrix[i][0] = bestMatrix[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrixLength; i++) {
            for (int j = 1; j < matrixLength; j++) {
                bestMatrix[i][j] = Math.min(bestMatrix[i][j-1],bestMatrix[i-1][j])+matrix[i][j];
            }
        }
        return bestMatrix[matrixLength-1][matrixLength-1];
    }
}
