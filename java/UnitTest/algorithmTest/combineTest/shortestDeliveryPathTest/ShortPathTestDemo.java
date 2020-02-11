package UnitTest.algorithmTest.combineTest.shortestDeliveryPathTest;

import Algorithm.comprehensive.shortestDeliveryPath.ShortPath;

/**
 * @author liujun
 * @version 1.0
 * @date： 2020-02-11 14:34
 * @author—Email: liujunfirst@outlook.com
 * @description: 送货最短路径测试用例 ShortestDeliveryPath
 * @blogURL:
 */
public class ShortPathTestDemo {

    public void shortPath(ShortPath shortPath){
        int sum = shortPath.shortPath(Demorow_01, Democolumn_01);
        assert sum == 38;
        sum = shortPath.shortPath(Demorow_02, Democolumn_02);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_03, Democolumn_03);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_04, Democolumn_04);
        assert sum == -1;
        sum = shortPath.shortPath(Demorow_05, Democolumn_05);
        assert sum == 24;
    }

    //Demo
    int[] Demorow_01 = {   4, 7, 1, 5, 6, 4};
    int[] Democolumn_01 = {4, 1, 5, 4, 1, 8};
    int[] Demorow_02 = null;
    int[] Democolumn_02 = {4, 1, 5, 4, 1, 8};
    int[] Demorow_03 = {4, 7, 1, 5, 6, 4};
    int[] Democolumn_03 = null;
    int[] Demorow_04 = {4, 7, 1, 5, 6, 4};
    int[] Democolumn_04 = {4, 1, 5, 4, 1, 8, 9};
    int[] Demorow_05 = {3, 1, 5, 4};
    int[] Democolumn_05 = {1, 5, 3, 7};
}
