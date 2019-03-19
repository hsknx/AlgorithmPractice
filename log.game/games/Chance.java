package games;
/** 
 *@author liujun
 *@date�� 2019-3-7 ����05:23:40
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@URL:
 *@version 1.0
 */
public class Chance {
	
	public Chance() {
		producenameBoundy();
		totalNum = nameBoundy[nameBoundy.length - 1];
	}
	
	static String[] name = {
	    "���츣","С�츣","СС�츣",  //0-16         
		"��˫��","��˫��","������",                     
		"������","��â��","������",                     
		"С˫��","С˫��","С����",
		"С����","Сâ��","С����",
		"��ƻ��","Сƻ��",          //15-16                
		
	    "���ò�","��ߺ�","�ݺ��ĺ�",  //17-19           
	    "����Ԫ","С��Ԫ","��С��",                
		"�ʽ𷭱�","����","���ը"   //23-25           
	};
	
	static int[] nameChance = {
	    100,50,25,
	    20,20,20,
	    10,10,10,
	    3,3,3,
	    3,3,3,
		5,3,
		
	    1,1,1,
	    1,1,1,
		1,1,1
	};
	
	static int[] nameBoundy = new int[26];
	
	static int[] nameChanceOrigin = {
	    100,20,20,20,10,10,10,5
	};
	
	static int totalNum = 0;
	
	static int[] gailv = {
		//"���츣","С�츣","СС�츣",
		0,2,4,          
		//"��˫��","��˫��","������",
		10,10,10,
		//"������","��â��","������",
		20,20,20,
		//"С˫��","С˫��","С����",
	    150,150,150,    
	    //"С����","Сâ��","С����",
	    200,200,200, 
	    //"��ƻ��","Сƻ��",
	    150,200,
		//"���ò�","��ߺ�","�ݺ��ĺ�",
	    1,2,4,
	    //"����Ԫ","С��Ԫ","��С��",
	    5,10,15,     
	    //"�ʽ𷭱�","����","���ը"
		20,30,50,
	};
	
	static public void producenameBoundy() {
		for (int i = 1; i < name.length; i++) {
			nameBoundy[i]=nameBoundy[i-1]+gailv[i];
		}
	}
	
	static public void producenameBoundy1() {
		for (int i = 1; i < name.length; i++) {
			nameBoundy[i]=nameBoundy[i-1]+gailv[i];
			System.out.print(name[i]+":  "+nameBoundy[i]+"  ");
		}
	}
	
	static public int produceChance(int index) {
		for (int i = 0; i < nameBoundy.length; i++) {
			if(index <= nameBoundy[i]){
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		new Chance();
		producenameBoundy1();
	}
}
