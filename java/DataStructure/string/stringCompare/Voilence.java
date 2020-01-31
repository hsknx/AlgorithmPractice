package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-12-06 22:50
 * @author��Email: liujunfirst@outlook.com
 * @description: �ַ���ƥ�䱩����
 * @blogURL:
 */
public class Voilence implements StringCompare {
    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? voilenceCompare(source, target) : false;
    }

    public boolean voilenceCompare(String source, String target) {

        int targetlength = target.length();

        for (int i = 0; i <= source.length() - targetlength; i++) {
            String substring = source.substring(i, i + targetlength);
            if (substring.equals(target)) {
                return true;
            }
        }
        return false;
    }

}
