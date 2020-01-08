package Algorithm.dynamic.dynamicOrdinary;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-05 02:12
 * @author��Email:liujunfirst@outlook.com
 * @description:
 * ��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������
 * �ⷨһ��������
 *        1.1������ѭ��ɨ�跨��������ɨ�裩
 *        1.2�����ɨ�跨
 *        1.3����󳤶����Ʒ�
 * �ⷨ������̬�滮��
 * �ⷨ������̬�滮�Ż�
 */
public class LargestSquare {

    //������ⷨ
    public int violenceSolution(int[][] Matrix) {

        //У����󣺿�ֵ����
        if(Matrix == null){
            return -1;
        }
        //У����󣺽���0,1,�������-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if (Matrix[i][j] != 0) {
                    //���ɨ�跨
                    int num = getMaxSideLengthScanner(Matrix, i, j);
                    MaxSideLength = MaxSideLength > num ? MaxSideLength : num;
                }
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //��̬�滮��
    public int dynamicSolution(int[][] Matrix) {

        //У����󣺿�ֵ����
        if(Matrix == null){
            return -1;
        }
        //У����󣺽���0,1,�������-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        //״̬����
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        int[][] statusMatrix = new int[raw_bound + 1][column_bound + 1];

        for (int i = 1; i <= raw_bound; i++) {
            for (int j = 1; j <= column_bound; j++) {
                if(Matrix[i-1][j-1] == 1){
                    statusMatrix[i][j] = Math.min(Math.min(statusMatrix[i-1][j-1], statusMatrix[i-1][j]), statusMatrix[i][j-1]) + 1;
                    MaxSideLength = MaxSideLength > statusMatrix[i][j] ? MaxSideLength : statusMatrix[i][j];
                }
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //��̬�滮�Ż�
    public int dynamicOptSolution(int[][] Matrix) {

        //У����󣺿�ֵ����
        if(Matrix == null){
            return -1;
        }
        //У����󣺽���0,1,�������-3
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0 && Matrix[i][j] != 1){
                    return -3;
                }
            }
        }
        int MaxSideLength = 0;
        //״̬����
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        int[] statusMatrix = new int[column_bound + 1];
        int pre = 0;
        int now ;

        for (int i = 1; i <= raw_bound; i++) {
            for (int j = 1; j <= column_bound; j++) {
                now = statusMatrix[j];
                if(Matrix[i-1][j-1] == 1){
                    statusMatrix[j] = Math.min(Math.min(now, pre), statusMatrix[j-1]) + 1;
                    MaxSideLength = MaxSideLength > statusMatrix[j] ? MaxSideLength : statusMatrix[j];
                }else{
                    statusMatrix[j] = 0;
                }
                pre = now;
            }
        }
        return MaxSideLength * MaxSideLength;
    }

    //����ѭ��ɨ�跨��������ɨ�裩
    public int getMaxSideLengthViolence(int[][] Matrix, int rawposition, int columnposition) {

        //��ֵ����
        if(Matrix == null){
            return -1;
        }
        int MaxLength = 0;
        boolean flag = true;
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //Խ������
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }
        while(flag && ((rawposition + MaxLength) < raw_bound) && ((columnposition + MaxLength) < column_bound)){
            MaxLength++;
            for (int i = 0; i <= MaxLength; i++) {
                for (int j = 0; j <= MaxLength; j++) {
                    if (Matrix[rawposition + i][columnposition + j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag == false){
                    break;
                }
            }
        }
        return MaxLength--;
    }

    //���ɨ�跨
    public int getMaxSideLengthScanner(int[][] Matrix, int rawposition, int columnposition) {

        //��ֵ����
        if(Matrix == null){
            return -1;
        }
        int MaxLength = 1;
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //Խ������
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }
        while((MaxLength + rawposition < raw_bound) && (MaxLength + columnposition < column_bound)){
            //ɨ����
            for (int i = columnposition; i <= columnposition + MaxLength; i++) {
                if(Matrix[rawposition + MaxLength][i] == 0){
                    return MaxLength--;
                }
            }
            //ɨ����
            for (int j = rawposition; j <= rawposition + MaxLength; j++) {
                if(Matrix[j][columnposition + MaxLength] == 0){
                    return MaxLength--;
                }
            }
            MaxLength++;
        }
        return MaxLength--;
    }

    //��󳤶����Ʒ�
    public int getMaxSideLengthLimit(int[][] Matrix, int rawposition, int columnposition) {

        //��ֵ����
        if(Matrix == null){
            return -1;
        }
        int raw_bound = Matrix.length;
        int column_bound = Matrix[0].length;
        //�����������,ѡ����Сֵ
        int MaxColumnLength = column_bound - columnposition;
        int MaxRawLength = raw_bound - rawposition;
        int MaxLength = MaxColumnLength > MaxRawLength ? MaxRawLength : MaxColumnLength;
        //Խ������
        if(rawposition >= raw_bound || columnposition >= column_bound){
            return -2;
        }

        //���ɨ����
        for (int i = rawposition; i < MaxLength + rawposition; i++) {
            //�в��䣬ɨ����
            for (int j = columnposition; j < MaxLength + columnposition; j++) {
                if (Matrix[i][j] == 0){
                    MaxColumnLength = j - columnposition;
                    break;
                }
            }
            //������������� ���ڵ��� ������ ˵�������ν���
            MaxRawLength = i - rawposition;
            if(MaxRawLength >= MaxColumnLength){
                return MaxRawLength;
            }
        }
        return MaxLength;
    }
}
