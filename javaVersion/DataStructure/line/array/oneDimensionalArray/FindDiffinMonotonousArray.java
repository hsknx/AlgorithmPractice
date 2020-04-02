package DataStructure.line.array.oneDimensionalArray;

/**
 * @author liujun
 * @version 1.0
 * @date 2020-01-08 14:01
 * @author—Email  liujunfirst@outlook.com
 * @description  数组单调递增然后单调递减，输出元素中不同的个数，
 * 要求：数组原址，不能改变数组元素和顺序，空间复杂度：O(1)
 * @blogURL
 */
public class FindDiffinMonotonousArray {

    public int find(int[] array) {

        int count = 0;
        int left = 0;
        int length = array.length - 1;
        int right = length;
        int value = 0;
        int value1 = Integer.MIN_VALUE;

        for (int i = 0; i <= length; i++) {
            if (array[left] < array[right]) {
                value = array[left];
                left++;
            } else {
                value = array[right];
                right--;
            }
            if(value > value1){
                value1 = value;
                count++;
            }
        }
        return count;
    }
}
