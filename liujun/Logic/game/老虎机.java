package Logic.game;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/** 
 *@author liujun
 *@date： 2019-3-7 下午01:45:09
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@URL:
 *@version 1.0
 */
public class 老虎机 {
	
	static Scanner scan = new Scanner(System.in);
	static int[] score = new int[8];
	static int money;
	static Random random = new Random();
	static String[] palyname = {"天福","双七","双星","西瓜","铃铛","芒果","橘子","苹果",};
	static int lastMoney = 0;
	static boolean flag__limitless = false;
	
	static public void putmoney() {
		System.out.println("输入钱的数量：");
		money = Integer.parseInt(scan.nextLine().trim());
		lastMoney = money;
	}
	
	static public void input() {
		while(true){
			System.out.print("              ");
			for(String i : palyname){
				System.out.print(i+"   ");
			}
			System.out.println();
			System.out.print("输入分数：");
			String s = scan.nextLine();
			
			//如果是回车，则继续上一局输入的分数
			if(s.trim().equals("")){
				for(int y :score){
					money -= y;
				}
			}else if(s.trim().equals("M")){
						score =new int[]{99,99,99,99,99,99,99,99};
						for(int y :score){
							money -= y;
						}
					}else{
						score = new int[8];
						Check(s);
					}
			System.out.println("余额："+money);
			if(money < 0){
				System.out.println("余额不足,仅剩：" + lastMoney);
				return;
			}
			chance();
			System.out.println("剩余总金币数量："+money);
			lastMoney = money;
			System.out.println();
		}
	}
	
	//上限检测
	static private void Check(String s) {
		
		String[] c = s.split(" ");
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			//去除非数字
			c[i].trim();
			if(!c[i].equals("")){
				score[count] = Integer.parseInt(c[i]);
				//每个分数不能超过99,超过部分取99
				if(score[count] > 99 && !flag__limitless){
					score[count] = 99;
				}
				//扣钱
				money -= score[count];
				//超过8个，截断
				count++;
				if(count == 8){
					break;
				}
			}
		}
	}
	
	static TreeMap<String, Integer> tr = new TreeMap<String, Integer>();
	//概率程序
	static private void chance() {
		new Chance();
		int index = random.nextInt(Chance.totalNum+1);
		/*for (int i = 0; i < 5; i++) {
			index = random.nextInt(Chance.totalNum+1);
		}*/
		int i = Chance.produceChance(index);
		
		/*if(tr.containsKey(Chance.name[i])){
			tr.put(Chance.name[i], tr.get(Chance.name[i])+1);
		}else{
			tr.put(Chance.name[i], 1);
		}*/
		
		System.out.println("您中的是："+Chance.name[i]);
		if(i <= 16){//小苹果分界线
			System.out.println("本次获得奖金： "+judge_norma(i));
		}else{
			int ihj = judge_special(i);
			System.out.println("本次共获得奖金： "+ihj);
			money+=ihj;
		}
	}
	
	//中奖判断  普通奖
	static private int judge_norma(int i) {

		if(Chance.name[i].contains("苹果")){
			money += score[7]*Chance.nameChance[i];
			return score[7]*Chance.nameChance[i];
		}
		String s1 = Chance.name[i].substring(Chance.name[i].length()-1);
		for (int j = 0; j < palyname.length; j++) {
			if(palyname[j].contains(s1)){
				money += score[j]*Chance.nameChance[i];
				return score[j]*Chance.nameChance[i];
			}
		}
		return 0;
	}
	
	//中奖判断  爆炸奖
	static private int judge_special(int i) {
		int sum = 0;
		int temp = 0;
		switch (i) {
			case 20://"大三元",
				return (score[1]+score[2]+score[3])*20;
			case 21://"小三元",
				return (score[4]+score[5]+score[6])*10;
			case 22://"四小福",
				return (score[7])*4*5;
			case 17://"满堂彩",
				return    score[0]*175+
						 (score[1]+score[2]+score[3])*20+
						 (score[1]+score[2]+score[3])*2*3+
						 (score[4]+score[5]+score[6])*2*10+
						 (score[4]+score[5]+score[6])*2*3+
					     (score[7])*4*5;
			case 18://"半边红",
				return   score[0]*80+
				 		(score[1]+score[2]+score[3])*10+
				 		(score[1]+score[2]+score[3])*3+
				 		(score[4]+score[5]+score[6])*10+
				 		(score[4]+score[5]+score[6])*3+
				 		(score[7])*2*5;
			case 19://"纵横四海",
				return score[0]*40+
		 				(score[1]+score[2]+score[3])*5+
		 				(score[4]+score[5]+score[6])*5+
		 				(score[7])*5;
			case 23://"彩金翻倍",
				int e = random.nextInt(6)+1;
				if(e>=5){
					e = random.nextInt(6)+1;
				}
				if(random.nextInt(10)==9){
					e=10;
				}
				if(random.nextInt(20)==19){
					e=20;
				}
				System.out.println("翻倍："+e+"倍");
				for(int t : score){
					sum += e * t;
					System.out.print(e*t+" ");
				}
				return sum;
			case 24://"开火车"
				int f = switchnum(random.nextInt(29));
				if(f == 0){
					System.out.println("开火车失效！！！");
					break;
				}
				for(int d=0;d<f;d++){
					int k = random.nextInt(14)+3;
					temp = judge_norma(k);
					sum += temp;
					System.out.print("开火车包括："+Chance.name[k]+"    奖金："+temp);
					System.out.println();
				}
				return sum;	
			case 25://"随机炸"
				if(random.nextInt(8) <= 3){
					System.out.println("随机炸失效！！！");
					break;
				}
				int k = random.nextInt(7)+1;
				if(k <= 3){
					k = random.nextInt(7)+1;
				}
				if(k <= 3){
					k = random.nextInt(7)+1;
				}
				System.out.print("随机炸中：大"+palyname[k]+"    奖金："+score[k]*Chance.nameChanceOrigin[k]);
				System.out.println();
				return score[k]*Chance.nameChanceOrigin[k];
			default:
				break;
		}
		return 0;
	}

	static private int switchnum(int key) {
		switch (key) {
		case 0:
		case 1:
		case 2:
		case 3:
			return 1;
		case 4:
		case 5:
		case 6:
			return 2;
		case 7:
		case 8:
		case 9:
			return 3;
		case 10:
		case 11:
			return 4;
		case 12:
		case 13:
			return 5;
		case 14:
			return 6;
		case 17:
			return 7;
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		putmoney();
		input();
		
		/*for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10780; j++) {
				chance();
			}
			System.out.println(tr.toString());
			tr.clear();
		}*/
	}
}
