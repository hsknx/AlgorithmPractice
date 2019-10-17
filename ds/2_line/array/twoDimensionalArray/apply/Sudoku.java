
import java.util.Scanner;

import balanceBinaryTree.redBlackTree.realize.RedBlackTree;
import math.Bitcount;

/** 
 *@author liujun
 *@date�� 2018-9-3 ����08:19:20
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class Sudoku {

	SudokuNode[][] suduNum;
	int testValue = 0;
	int movePoint = 1;
	int[] arr = {1,2,4,8,16,32,64,128,256};
	RedBlackTree rbt = new RedBlackTree();
	Bitcount bc = new Bitcount();
	
	public Sudoku(int row, int column) {
		rbt = rbt.add(arr);
		input(row, column);
		while(!sudokuStillHaveEmpty(suduNum)){
			checkSudu(suduNum);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if(suduNum[i][j].value == 0){
						full(i,j);
						if(rbt.containsKey(testValue)){
							suduNum[i][j].value = rbt.get(testValue);
							backStep(i, j, testValue);
						}else{
							suduNum[i][j].tempValue = testValue;
						}
						testValue = 0;
					}
				}
			}
			System.out.println("wait==============");
		}
		print();
	}
	
	public boolean sudokuStillHaveEmpty(SudokuNode[][] suduNum) {

		for (int i = 0; i < suduNum.length; i++) {
			for (int j = 0; j < suduNum[0].length; j++) {
				if(suduNum[i][j].value == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	//����i,j�ո�Ŀ���ֵ
	public void full(int rowi, int columnj) {
		DetectionRow(rowi);
		DetectionColumn(columnj);
		DetectionBox(rowi, columnj);
		testValue ^= 511;
	}
	
	//����п���ֵ
	public void DetectionRow(int rowi){
		for (int i = 0; i < suduNum[0].length; i++) {
			if(suduNum[rowi][i].value != 0){
				movePoint <<= suduNum[rowi][i].value - 1;
				testValue |= movePoint;
				movePoint = 1;
			}
		}
	}
	//����п���ֵ
	public void DetectionColumn(int columnj){
		for (int i = 0; i < suduNum.length; i++) {
			if(suduNum[i][columnj].value != 0){
				movePoint <<= suduNum[i][columnj].value - 1;
				testValue |= movePoint;
				movePoint = 1;
			}
		}
	}
	//���Ź������ֵ
	public void DetectionBox(int rowi, int columnj){
		int rowTemp = rowi / 3;
		int columnTemp = columnj / 3;
		rowTemp *= 3;
		columnTemp *= 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(suduNum[rowTemp + i][columnTemp + j].value != 0){
					movePoint <<= suduNum[rowTemp + i][columnTemp + j].value - 1;
					testValue |= movePoint;
					movePoint = 1;
				}
			}
		}
	}
	
	public void checkSudu(SudokuNode[][] suduNum) {

		for (int i = 0; i < suduNum.length; i++) {
			for (int j = 0; j < suduNum[0].length; j++) {
				if(bc.byteCountComplementMethod11(suduNum[i][j].tempValue) == 2){
					int k = 1;
					while((suduNum[i][j].tempValue & k) == 0){
						k <<= 1;
					}
					suduNum[i][j].value = rbt.get(k);
					suduNum[i][j].tempValue = 0;
					backStep(i, j, suduNum[i][j].value);
				}
			}
		}
	}
	
	public void setValue(int rowi, int columnj, SudokuNode valueNode){
		if(rbt.containsKey(valueNode.tempValue)){
			valueNode.value = valueNode.tempValue;
			backStep(rowi, columnj, valueNode.value);
		}
	}
	
	//����i,j�ո�ֵ������ơ���������λ�õĿ���ֵ
	public void backStep(int rowi, int columnj, int temp) {
		//��ֵ����
		for (int i = 0; i < suduNum.length; i++) {
			if(suduNum[i][columnj].value == 0 || (suduNum[i][columnj].tempValue & temp) != 0){
				suduNum[i][columnj].tempValue ^= temp;
				setValue(i, columnj, suduNum[i][columnj]);
			}
		}
		//��ֵ����
		for (int j = 0; j < suduNum[0].length; j++) {
			if(suduNum[rowi][j].value == 0 || (suduNum[rowi][j].tempValue & temp) != 0){
				suduNum[rowi][j].tempValue ^= temp;
				setValue(rowi, j, suduNum[rowi][j]);
			}
		}
		//�Ź������
		int rowTemp = rowi / 3;
		int columnTemp = columnj / 3;
		rowTemp *= 3;
		columnTemp *= 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(suduNum[rowTemp + i][columnTemp + j].value != 0 && (suduNum[rowTemp + i][columnTemp + j].tempValue & temp) != 0){
					suduNum[rowTemp + i][columnTemp + j].tempValue ^= temp;
					setValue(rowTemp + i, columnTemp + j, suduNum[rowTemp + i][columnTemp + j]);
				}
			}
		}
	}
	
	public SudokuNode[][] input(int row, int column){
		System.out.println("����"+row+"�У�ÿ��"+column+"��Ԫ�أ��ÿո�ֿ�,��Ԫ����0");
		suduNum = new SudokuNode[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				suduNum[i][j] = new SudokuNode();
			}
		}
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			String s = scan.nextLine();
			String[] c = s.trim().split(" ");
			for(int j = 0; j < c.length; j++){
				suduNum[i][j].value = Integer.parseInt(c[j]);
			}
		}
		return suduNum;
	}
	
	public void print(){
		for (int i = 0; i < suduNum.length; i++) {
			for(SudokuNode j : suduNum[i]){
				System.out.print(j.value+" ");
			}
			System.out.println();
		}
	}
	
	//����������
	public static void main(String[] args) {
		
		new Sudoku(3, 3);
	}
}