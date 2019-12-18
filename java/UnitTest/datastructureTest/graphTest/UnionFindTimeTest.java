package UnitTest.datastructureTest.graphTest;

import DataStructure.graph.UnionFind;
import DataStructure.graph.UnionFindOpt;
import org.junit.Test;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-12-18 23:27
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class UnionFindTimeTest {

    UnionFind unionFind;
    UnionFindOpt unionFindOpt;

    @Test
    public void dd(){
        for (int i = 0; i < 10; i++) {
            TestTimeUnionFind();
            System.out.println();
        }
        assert true;
    }

    public void TestTimeUnionFind(){
        int num = 1000000;
        unionFind = new UnionFind(num);
        unionFindOpt = new UnionFindOpt(num);

        long timeBegin = System.nanoTime();
        for (int i = 0; i <= num - 3; i++) {
            unionFind.union(i, i + 2);
            unionFind.union(i + 1, i + 3);
            i += 1;
        }
        assert unionFind.count() == 2;
        num /= 2;
        assert unionFind.connected(num/2, num/2+2);
        assert unionFind.connected(num/2+1, num/2+3);
        assert !unionFind.connected(num/2, num/2+1);
        long timecount = System.nanoTime() - timeBegin;

        num = 1000000;
        timeBegin = System.nanoTime();
        for (int i = 0; i <= num - 3; i++) {
            unionFindOpt.union(i, i + 2);
            unionFindOpt.union(i + 1, i + 3);
            i += 1;
        }
        assert unionFindOpt.count() == 2;
        num /= 2;
        assert unionFindOpt.connected(num/2, num/2+2);
        assert unionFindOpt.connected(num/2+1, num/2+3);
        assert !unionFindOpt.connected(num/2, num/2+1);
        long timecount1 = System.nanoTime() - timeBegin;

        System.out.println("unionFind:   "+timecount);
        System.out.println("unionFindOpt:"+timecount1);
        System.out.println(timecount1 < timecount);
    }
}
