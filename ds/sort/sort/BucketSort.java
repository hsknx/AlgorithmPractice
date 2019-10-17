package sort;

/** 
 *@author liujun
 *@date： 2018-8-22 下午05:03:35
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:桶排序
 *数据结构采用数组加链表
 *@version 1.0
 */
public class BucketSort {

	//散列表
	class Hashtable{
		int value;
		Hashtable next;
		
		public Hashtable() {
			// TODO Auto-generated constructor stub
			this.value = Integer.MIN_VALUE;
			next = null;
		}
		public Hashtable(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			next = null;
		}
	}
	
	public int[] bucketSort(int[] array) {

		//默认桶大小，即链表长度
		int defaultBucketSize = 10;
		return bucketsort(array, defaultBucketSize);
	}
	
	public int[] bucketsort(int[] array, int bucketsize) {

		//安全性检测
		if(array.length == 0){
			return array;
		}
		//创建桶
		Hashtable[] hashtable = new Hashtable[bucketsize];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new Hashtable();
		}
		//找出最大最小值(设置array[0]存最大值，array[1]存最小值)，并确定桶的间距
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(max < array[i]){
				max = array[i];
			}
			if(min > array[i]){
				min = array[i];
			}
		}
		//桶的间距加1是为了向上取整
		int bucketgap = (max - min) / bucketsize + 1;
		
		//哈希数据（哈希之后使用插入排序，对桶内进行排序）
		for (int i : array) {
			int head = (i - min) / bucketgap;
			//桶内插入排序
				//新建节点
			Hashtable point = new Hashtable(i);
				//插入链表
			if(Integer.MIN_VALUE == hashtable[head].value){
				hashtable[head] = point;
			}else{
				Hashtable p = hashtable[head];
				while (p.next != null && p.next.value > point.value) {
					p = p.next;
				}
				point.next = p.next;
				p.next = point;
			}
		}
	    //整理为数组并返回
		int count = 0;
		for (int i = 0; i < hashtable.length; i++) {
			Hashtable p = hashtable[i];
			while (p != null && p.value != Integer.MIN_VALUE) {
				array[count] = p.value;
				p = p.next;
				count++;
			}
		}
		return array;
	}
	
}
