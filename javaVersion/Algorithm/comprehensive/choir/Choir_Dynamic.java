package Algorithm.comprehensive.choir;

/**
 *@author liujun
 *@date 2018-6-19 ����11:40:18
 *@author��Email liujunfirst@outlook.com
 *@description  �ϳ��� ��̬�滮
 * �� n ��ѧ��վ��һ�ţ�ÿ��ѧ����һ������ֵ��ţţ����� n ��ѧ���а���˳��ѡȡ k ��ѧ����
 *Ҫ����������ѧ����λ�ñ�ŵĲ���� d��ʹ���� k ��ѧ��������ֵ�ĳ˻�������ܷ������ĳ˻���
 *@version 1.0
 */
public class Choir_Dynamic implements Choir {

	@Override
	public int getMaxValue(int[] array, int choseNum, int intervald) {
		return check(array, choseNum, intervald) ? countMaxValue(array, choseNum, intervald) : -1;
	}

	public int countMaxValue(int[] array, int choseNum, int intervald) {

		int arrayLength = array.length;
		//�洢��ֵ�͸�ֵ�Ķ�ά����
		int[][] ValueMax = new int[choseNum][arrayLength];
		int[][] ValueMin = new int[choseNum][arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			for (int j = i; j < arrayLength; j++) {

			}
		}

		return 0;
	}

}
