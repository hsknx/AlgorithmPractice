package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-06 22:44
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class RabinKarp implements StringCompare {
    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? RabinKarpcmp(source, target) : false;
    }

    public boolean RabinKarpcmp(String source, String target){
        return false;
    }
}
