package stringApply;
/** 
 *@author liujun
 *@date： 2019-8-26 下午07:32:21
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@CSDN Blog URL:
 *@description:Sunday算法是一种比KMP算法更快捷的算法。
 *@version 1.0
 */
public class Sunday {

	public Sunday(String source, String pattern) {
		
		int sourceIndex = 0;
		int patternIndex = 0;
		boolean flag = false;
		while(sourceIndex < source.length()){
			int temp = sourceIndex + pattern.length();
			while (sourceIndex < source.length() && patternIndex < pattern.length()) {
				if(source.charAt(sourceIndex) == pattern.charAt(patternIndex)){
					sourceIndex++;
					patternIndex++;
				}else{
					if(temp < source.length() && pattern.lastIndexOf(source.charAt(temp)) != -1){
						sourceIndex = temp - pattern.lastIndexOf(source.charAt(temp));
					}else{
						sourceIndex = temp +1;
					}
					patternIndex = 0;
					break;
				}
			}
			if(patternIndex == pattern.length()){
				flag = true;
				break;
			}
		}
		if(flag == true){
			System.out.println("right");
		}else{
			System.out.println("error");
		}
	}
	
	public static void main(String[] args) {
		//正案例
		new Sunday("12345ui6789", "ui");
		new Sunday("12345uri67we89", "we");
		new Sunday("123rt45uri6789", "rt");
		new Sunday("12345uri67fghj89", "fghj");
		new Sunday("1212sdr4345uri6789", "12sdr4");
		//反案例
		new Sunday("12uw3wi345uri6789", "uwwi");
		new Sunday("12345uri6u4i789", "ui");
		new Sunday("12u344i345uri6789", "u34i");
		new Sunday("1234f5g365uri6789", "f5g6");
		new Sunday("12345uri67f34g3b5n689", "f34gb5n6");
	}
}
