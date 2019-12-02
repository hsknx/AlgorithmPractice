package DataStructure.stackHeapQueue.stack.stackApply;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-12-01 17:48
 * @author—Email: liujunfirst@outlook.com
 * @description: 判断给定字符串中含有的最长有效括号
 * @blogURL:
 */
public class LongestEffectBrackets {

    EffectBrackets effectBrackets = new EffectBrackets();
    //序列中最长有效括号——暴力法
    public int LongestEffectBracketsNum_violence(String pattern){
        if(pattern == null || pattern.length() == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < pattern.length() - 1; i++) {
            for (int j = i + 1; j < pattern.length(); j++) {
                if(effectBrackets.EffectBracketsbyTotalNum(pattern.substring(i, j + 1))) {
                    sum = j - i + 1 > sum ? j - i + 1 : sum;
                }
            }
        }
        return sum;
    }

    //序列中最长有效括号
    public int LongestEffectBracketsNum_(String pattern){
        if(pattern == null || pattern.length() == 0){
            return 0;
        }
        int sum = 0;

        return sum;
    }
}
