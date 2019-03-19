package games;
/** 
 *@author liujun
 *@date： 2019-3-7 下午05:23:40
 *@author—Email:ljfirst@mail.ustc.edu.cn
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
	    "大天福","小天福","小小天福",  //0-16         
		"大双七","大双星","大西瓜",                     
		"大铃铛","大芒果","大橘子",                     
		"小双七","小双星","小西瓜",
		"小铃铛","小芒果","小橘子",
		"大苹果","小苹果",          //15-16                
		
	    "满堂彩","半边红","纵横四海",  //17-19           
	    "大三元","小三元","四小福",                
		"彩金翻倍","开火车","随机炸"   //23-25           
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
		//"大天福","小天福","小小天福",
		0,2,4,          
		//"大双七","大双星","大西瓜",
		10,10,10,
		//"大铃铛","大芒果","大橘子",
		20,20,20,
		//"小双七","小双星","小西瓜",
	    150,150,150,    
	    //"小铃铛","小芒果","小橘子",
	    200,200,200, 
	    //"大苹果","小苹果",
	    150,200,
		//"满堂彩","半边红","纵横四海",
	    1,2,4,
	    //"大三元","小三元","四小福",
	    5,10,15,     
	    //"彩金翻倍","开火车","随机炸"
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
