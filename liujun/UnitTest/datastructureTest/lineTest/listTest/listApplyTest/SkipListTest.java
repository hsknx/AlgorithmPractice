package UnitTest.datastructureTest.lineTest.listTest.listApplyTest;

import DataStructure.line.list.listApply.SkipList;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-10-18 02:50
 * @author¡ªEmail:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class SkipListTest {

    @Test
    public void testSkipList() {
        SkipList skipList = new SkipList();
        for (int i = 25; i > 0; i--) {
            skipList.add(i);
        }
        System.out.println(skipList.SkipListlevel);
        for (int i = 0; i < 20; i++) {
            skipList.print();
            System.out.println();
        }
        System.out.println(skipList.find(22));
        System.out.println(skipList.find(13));
        System.out.println(skipList.find(102));
    }
}