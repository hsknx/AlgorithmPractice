package DataStructure.tree.balanceBinaryTree.redBlackTree.apply;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liujun
 * @version 1.0
 * @date 2018-4-24 Time：上午12:01:35
 * @author—Email liujunfirst@outlook.com
 * @description  写段代码，定义一个字符串常量，字符串中只有大小写字母和整数，
 * 输出字符串中的出现最多的数字的和？
 * 例如 ” 9fil3dj11P0jAsf11j ” 中出现最多的是11两次，输出22.
 */
//统计字符串中出现最多数之和
public class StatisticsSumofNum {

    /*需掌握：
     * 1.三种正则表达式
     * 2.字符串常量的比较方法
     * 3.hashmap 和 stream 的用法
     */
    public int count(String target) {
		String match = "[0-9a-zA-Z]+";
    	if(target ==null || target.length()==0||!target.matches(match)){
    		return 0;
		}
		String[] s1 = target.split("[a-zA-Z]");

		Arrays.stream(s1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        int statistics = 0;
        int num = 0;
        HashMap<String, Integer> count_map = new HashMap<String, Integer>();
        //三种正则表达式
        //String[] s1 = target.split("[\\D]{1,}");
        //String[] s1 = target.split("[^0-9]");
        for (String string : s1) {
            //注意不可用 ==
            if (!(string.equals(" ") || string.equals(""))) {
                if (count_map.containsKey(string)) {
                    //此处会更新map
                    count_map.put(string, count_map.get(string) + 1);
                    //保存最大最小值
                    if (statistics < count_map.get(string)) {
                        statistics = count_map.get(string);
                        num = Integer.parseInt(string);
                    }
                } else {
                    count_map.put(string, 1);
                }
            }
        }
        return statistics * num;
    }
}
