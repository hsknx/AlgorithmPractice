package DataStructure.line.array.twoDimensionalArray.apply;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-05 02:12
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class LargestSquare {

    public int LargestSquareSolution(int[][] Matrix){
        //У�����

        //����ֻ���� 1 ����������Σ������������
        int MaxValue = 0;

        return MaxValue * MaxValue;
    }


    //������ⷨ
    public int violenceMethod(int[][] Matrix){

        int MaxSideLength = 0;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] != 0){
                    int num = getMaxSideLengthScanner(1,1);
                }
            }
        }


        return MaxSideLength;
    }

    //��̬�滮��
    public int dynamicMethod(int[][] Matrix){

        int MaxSideLength = 0;

        return MaxSideLength;
    }

    //��̬�滮�Ż�
    public int dynamicOptMethod(int[][] Matrix){

        int MaxSideLength = 0;

        return MaxSideLength;
    }

    //����ѭ������������ɨ�裩
    public int getMaxSideLengthViolence(int rawline, int columnline){

        int MaxLength = 0;
        return MaxLength;
    }

    //���ɨ�跨
    public int getMaxSideLengthScanner(int rawline, int columnline){

        int MaxLength = 0;
        return MaxLength;
    }

    //��󳤶����Ʒ�
    public int getMaxSideLengthLimit(int rawline, int columnline){

        int MaxLength = 0;
        return MaxLength;
    }
}
