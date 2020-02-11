package UnitTest.datastructureTest.sortTest.innerSortTest.innerSortRealizeTest.simpleSortTest;

import DataStructure.sort.innerSort.innerSortRealize.normalSort.BucketSort;
import UnitTest.datastructureTest.sortTest.innerSortTest.innerSortRealizeTest.InnerSortRealizeDemo;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-02-11 15:12
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class InsertSortTest extends InnerSortRealizeDemo {

    @Test
    public void TestInnerSortRealize(){
        super.TestInnerSortRealize(new BucketSort());
    }
}
