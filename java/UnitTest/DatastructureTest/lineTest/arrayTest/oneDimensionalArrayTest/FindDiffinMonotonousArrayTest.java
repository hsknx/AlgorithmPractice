package UnitTest.datastructureTest.lineTest.arrayTest.oneDimensionalArrayTest;

import DataStructure.line.array.oneDimensionalArray.FindDiffinMonotonousArray;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-01-08 14:03
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class FindDiffinMonotonousArrayTest {

    FindDiffinMonotonousArray findDiffinMonotonousArray = new FindDiffinMonotonousArray();

    @Test
    public void testfind(){
        int count = findDiffinMonotonousArray.find(Demo01);
        assert count == 9;
        count = findDiffinMonotonousArray.find(Demo02);
        assert count == 9;
        count = findDiffinMonotonousArray.find(Demo03);
        assert count == 7;
    }

    int[] Demo01 = {1,2,3,4,5,6,7,8,9,7,6,3,1};
    int[] Demo02 = {1,2,3,4,5,6,7,8,9};
    int[] Demo03 = {9,8,7,6,4,3,1};
}
