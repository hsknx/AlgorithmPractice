package Algorithm.dynamic.dynamicPrimary.lss;
/** 
 *@author liujun
 *@date�� 2018-7-20 ����02:08:03
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description: ��֪����A[1..n]�д����һЩʵ���������и���
 *��д�����ҳ���������������
 *@version 1.0
 */
//����Ӷκ�:LargestSumofSubSequence
public class LSS {

	//�����������飬�������Ӷκ͡���ʼ��ַ��������ַ
	public int LargestSumofSubSequence(int [] Sequence){
		
		int begin = 0;      //����ֶκ͵���ʼ��ַ
		int temp_begin = 0; //��������ֵ
		int end = 0;        //����ֶκ͵Ľ�����ַ
		int temp_sum = 0;  //��ʱ�����ֵ
		int sum = 0;       //��¼���ֵ

		for(int i = 0; i < Sequence.length; i++){
			temp_sum += Sequence[i];
			if(sum < temp_sum){
				sum = temp_sum;   //��¼���ֵ
				begin = temp_begin; //�ٶ�����ʼ��ַ��ֵ����ʼ��ַ
				end = i;
			}
			if(temp_sum <= 0){
				temp_sum = 0;      //sum���
				temp_begin = i+1;   //�ٶ�����ʼλ��
			}
		}
		System.out.println("���������ֵ��"+sum+" \n"+"��������ʼλ�ã�"
				+(begin+1)+" \n"+"�����н���λ�ã�"+(end+1));
		return sum;
	}
}
