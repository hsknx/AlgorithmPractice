package graphApply;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/** 
 *@author liujun
 *@date�� 2018-9-10 ����12:23:06
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:����һ�Ű���N���㡢M���ߵ�����ͼ��ÿ��������������ͬ�ĵ㣬��������������ֻ��һ���ߡ�
 *���������ļ�����ͼ������ܽ����е㻮�ֳ����ɸ����ϣ�ʹ����������ͬһ�����ڵĵ�֮��û�б�������
 *����������ͬ�����ڵĵ�֮���б���������Ƹ�ͼΪ��ȫ�ಿͼ����������Ҫ�жϸ�����ͼ�Ƿ�Ϊ��ȫ�ಿͼ��
 *@version 1.0
 */
public class CompleteMultipartiteGraph {

public static int count = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().trim();
		int zhu = Integer.parseInt(s);
		CompleteMultipartiteGraph m = new CompleteMultipartiteGraph();
		
		for (int i = 0; i < zhu; i++) {
			
			s = scan.nextLine().trim();
			int point = Integer.parseInt(s.split(" ")[0]);
			int bian = Integer.parseInt(s.split(" ")[1]);
			int[][] matrix = new int[point + 1][point + 1];
			
			for (int j = 0; j < bian; j++) {
				s = scan.nextLine().trim();
				int x = Integer.parseInt(s.split(" ")[0]);
				int y = Integer.parseInt(s.split(" ")[1]);
				matrix[x][y] = 1;
				matrix[y][x] = 1;
			}
			
			if (m.judge(matrix)) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		
	}
	
	//�ҳ�ȫ�����ĵ�
	private Map<Integer, Integer> find(int[][] matrix) {
		// TODO Auto-generated method stub

		int flag = 1;
		//ʹ��map���ȫ�����ĵ�
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//��Ϊ�����1��ʼ�洢�����Դ�1��ʼ����
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				//Ĭ��������飬����������
				if (j != i && matrix[i][j] != 1 ) {
					break;
				}
				flag++;
			}
			if (flag == matrix[0].length) {
				map.put(i, 1);
			}
			//flag��ѭ��ʱӦ�ñ�����
			flag = 1;
		}
		
		return map;
	}
	
	//�ж�ʣ��Ԫ���Ƿ���ڹ���
	private boolean judge(int[][] matrix) {

		CompleteMultipartiteGraph m = new CompleteMultipartiteGraph();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map = m.find(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			if (!map.containsKey(i)) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (!map.containsKey(j)) {
						if (matrix[i][j] != 0 ) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
