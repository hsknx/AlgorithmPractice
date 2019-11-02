package utils;

import java.util.Random;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-11-02 23:30
 * @author—Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class RamdomUtil {

    Random random = new Random();

    //随机生成不同长度的字符串
    public String productRandomString(){
        //字符串长度，限制在2-100
        //rand.nextInt(x)表示区间[0,x)
        int num = random.nextInt(99)+2;
        return productRandomString(num);
    }

    //随机生成给定长度的字符串
    public String productRandomString(int num){
        //在asc码中,'0'+17='A',“A”+32=“a”
        //所以，‘0-9’=‘0’+[0,9],‘A-Z’=‘0’+[17,42],‘a-z’=‘0’+[49,75]
        char a = '0';
        int addNum;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            addNum = getEqualNum();
            char c1 = (char) (a + addNum);
            stringBuffer.append(c1);
        }
        return stringBuffer.toString();
    }

    //生成一个等概率的[0,9],[17,42],[49,74]之间的数
    public int getEqualNum(){
        int equalNum = random.nextInt(75);
        if((equalNum > 9 && equalNum < 17) || (equalNum > 42 && equalNum < 49)){
            return getEqualNum();
        }
        return equalNum;
    }


}
