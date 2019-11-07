package Algorithm.combine.palindrome;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-11-07 22:42
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class FindPalindrome {

    public String findStringViolence(String source){

        CreatePalindromebyAdd createPalindromebyAdd = new CreatePalindromebyAdd();
        if(source == null || source.length() == 0){
            return null;
        }
        if(source.length() == 1){
            return source;
        }
        String target = "";
        String pattern = null;
        int length = source.length();
        for (int i = 0; i < length; i++) {
            //��Ϊsubstring(i,j)��ȡ��Χ�ǰ뿪����[i,j),
            for (int j = i + 2; j <= length; j++) {
                pattern = source.substring(i,j);
                boolean flag = createPalindromebyAdd.PalindromeJudge(pattern);
                if(flag && pattern.length() > target.length()){
                    target = pattern;
                }
            }
        }
        return target.length() > 0 ?  target : null;
    }

    public String findString(String source){

        if(source == null || source.length() == 0){
            return null;
        }
        int PalindromeLength = 0;
        int preStringTempLength = 0;
        int PalindromeBegin = 0;
        //��ȡ�ַ���Ԥ������ֵ
        String preString = preDealString(source,'#');
        if(preString != null){
            for (int i = 0; i < preString.length(); i++) {
                preStringTempLength = getPointBound(preString, i);
                PalindromeLength = PalindromeLength > preStringTempLength ? PalindromeLength : preStringTempLength;
                PalindromeBegin = (i - PalindromeLength)/2;
            }
        }
        String targetString = source.substring(PalindromeBegin, PalindromeBegin + PalindromeLength);
        return targetString;
    }

    //�ַ���Ԥ��������λ�ü�#
    public String preDealString(String source, char divideChar){
        //����ַ����Ƿ��зָ���
        if(source.indexOf(divideChar) != -1){
            return null;
        }
        char[] SPchar = source.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            stringBuffer.append(divideChar);
            stringBuffer.append(SPchar[i]);
        }
        stringBuffer.append(SPchar);
        return stringBuffer.toString();
    }

    //��ȡ��pointΪ���ĵĻ����ַ������ȣ�ע��ó����ǵ��߳���
    public int getPointBound(String pattern, int point){

        int length = pattern.length() - 1;
        int leftbound = point - 1;
        int rightbound = point + 1;
        int boundlength = 0;
        while(leftbound >= 0 && rightbound <= length && pattern.charAt(leftbound) == pattern.charAt(rightbound)){
            boundlength++;
            leftbound --;
            rightbound++;
        }
        return boundlength;
    }
}
