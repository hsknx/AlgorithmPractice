package DataStructure.string.sequenceApply;

import DataStructure.string.StringCompare;

import java.util.ArrayList;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-10-28 09:03
 * @author��Email: liujunfirst@outlook.com
 * @description: �� Դ������ ���Ƿ��� Ŀ�괮�� ����
 */
public class PokeString implements StringCompare {

    @Override
    public boolean compare(String source, String target) {
        return check(source, target) ? StringCompareComponent(source, target) : false;
    }

    public boolean compare(String source, String[] targetstring) {
        for (String s : targetstring) {
            if (check(source, s) && StringCompareComponent(source, s)) {
                return false;
            }
        }
        return true;
    }

    public boolean StringCompareComponent(String source, String target) {

        ArrayList<Integer>[] targetList = stringPreDeal(source);
        int source_point = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (targetList[c] == null) {
                return false;
            }
            //targetList_Position��targetList�е�λ�ã�����Դ��������ߵ�λ��
            int targetList_Position = getLeftBound(targetList[c], source_point);
            //����Խ�磬���������ֵ
            if (targetList_Position == targetList[c].size()) {
                return false;
            }
            //��ȡԴ���е�����ߵ�λ��
            source_point = targetList[c].get(targetList_Position) + 1;
        }
        return true;
    }

    //Ŀ�괮Ԥ����
    public ArrayList[] stringPreDeal(String pattern) {
        //��Ϊasc�ַ�����128��
        ArrayList<Integer>[] targetList = new ArrayList[128];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (targetList[c] == null) {//�ַ� c �Զ�ת��������
                targetList[c] = new ArrayList<>();
            }
            targetList[c].add(i);
        }
        return targetList;
    }

    //get left bound
    public int getLeftBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        while (left <= right) { //====
            mid = (left + right) / 2;
            if (target == list.get(mid)) {
                return mid;
            } else if (target < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}