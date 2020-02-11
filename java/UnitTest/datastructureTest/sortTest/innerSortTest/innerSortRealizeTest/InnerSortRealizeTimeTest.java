package UnitTest.datastructureTest.sortTest.innerSortTest.innerSortRealizeTest;

import DataStructure.sort.innerSort.innerSortRealize.SortInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-11-14 22:01
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class InnerSortRealizeTimeTest {

    int[] arr = new int[]{};
    int[] expected = new int[]{};
    String packagename = "DataStructure.sort.innerSort.innerSortRealize.";
    //normalSort
    String BucketSortName = packagename + "normalSort.BucketSort";
    String CountSortName = packagename + "normalSort.CountSort";
    String MergeSortName = packagename + "normalSort.MergeSort";
    String RadixSortName = packagename + "normalSort.RadixSort";
    //quickSort
    String QuickSortDuplexingName = packagename + "quickSort.QuickSortDuplexing";
    String QuickSortOptName = packagename + "quickSort.QuickSortOpt";
    String QuickSortSimplexName = packagename + "quickSort.QuickSortSimplex";
    //simpleSort
    String BubbleSortName = packagename + "simpleSort.BubbleSort";
    String HeapSortName = packagename + "simpleSort.HeapSort";
    String InsertSortName = packagename + "simpleSort.InsertSort";
    String SelectSortName = packagename + "simpleSort.SelectSort";

    //@Test
    public void TestInnerSortRealizeTimeTest() {
        ArrayList<String> sortlist = new ArrayList<>();

        sortlist.add(BucketSortName);
        sortlist.add(CountSortName);
        sortlist.add(MergeSortName);
        sortlist.add(RadixSortName);

        sortlist.add(QuickSortDuplexingName);
        sortlist.add(QuickSortOptName);
        sortlist.add(QuickSortSimplexName);

        sortlist.add(BubbleSortName);
        sortlist.add(HeapSortName);
        sortlist.add(InsertSortName);
        sortlist.add(SelectSortName);
        for (String s : sortlist) {
            try {
                Class<?> demoClass = Class.forName(s);
                SortInterface demo = (SortInterface) demoClass.getDeclaredConstructor().newInstance();
                arr = new int[]{25, 78, 30, 21, 13, 41, 65, 26, 46, 74, 62, 82, 65, 16, 3, 84, 46, 27, 9, 9, 31, 12, 51, 80, 5, 75, 89, 9, 54, 67, 32, 76, 65, 12, 47, 25, 82, 14, 28, 46, 10, 21, 98, 17, 45, 4, 98, 46, 15, 91, 80, 79, 40, 42, 77, 26, 42, 80, 77, 2, 10, 2, 79, 82, 42, 69, 19, 26, 0, 3, 71, 34, 95, 80, 54, 59, 85, 100, 39, 55, 3, 89, 67, 15, 35, 56, 21, 85, 31, 19, 50, 78, 34, 37, 85, 82, 15, 20, 42, 41};
                expected = new int[]{0, 2, 2, 3, 3, 3, 4, 5, 9, 9, 9, 10, 10, 12, 12, 13, 14, 15, 15, 15, 16, 17, 19, 19, 20, 21, 21, 21, 25, 25, 26, 26, 26, 27, 28, 30, 31, 31, 32, 34, 34, 35, 37, 39, 40, 41, 41, 42, 42, 42, 42, 45, 46, 46, 46, 46, 47, 50, 51, 54, 54, 55, 56, 59, 62, 65, 65, 65, 67, 67, 69, 71, 74, 75, 76, 77, 77, 78, 78, 79, 79, 80, 80, 80, 80, 82, 82, 82, 82, 84, 85, 85, 85, 89, 89, 91, 95, 98, 98, 100};

                long timebegin = System.nanoTime();
                for(int timei = 0; timei < 10; timei++){
                    int[] arrtemp = Arrays.copyOf(arr,arr.length);
                    demo.sortMethod(arrtemp);
                    assert (Arrays.equals(arrtemp, expected));
                }
                long timeend = System.nanoTime();
                System.out.println("cost time:" + (timeend - timebegin)+" -> "+demo.getClass().getSimpleName());

            }catch (ClassNotFoundException e) {
                e.printStackTrace();
                assert (false);
            } catch (InstantiationException e) {
                e.printStackTrace();
                assert (false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                assert (false);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                assert (false);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.err.println(arr.length);
                assert (false);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

}
