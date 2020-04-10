package DataStructure.string;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-31 22:11
 * @author��Email  liujunfirst@outlook.com
 * @description  �ַ���ƥ���㷨�Ľӿ�
 * @blogURL
 */
public interface StringCompare {

    /*
    @params source:Դ��
    @params target:Ŀ�괮
     */
    public boolean compare(String source, String target);

    default boolean check(String source, String target) {
        //�ǿ�У��
        if(source == null || target == null){
            return false;
        }
        //�Ӵ�����У��
        return target.length() <= source.length();
    }

}
