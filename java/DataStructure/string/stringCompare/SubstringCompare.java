package DataStructure.string.stringCompare;

import DataStructure.string.StringCompare;

import java.util.ArrayList;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-28 09:03
 * @author��Email: liujunfirst@outlook.com
 * @description: �Ӵ�ƥ��
 */
public class SubstringCompare implements StringCompare {

    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? specialStringCompare(source, target) : false;
    }

    //�Ӵ�ƥ��
    public boolean specialStringCompare(String substring, String string){

        ArrayList<Integer>[] targetList =stringPreDeal(string);
        return StringCompareComponent(targetList, substring);
    }

    //�Ӵ�ƥ��
    public boolean normalStringCompare(String substring, String string){

        int substringlength = 0;
        int stringlength = 0;
        while (stringlength < string.length() && substringlength < substring.length()){
            if(substring.charAt(substringlength) == string.charAt(stringlength)){
                substringlength++;
            }
            stringlength++;
        }
        return substringlength == substring.length();
    }

    public static void main(String[] args) {
        SubstringCompare sc = new SubstringCompare();
        String substring = "20413";
        String string = "12340202411322";
        System.out.println(sc.specialStringCompare(substring,string));
        System.out.println(sc.normalStringCompare(substring,string));
        //test1:�����Ƿ�����󲿷ֲ���ͨ��
        //test2:����ʱ��

    }

    public boolean specialStringCompare(String[] substring, String string){

        ArrayList<Integer>[] targetList =stringPreDeal(string);
        for (String s : substring) {
            if(StringCompareComponent(targetList, s)){
                return false;
            }
        }
        return true;
    }



    public boolean StringCompareComponent(ArrayList<Integer>[] targetList, String substring){

        int stringpoint = 0;
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
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



    //Ŀ�괮Ԥ����
    public ArrayList[] stringPreDeal(String pattern){
        ArrayList<Integer>[] targetList = new ArrayList[128];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(targetList[c] == null){
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
