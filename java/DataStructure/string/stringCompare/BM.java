package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-06 22:52
 * @author��Email: liujunfirst@outlook.com
 * @description: Boyer-Moore �ַ���ƥ���㷨
 * @blogURL:
 */
public class BM implements StringCompare {
    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? bmcmp(source, target) : false;
    }

    public boolean bmcmp(String source, String target){
        return false;
    }
}
