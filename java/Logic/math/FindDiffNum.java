package Logic.math;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-01-14 14:22
 * @author��Email: liujunfirst@outlook.com
 * @description: �ҳ���ͬ����
 * @blogURL:
 */
public class FindDiffNum {

    //һ������Ϊ99�����飬���ݷ�Χ��1-100�����������ݾ����ظ����ҳ���ʧ���Ǹ���
    /*
    * size:���ݷ�Χ
    * array:����
    * array.length == size -1*/
    public int findLostNum(int[] array, int begin){
        int sum = array.length + begin;
        for (int i = 0; i < array.length; i++) {
            sum += (begin - array[i]);
            begin++;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindDiffNum f = new FindDiffNum();
       /* int[] hh = {1,2,3,9,8,7,5,6,4};
        int h = f.findLostNum(hh,1);
        System.out.println(h);*/

        int[] hh = {1,2,3,9,8,7,6,6,4,0};
        int h = f.findRepertNum(hh);
        System.out.println(h);

    }
    //һ������Ϊ100�����飬��100������99����ͬ���ҳ��Ǹ���ͬ����
    public int findRepertNum(int[] array){
        //�����ڽ���
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < 9; i++) {

        }
        return 1;
    }
}
