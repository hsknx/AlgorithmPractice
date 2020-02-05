package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-12-06 22:44
 * @author—Email: liujunfirst@outlook.com
 * @description: RabinKarp : 将字符串化成数字的加和来处理
 * @blogURL:
 */
public class RabinKarp implements StringCompare {

    @Override//跟进制和素数的选择有关系
    public boolean compare(String source, String target) {
        return check(source, target) ? compare(source, target, 17, 26) : false;
    }

    public boolean compare(String source, String target, int prime, int HEX) {
        return check(source, target) ? RabinKarpcmp(source, target, prime, HEX) : false;
    }

    //定义素数 prime 、进制 HEX
    public boolean RabinKarpcmp(String source, String target, int prime, int HEX) {

        int[] sourcechar = new int[source.length()];
        int[] targetchar = new int[target.length()];
        for (int i = 0; i < source.length(); i++) {
            sourcechar[i]=(int)source.indexOf(i);
        }
        for (int i = 0; i < target.length(); i++) {
            targetchar[i] = (int)target.indexOf(i);
        }

        //为了在后续便捷的从source[0] 计算出 source[1],计算出 退出参数/计算高度
        //参见42-44行的计算过程
        int h = 1;
        for (int i = 0; i < target.length() - 1; i++) {
            h = h * HEX % prime;
        }
        //预处理source, target字符串，计算 target 和 source[0]
        int targetValue = 0;
        int sourceValue = 0;
        for (int i = 0; i < target.length(); i++) {
            sourceValue = (HEX * sourceValue + sourcechar[i]) % prime;
            targetValue = (HEX * targetValue + targetchar[i]) % prime;
        }
        //字符串对比
        for (int i = 0; i < source.length() - target.length(); i++) {
            //字符串相等，进一步确认
            if (sourceValue == targetValue && source.substring(i, i + target.length()).equals(target)) {
                return true;
            } else {//字符串不等，求通项
                sourceValue = ((sourceValue - sourcechar[i] * h) * HEX + sourcechar[i + target.length()]) % prime;
            }
        }

        return false;
    }
}
