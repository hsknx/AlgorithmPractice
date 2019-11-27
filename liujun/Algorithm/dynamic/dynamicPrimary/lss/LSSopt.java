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
public class LSSopt {

	//�����������飬�������Ӷκ͡���ʼ��ַ��������ַ
	public int LargestSumofSubSequence(int [] Sequence){
		
		int begin = 0;      //����ֶκ͵���ʼ��ַ
		int begin_temp = 0; //��������ֵ
		int end = 0;        //����ֶκ͵Ľ�����ַ
		int sum_temp = 0;   //��ʱ�����ֵ
		int sum = 0;        //��¼���ֵ

        if(Sequence == null || Sequence.length == 0){
            return 0;
        }

		for(int i = 0; i < Sequence.length; i++){
			sum_temp += Sequence[i];
			if(sum < sum_temp){
				sum = sum_temp;   //��¼���ֵ
				begin = begin_temp; //�ٶ�����ʼ��ַ��ֵ����ʼ��ַ
				end = i; //������ַ���� i
			}
			if(sum_temp <= Sequence[i]){
				sum_temp = 0;      //sum���
				begin_temp = i+1;   //�ٶ�����ʼλ��
			}
		}
		System.out.println("���������ֵ��"+sum+" \n"+"��������ʼλ�ã�"
				+(begin+1)+" \n"+"�����н���λ�ã�"+(end+1));
		return sum;
	}
}
