package Logic.math;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-03 20:09
 * @author��Email: liujunfirst@outlook.com
 * @description: ������nֻˮͰ������ˮ�ж������m������������
 * ����Ҫ������x��������p�������ҳ� ���ж��� ˮͰ��
 * ��nֻˮͰ�����ҽ���һֻ�ж���Ͱ��
 * @blogURL:
 */
public class Poolpig {

    public int needNum(int bucketNum, int alivetime, int givenTime){

        if(bucketNum <= 0 || alivetime <= 0 || givenTime <= 0){
            return 0;
        }
        if(givenTime <= alivetime){
            return 0;
        }
        int maxtTestNum = givenTime / alivetime + 1;
        double logNum = Math.log(bucketNum) / Math.log(maxtTestNum);
        int needNum = (int)Math.ceil(logNum);
        return needNum <= 1 ? 1 : needNum;
    }
}
