package stringApply;

import java.util.Random;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-28 19:55
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class ProductRandomString {

    //������ɲ�ͬ���ȵ��ַ���
    public String productRandomString(){

        //�ַ�������
        Random random = new Random();
        int num = random.nextInt();
        return productRandomString(num);
    }

    //������ɸ������ȵ��ַ���
    public String productRandomString(int num){


        return "";
    }

    public static void main(String[] args) {
        Random random = new Random();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 100000; i++) {
            int j = random.nextInt();
            if(j < min){
                min = j;
            }
            if(j > max){
                max = j;
            }
        }
        System.out.println("max:"+max+"===="+"min"+min);
    }
}
