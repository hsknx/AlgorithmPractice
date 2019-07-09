package string;
/** 
 *@author liujun
 *@date�� 2019-7-8 ����04:57:00
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@CSDN Blog URL:https://blog.csdn.net/ljfirst/article/details/95072616
 *@description:��Ʋ�ʵ��KMP�㷨
 *@version 1.0
 */
public class KMP {

	public int[] getNext(String s) {

		int[] next = new int[s.length()];
		getNext(s, next);
		return next;
	}
	
	//��ȡnext����:Ѱ���ǰ׺
	public void getNext(String s, int[] next) {

		int point = 0;
		int pointmatch = -1;
		next[0] = -1;
		int slength = s.length();
		
		while (point < slength - 1) {
			if(pointmatch == -1 || s.charAt(pointmatch) == s.charAt(point)){
				point++;
				pointmatch++;
				next[point] = pointmatch;
			}else{
				pointmatch = next[pointmatch];
			}
		}
	}
	
	//kmpƥ��
	public boolean kmp(String source, String pattern) {

		//Դ��ָ���Ŀ�Ĵ�ָ��
		int sourcePoint = 0;
		int patternPoint = 0;
		int[] next = getNext(pattern);
		
		while (sourcePoint < source.length() && patternPoint < pattern.length()) {
			if(patternPoint == -1 || source.charAt(sourcePoint) == pattern.charAt(patternPoint)){
				sourcePoint++;
				patternPoint++;
			}else{
				patternPoint = next[patternPoint];
			}
		}
		
		if(patternPoint == pattern.length()){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "dthggvjffvyugbuiyufxewzqaszdxcvbpo";
		String s2 = "ffvyut";
		KMP d = new KMP();
		System.out.println(d.kmp(s1, s2));;
	}
}
