package Algorithm.combine.backpack;

/** 
 *@author liujun
 *@date�� 2018-7-19 ����11:55:33
 *@author��Email:liujunfirst@outlook.com
 *@description:
 *1.״̬ת������
 *2.����ҳ���ѡ��Ʒ
 *
 *��չ��
 *1.�Ƿ����������������ݷ�����֧�޽編��̰�ģ�
 *2.Ȼ������ظ�ѡ���أ�
 *@version 1.0
 */
public class Backpack_dynamic {

	public Backpack_dynamic(Integer[] goodsvalue, Integer[] weight, int packageweight) {

		//��ֵ������:��������������:�������Ʒ
		int[][] bestvalue = new int [packageweight + 1][goodsvalue.length + 1];
		
		//���滮,���ѭ����ʾ������������
		for (int i = 1; i <= packageweight; i++) {
			//�ڲ�ѭ��,������Ʒ
			for (int j = 1; j <= goodsvalue.length; j++) {
				
				//�������ֵ�ȱ������������󣬷���
				if(weight[j-1] > i){
					bestvalue[i][j] = bestvalue[i][j - 1];
				}else{
					bestvalue[i][j] = 
						bestvalue[i][j - 1] > bestvalue[i - weight[j - 1]][j - 1] + goodsvalue[j - 1] ? 
							bestvalue[i][j - 1] : bestvalue[i - weight[j - 1]][j - 1] + goodsvalue[j - 1];
				}
			}
		}
		
		//��ӡ����ֵ
		for (int i = 1; i <= packageweight; i++) {
			for (int j = 1; j <= goodsvalue.length; j++){
				if (bestvalue[i][j] < 10) {
					System.out.print(" " + bestvalue[i][j] + " ");
				}else{
					System.out.print(bestvalue[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
		//���ѡ�����Ʒ
		int x[] = new int[goodsvalue.length];
		//����ʵ��װ������
		int real_weight = 0;
		//�ҳ���ѡ��Ʒ
		int i = packageweight;
		int j = x.length;
		
		while(j >= 1 && i >= 1){
			if(bestvalue[i][j] != bestvalue[i][j - 1]){
				x[j - 1] = 1;//װ���i����Ʒ
				i -= weight[j - 1];
				real_weight += weight[j - 1];
				j--;
			}else {
				x[j - 1] = 0;//��װ���i����Ʒ
				j--;
			}
		}
		
		System.out.println("����ʵ��ת������Ϊ��"+real_weight);
		System.out.print("��������ֵΪ��");
		System.out.println(bestvalue[packageweight - 1][goodsvalue.length - 1]);
		System.out.print("����������ƷΪ��");
		
		//���ѡ�����Ʒ
		for(int y = 0;y < x.length; y++){
			if(x[y] != 0){
				System.out.print(y+" ");
			}
		}
	}
}
