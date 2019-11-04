package balanceBinaryTree.redBlackTree.apply;

import java.util.HashMap;
import java.util.Scanner;

/**
 *@author liujun
 *@date�� 2018-4-24 Time������12:01:35
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:д�δ��룬����һ���ַ����������ַ�����ֻ�д�Сд��ĸ������������ַ����еĳ���
 *�������ֵĺͣ����� �� 9fil3dj11P0jAsf11j �� �г���������11���Σ����22.
 *@version 1.0
 */
public class ͳ���ַ����������֮�� {

	/*�����գ�
	 * 1.����������ʽ
	 * 2.�ַ��������ıȽϷ���
	 * 3.hashmap�÷�
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer>  count_map = new HashMap<String, Integer>();
		int num = 0;
		int max = 0;
		
		while (scan.hasNext()) {
			String s = scan.next();
			//����������ʽ
			//String[] s1 = s.split("[\\D]{1,}");
			//String[] s1 = s.split("[^0-9]");
			String[] s1 = s.split("[a-zA-Z]");
			for (String string : s1) {
				//ע�ⲻ���� ==
				if(!(string.equals(" ")||string.equals(""))){
					if(count_map.containsKey(string)){
						//�˴������map
						count_map.put(string, count_map.get(string)+1);
						//���������Сֵ
						if (num<count_map.get(string)) {
							num = count_map.get(string);
							max = Integer.parseInt(string);
						}
					}else{
						count_map.put(string, 1);
					}
				}
			}
			System.out.println(max*num);
		}
	}
}
