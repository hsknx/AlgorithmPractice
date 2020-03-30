package UnitTest.datastructureTest.sortTest.innerSortTest.innerSortRealizeTest.normalSortTest;

import DataStructure.sort.innerSort.innerSortRealize.normalSort.BucketSort;
import UnitTest.datastructureTest.sortTest.innerSortTest.innerSortRealizeTest.InnerSortRealizeDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-02-11 15:08
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class RadixSortTest extends InnerSortRealizeDemo {

    @Test
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new BucketSort());
    }
}
