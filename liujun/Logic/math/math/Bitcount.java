package math;
/** 
 *@author liujun
 *@date�� 2018-9-3 ����06:59:34
 *@author��Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *  1)��ȡ������������1λ������
 *  2)��ȡ�����Ʋ�����1λ������
 *@version 1.0
 */
public class Bitcount {

	//��ȡ������������1λ�����������Ʒ�
	public void byteCountMethod1(int num) {
		// TODO Auto-generated method stub
		int count = 0;
		while (num > 0) {
			if ((num & 1) != 0) {
				count++;
			}
			//�޷������ƣ������¸�ֵ
			num >>= 1;
		}
		System.out.println(count);
	}
	//ĩβ1ȡ����������
	public void byteCountMethod2(int num) {

		int count = 0;
		while (num > 0) {
			num &= (num - 1);
			count++;
		}
		System.out.println(count);
	}
	
	//���������
	public void byteCountMethod3(int num) {

		// �о���0��15 �ı�   
	    int[] countTable = {  
	        0,1,1,2,  
	        1,2,2,3,  
	        1,2,2,3,  
	        2,3,3,4  
	    };    
	    if( num > Integer.MAX_VALUE && num < 0 ){  
	        System.out.println(-1); 
	    }  
	    System.out.println(countTable[num]);
	}
	
	//JDK�Դ������ֽ�ͳ�ƹ��ߣ����������͸���
	public void byteCountMethod4(int num) {
		// TODO Auto-generated method stub

		System.out.println(Integer.bitCount(num));
	}
	
	//��ȡ�����Ʋ�����1λ�������������ϲ���
	public void byteCountComplementMethod1(int i) {
		// TODO Auto-generated method stub

		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		//0x3f����Ϊ32�ֽڣ����32��1��ʹ��&�Ļ����õ�7λ��
		System.out.println(i & 0x3f);
	}
	
	public int byteCountComplementMethod11(int i) {

		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		//0x3f����Ϊ32�ֽڣ����32��1��ʹ��&�Ļ����õ�7λ��
		return i & 0x3f;
	}
	
	//��ȡ�����Ʋ�����1λ��������ĩβ1ȡ����
	private void byteCountComplementMethod2(int num) {

		int count = 0; 
        while(num != 0){ 
            count++;
            num = num & (num - 1);
         } 
        System.out.println(count); 
	}
	
	//���Ʒ���������Ҫʹ�����ƣ���Ϊ�з���λ
	public void byteCountComplementMethod3(int num) {

		int count = 0; 
        while(num != 0){ 
            count++;
            num <<= 1;
         }
        System.out.println(count); 
	}
	
	//����������
	public static void main(String[] args) {
		
		//-1��������λ��һ��32��1
		int i = -1;
		Bitcount bc = new Bitcount();
		//bc.byteCountMethod1(i);
		bc.byteCountComplementMethod1(i);
		bc.byteCountComplementMethod2(i);
		bc.byteCountComplementMethod3(i);
	}
}
