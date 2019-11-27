package Algorithm.dynamic.dynamicPrimary.lss;
/** 
 *@author liujun
 *@date： 2018-7-20 下午02:08:03
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description: 已知数组A[1..n]中存放着一些实数，有正有负，
 *请写程序找出其最大求和子区间
 *@version 1.0
 */
//最大子段和:LargestSumofSubSequence
public class LSSopt {

	//输入序列数组，输出最大子段和、起始地址、结束地址
	public int LargestSumofSubSequence(int [] Sequence){
		
		int begin = 0;      //最大字段和的起始地址
		int begin_temp = 0; //假设的最大值
		int end = 0;        //最大字段和的结束地址
		int sum_temp = 0;   //暂时的最大值
		int sum = 0;        //记录最大值

        if(Sequence == null || Sequence.length == 0){
            return 0;
        }

		for(int i = 0; i < Sequence.length; i++){
			sum_temp += Sequence[i];
			if(sum < sum_temp){
				sum = sum_temp;   //记录最大值
				begin = begin_temp; //假定的起始地址赋值给起始地址
				end = i; //结束地址包括 i
			}
			if(sum_temp <= Sequence[i]){
				sum_temp = 0;      //sum清空
				begin_temp = i+1;   //假定的起始位置
			}
		}
		System.out.println("子序列最大值："+sum+" \n"+"子序列起始位置："
				+(begin+1)+" \n"+"子序列结束位置："+(end+1));
		return sum;
	}
}
