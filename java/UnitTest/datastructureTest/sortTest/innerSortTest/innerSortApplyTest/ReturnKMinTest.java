package UnitTest.datastructureTest.sortTest.innerSortTest.innerSortApplyTest;

import DataStructure.sort.innerSort.innerSortApply.ReturnKMin;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-11-25 02:48
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class ReturnKMinTest {

    ReturnKMin returnKMin = new ReturnKMin();
    int k = 3;
    int[] target;
    int[] pattern;

    @Test
    public void testkMinHeap(){

        target = null;
        pattern = returnKMin.kMinHeap(test01,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinHeap(test02,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinHeap(test03,k);
        assert Arrays.equals(pattern, target);

        target = new int[]{1,2,3};
        pattern = returnKMin.kMinHeap(test04,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinHeap(test05,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinHeap(test06,k);
        assert Arrays.equals(pattern, target);
    }

    @Test
    public void testkMinQuickSort(){

        target = null;
        pattern = returnKMin.kMinQuickSort(test01,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinQuickSort(test02,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinQuickSort(test03,k);
        assert Arrays.equals(pattern, target);

        target = new int[]{1,2,3};
        pattern = returnKMin.kMinQuickSort(test04,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinQuickSort(test05,k);
        assert Arrays.equals(pattern, target);
        pattern = returnKMin.kMinQuickSort(test06,k);
        assert Arrays.equals(pattern, target);
    }

    //²âÊÔÓÃÀı
    int[] test01 = null;
    int[] test02 = {};
    int[] test03 = {1,2};
    //test04~6,k=3,·µ»Ø{1,2,3}
    int[] test04 = {1,2,3,4,5,6,7,8,9};
    int[] test05 = {58,25,36,2,48,9,12,12,12,6,59,1,36,951,75,26,2,36,45,7,59,45,3,48,62,351,21,39};
    int[] test06 = {58,48,9,2,36,351,21,39,12,25,12,6,59,1,36,36,2,12,45,7,59,45,3,48,62,951,75,26};

}
