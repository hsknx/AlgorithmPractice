package UnitTest.DatastructureTest.stringTest;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date： 2020-02-05 21:17
 * @author—Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class sequenceTestDemo {

    public void testCompare(StringCompare sequenceCompare){
        //正案例
        boolean flag = sequenceCompare.compare(source01,pattern01);
        assert flag;
        flag = sequenceCompare.compare(source02,pattern02);
        assert flag;
        flag = sequenceCompare.compare(source03,pattern03);
        assert flag;
        flag = sequenceCompare.compare(source04,pattern04);
        assert flag;
        //反案例
        flag = sequenceCompare.compare(source01f,pattern01f);
        assert !flag;
        flag = sequenceCompare.compare(source02f,pattern02f);
        assert !flag;
        flag = sequenceCompare.compare(source03f,pattern03f);
        assert !flag;
        flag = sequenceCompare.compare(source04f,pattern04f);
        assert !flag;
        flag = sequenceCompare.compare(source05f,pattern05f);
        assert !flag;
    }
    
    //正案例01：
    String source01 = "0123456789";
    String pattern01 = "0258";
    //正案例02：
    String source02 = "0123456789";
    String pattern02 = "0169";
    //正案例03：
    String source03 = "0123456789";
    String pattern03 = "3469";
    //正案例04：
    String source04 = "x1d5f5e94veex66az2";
    String pattern04 = "5f5e966a2";

    //反案例01：
    String source01f = "0123456789";
    String pattern01f ="01398";
    //反案例02：
    String source02f = "0123456789";
    String pattern02f ="0123ds";
    //反案例03：
    String source03f = "0123456789";
    String pattern03f ="01234567891";
    //反案例04：
    String source04f = "8cc9q65a4d1";
    String pattern04f ="xc4e8cc9q65a4dxa4wd5x";
    //反案例04：
    String source05f = "";
    String pattern05f ="xc4e8cc9q65a4dxa4wd5x";
}
