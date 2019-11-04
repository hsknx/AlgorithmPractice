package Algorithm.dynamic.dynamic_apply;

import java.util.Scanner;

/** 
 *@author liujun
 *@date�� 2018-8-2 ����01:36:15
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��ͼ��ĳ��������Աp����Ҫ��a��b��c��d4����ݵ����Ͱ�����
 *��������Ա��Ҫѡ��ʲô��·�ߣ�����������·�̵����͡�������ͼ����Ա���������(0,0)��
 *����·��ֻ������ͼ�еķ������ʻ��ÿ��С���������Σ��ұ߳�Ϊ1����p��d�ľ������4��
 *�������n�����͵����꣬������������·��ֵ������㿪ʼ���n�������Ͳ��ص���ʼ��ľ��룩��
 *@version 1.0
 *����˼·��
 *1)prim˼·:ÿ�ζ���̵�·������������ٸ��¾�����ٸ��ݾ���������·����ֱ�����е����������
 *2)̰���㷨��
 *3)��̬�滮��
 *4)��֧�޽磺
 */
public class �ͻ����·�� {

	//������̾��룺prim˼·
	public int shortPath_greedy(int [] position_row, int [] position_column) {
		// TODO Auto-generated method stub

		//�����ܾ������Сֵ
		int sum = 0;
		int min = Integer.MAX_VALUE;
		//������̾��������
		int [] short_route_value = new int [position_row.length];
		for (int i = 0; i < short_route_value.length; i++) {
			short_route_value[i] = Integer.MAX_VALUE;
		}
		//p������ÿ���¼���Ľ�㣬�������±�
		int p = 0;
		//��һ������Ϊ��㣬��Ϊ-1����ʾ�ѱ�������
		short_route_value[0] = -1;
		for (int i = 1; i < position_column.length; i++) {
			//ÿ�μ�����½��p,����������̾�������顣
			short_route_value = update(p, short_route_value, position_row, position_column);
			
			//���������ҳ���ǰ��Сֵ�ĵ�
			for (int j = 0; j < short_route_value.length; j++) {
				if(short_route_value[j] != -1 && min > short_route_value[j]){
					min = short_route_value[j];
					p = j;
				}
			}
			//����Сֵ��sum���,��ˢ����Сֵ,���õ�ǰ��Сֵ���ѷ���
			sum += min;
			min = Integer.MAX_VALUE;
			short_route_value[p] = -1;
		}
		
		//�����Ϸ���ֵ��������Ǹ���ص����
		sum = sum + position_row[p] + position_column[p];
		return sum;
	}
	
	//��̾�������ĸ��º���
	private int [] update(int p, int [] short_route_value, int [] position_row, int [] position_column) {

		//�������
		int row_value = 0;
		int column_value = 0;
		//int count = 0;
		for (int i = 0; i < position_column.length; i++) {
			//��������δ���ʽ�����
			if(short_route_value[i] != -1){
				//�����ֵ,�˴������ֲ�ͬд��
				column_value = Math.abs(position_column[p] - position_column[i]);
				row_value = position_row[p] - position_row[i] > 0 ? position_row[p] - position_row[i] : position_row[i] - position_row[p];
				//count = column_value + row_value;
				//short_route_value[i] = count < short_route_value[i] ? count : short_route_value[i];
				short_route_value[i] = column_value + row_value;
			}
		}
		return short_route_value;
	}
	
	//��̬�滮
	public void shortPath_dynamic() {
		// TODO Auto-generated method stub

	}
	
	//����������
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�����������");
		int local_num = Integer.parseInt(scan.nextLine());
		
		//��ʼ����������
		int [] position_row = new int[local_num+1];
		int [] position_column = new int[local_num+1];
		//��㶼��0,0
		position_row[0] = 0;
		position_column[0] = 0;
		
		System.out.println("������������ĺ������꣬���Ÿ������س����У�");
		for (int j = 1; j < local_num + 1; j++) {
			String[] locations = scan.nextLine().trim().split(",");
			position_row[j] = Integer.parseInt(locations[0]);
			position_column[j] = Integer.parseInt(locations[1]);
		}
		
		//�������·��
		�ͻ����·�� route = new �ͻ����·��();
		int sum = route.shortPath_greedy(position_row, position_column);
		System.out.println(sum);
	}
}