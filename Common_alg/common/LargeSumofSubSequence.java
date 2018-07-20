package common;
/** 
 *@author liujun
 *@date�� 2018-7-20 ����02:08:03
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:��֪����A[1..n]�д����һЩʵ���������и���
 *��д�����ҳ���������������
 *@version 1.0
 */
public class LargeSumofSubSequence {

	//�����������飬�������Ӷκ͡���ʼ��ַ��������ַ
	public LargeSumofSubSequence(int [] Sequence){
		
		int begin = 0;      //����ֶκ͵���ʼ��ַ
		int temp_begin = 0; //��������ֵ
		int end = 0;        //����ֶκ͵Ľ�����ַ
		int temp_best = 0;  //��ʱ�����ֵ
		int best = 0;       //��¼���ֵ

		for(int i = 0; i < Sequence.length; i++){
			temp_best += Sequence[i];
			if(best < temp_best){
				best = temp_best;   //��¼���ֵ
				begin = temp_begin; //�ٶ�����ʼ��ַ��ֵ����ʼ��ַ
				end = i;
			}
			if(temp_best <= 0){
				temp_best = 0;      //sum���
				temp_begin = i+1;   //�ٶ�����ʼλ��
			}
		}
		System.out.println("���������ֵ��"+best+" \n"+"��������ʼλ�ã�"
				+(begin+1)+" \n"+"�����н���λ�ã�"+(end+1));
	}
	
	public static void main(String[] args) {
		
		int A[]={27,-49,1,3,-6,8,12,-5,-6,78,2,-6,-2,15,47,
				1,5,-69,52,5,51,-48,1,56,-19,-8,48,15};
		int B[]={-1,-2,-3,4,5,6,7,8,9,-10,-11,-12};
		
		new LargeSumofSubSequence(B);
	}
}
