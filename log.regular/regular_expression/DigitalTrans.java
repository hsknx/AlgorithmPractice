package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date�� 2018-5-13 Time������10:31:25
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:trans digital trans to capital
 *method:
 * 1.ȥ�ո�.
   2.�����жϣ� 2.1 ����һ��С����Ͷ�����֣������ַ������ԡ�  
            2.2 ��0��ͷ�Ĳ���ȷ(022,02.2)������0.x
   3.�ֳ�������С�����ִ���.
   4.������С�����ֺϲ���ȥ��.
 *@version 1.0
 */
public class DigitalTrans {

	String[] digital = {"��","Ҽ","��","��","��","��","½","��","��","��"};
	String[] element = {"Ԫ","ʰ","��","Ǫ","��","ʰ��","����","Ǫ��","��"};
	String[] small = {"��","��","��","��"};
	
	public String trans(String num) throws Exception {
		
		//1.ȥ�ո�
		num = num.trim();
		//2.�����жϣ� 2.1 ����һ��С����Ͷ�����֣������ַ������ԡ�  
		//         2.2 ��0��ͷ�Ĳ���ȷ(022,02.2)������0.x
		if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
			throw new Exception("Ǯ����ʽ����");
		}
		//3.�ֳ�������С�����ִ�����Ԥ����
	    String[] deal = num.split("\\.");
	    //�����������ֻ������λ�������ڲ���
	    String wholenum = deal[0];
	    if(deal[0].length() > 9){
	    	int k = deal[0].length() - 9;
	    	wholenum = deal[0].substring(k);
	    }
	    //С���������ֻ����С�������λ�������ڲ���
	    String decimal = deal[1];
	    if(deal[1].length() > 4){
	    	decimal = deal[1].substring(0, 4);
	    }
	    //3.�ֳ�������С�����ִ���������
	    boolean flag = false;
	    StringBuffer sb = new StringBuffer();
	    int index = wholenum.length() - 1;
	    for (int i = 0; i <= wholenum.length() - 1; i++) {
	    	//����0���кͺϲ�����
	    	if(flag && wholenum.charAt(i) == '0'){
				
	    	}else if(wholenum.charAt(i) == '0'){
	    		sb.append("��");
				flag = true;
				}else{
					sb.append(digital[Integer.parseInt(wholenum.charAt(i)+"")]+element[index]);
					flag = false;
				}
			index--;
		}
	    //������������β�����滻��Ԫ
	    if(sb.lastIndexOf("��") == sb.length() - 1){
	    	sb.replace(sb.length() - 1, sb.length(), "Ԫ");
	    }
	    index = 0;
	    flag = false;
	    for (int i = 0; i <= decimal.length() - 1; i++) {
	    	//����0���кͺϲ�����
	    	if(flag && decimal.charAt(i) == '0'){
				
	    	}else if(decimal.charAt(i) == '0'){
	    		sb.append("��");
				flag = true;
				}else{
					sb.append(digital[Integer.parseInt(decimal.charAt(i)+"")]+small[index]);
					flag = false;
				}
			index++;
		}
	    //���С�������β����ֱ��ȥ��
	    if(sb.lastIndexOf("��") == sb.length() - 1){
	    	sb.replace(sb.length() - 1, sb.length(), "");
	    }
		//4.������С�����ֺϲ���ȥ��
		return sb.toString();
	}
	
	public static void main(String[] args) {

		while(true){
			Scanner scan = new Scanner(System.in);
			DigitalTrans dt = new DigitalTrans();
			try {
				System.out.println(dt.trans(scan.next()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
