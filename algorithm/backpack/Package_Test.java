package backpack;
/** 
 *@author liujun
 *@date�� 2018-9-21 ����08:18:31
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class Package_Test {

	public static void main(String[] args) {
		
		//����������
		int packageweight = 40;
		//��Ʒ��ֵ����Ʒ����
		Integer[] goodsvalue = {6,6,1,5,2,1,1,9,4,9,9,5,4,5,2};
		Integer[] weight     = {3,8,3,9,4,6,6,3,9,2,9,8,1,9,7,};
		
		new Backpack_dynamic(goodsvalue, weight, packageweight);
	}
}
