package DataStructure.sort.innerSort.innerSortRealize.normalSort;

import DataStructure.line.hashTable.hashTableRealize.HashTableNode;
import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

/**
 *@author liujun
 *@date 2018-8-22 下午05:03:35
 *@author—Email liujunfirst@outlook.com
 *@description  桶排序
 *数据结构 采用 数组加链表
 *@version 1.0
 */

public class BucketSort implements SortInterface {

	public int[] sortMethod(int[] array) {
		//默认桶大小，即链表长度
		int defaultBucketSize = 10;
		return bucketsort(array, defaultBucketSize);
	}
	
	public int[] bucketsort(int[] array, int bucketsize) {
		//安全性检测
		if(array.length == 0 || array == null){
			return array;
		}
		//创建桶
		HashTableNode[] hashTableNodes = new HashTableNode[bucketsize];
		for (int i = 0; i < bucketsize; i++) {
			hashTableNodes[i] = new HashTableNode();
		}
		//找出最大最小值(设置array[0]存数组最大值，array[1]存最小值)，并确定桶的间距
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			max = max > array[i] ? max : array[i];
			min = min < array[i] ? min : array[i];
		}
		//桶的间距: 因为除法只保留商的原因，需要加1，向上取整
		int bucketgap = (max - min) / bucketsize + 1;
		
		//哈希数据（哈希之后使用插入排序，对桶内进行排序）
		for (int i : array) {
			int head = (i - min) / bucketgap;
			//桶内插入排序
				//新建节点
			HashTableNode point = new HashTableNode(i);
				//插入链表
			if(Integer.MIN_VALUE == hashTableNodes[head].value){
				hashTableNodes[head] = point;
			}else{
				//链表的插入排序
				HashTableNode pro = hashTableNodes[head];
				HashTableNode p = pro;
				while (p != null && p.value < point.value) {
					pro = p;
					p = p.next;
				}
				if(hashTableNodes[head] == pro && point.value < pro.value){
					point.next = pro;
					hashTableNodes[head] = point;
				}else{
					point.next = pro.next;
					pro.next = point;
				}
			}
		}
	    //整理为数组并返回
		int count = 0;
		for (int i = 0; i < bucketsize; i++) {
			HashTableNode p = hashTableNodes[i];
			while (p != null && p.value != Integer.MIN_VALUE) {
				array[count] = p.value;
				p = p.next;
				count++;
			}
		}
		return array;
	}
}