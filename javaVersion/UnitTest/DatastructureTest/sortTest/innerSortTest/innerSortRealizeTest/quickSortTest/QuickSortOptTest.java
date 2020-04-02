package UnitTest.DatastructureTest.sortTest.innerSortTest.innerSortRealizeTest.quickSortTest;

import DataStructure.sort.innerSort.innerSortRealize.normalSort.BucketSort;
import UnitTest.DatastructureTest.sortTest.innerSortTest.innerSortRealizeTest.InnerSortRealizeDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-02-11 15:09
 * @author¡ªEmail liujunfirst@outlook.com
 * @description 
 * @blogURL
 */
public class QuickSortOptTest extends InnerSortRealizeDemo {

    @Test
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new BucketSort());
    }
}
