package DataStructure.string.sequenceApply;

import DataStructure.string.StringCompare;
import java.util.ArrayList;

/**
 * @author liujun
 * @version 1.0
 * @date： 2019-10-28 09:03
 * @author—Email: liujunfirst@outlook.com
 * @description: 在 源串序列 中是否含有 目标串的 序列
 */
public class PokeString implements StringCompare {

    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? StringCompareComponent(source, target) : false;
    }




    public boolean compare( String source, String[] targetstring){

        for (String s : targetstring) {
            if(StringCompareComponent(source, s)){
                return false;
            }
        }
        return true;
    }


    public boolean StringCompareComponent(String source, String target){

        ArrayList<Integer>[] targetList =stringPreDeal(source);
        int stringpoint = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if(targetList[c] ==null){
                return false;
            }
            int targetListPosition = getLeftBound(targetList[c], stringpoint);
            if(targetListPosition == targetList[c].size()){
                return false;
            }
            stringpoint = targetList[c].get(targetListPosition) + 1;
        }
        return true;
    }

    //目标串预处理
    public ArrayList[] stringPreDeal(String pattern){
        //因为asc字符共有128个
        ArrayList<Integer>[] targetList = new ArrayList[128];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(targetList[c] == null){//字符 c 自动转换成数字
                targetList[c] = new ArrayList<>();
            }
            targetList[c].add(i);
        }
        return targetList;
    }

    //get left bound
    public int getLeftBound(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size() - 1;
        int mid;
        while (left <= right){ //====
            mid = (left + right) / 2;
            if(target == list.get(mid)){
                return mid;
            }else if(target < list.get(mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
