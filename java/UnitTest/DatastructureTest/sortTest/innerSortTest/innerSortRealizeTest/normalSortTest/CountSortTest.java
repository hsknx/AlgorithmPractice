package UnitTest.DatastructureTest.sortTest.innerSortTest.innerSortRealizeTest.normalSortTest;

import DataStructure.sort.innerSort.innerSortRealize.normalSort.BucketSort;
import UnitTest.DatastructureTest.sortTest.innerSortTest.innerSortRealizeTest.InnerSortRealizeDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-02-11 15:08
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class CountSortTest extends InnerSortRealizeDemo {

    @Test
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new BucketSort());
    }
}
