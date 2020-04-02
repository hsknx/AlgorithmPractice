package DataStructure.string;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-31 22:11
 * @author—Email  liujunfirst@outlook.com
 * @description  字符串匹配算法的接口
 * @blogURL
 */
public interface StringCompare {

    /*
    @params source:源串
    @params target:目标串
     */
    public boolean compare(String source, String target);

    default boolean check(String source, String target) {
        //非空校验
        if(source == null || target == null){
            return false;
        }
        //子串长度校验
        return target.length() <= source.length();
    }

}
