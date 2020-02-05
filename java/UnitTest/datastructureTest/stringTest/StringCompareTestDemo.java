package UnitTest.datastructureTest.stringTest;

import DataStructure.string.StringCompare;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2020-01-31 23:11
 * @author��Email: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class StringCompareTestDemo {

    public void testCompare(StringCompare stringCompare){
        //������
        boolean flag = stringCompare.compare(source01,pattern01);
        assert flag;
        flag = stringCompare.compare(source02,pattern02);
        assert flag;
        flag = stringCompare.compare(source03,pattern03);
        assert flag;
        flag = stringCompare.compare(source04,pattern04);
        assert flag;
        flag = stringCompare.compare(source05,pattern05);
        assert flag;
        //������
        flag = stringCompare.compare(source01f,pattern01f);
        assert !flag;
        flag = stringCompare.compare(source02f,pattern02f);
        assert !flag;
        flag = stringCompare.compare(source03f,pattern03f);
        assert !flag;
        flag = stringCompare.compare(source04f,pattern04f);
        assert !flag;
        flag = stringCompare.compare(source05f,pattern05f);
        assert !flag;
        flag = stringCompare.compare(source06f,pattern06f);
        assert !flag;
    }


    //������01����������01
    String source01 = "12345ui6789";
    String pattern01 = "ui";

    //������02����������02
    String source02 = "12345uri67we89";
    String pattern02 = "we";

    //������03����������03
    String source03 = "123rt45uri6789";
    String pattern03 = "rt";

    //������04����������01
    String source04 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern04 = "==1vyugbuiy1==";

    //������05����������02
    String source05 = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern05 = "1vyugbuiy1";


    //������01����������01
    String source01f = "12uw3wi345uri6789";
    String pattern01f = "uir";

    //������02����������02
    String source02f = "12345uri6u4i789";
    String pattern02f = "ui";

    //������03����������03
    String source03f = "12345uri67f34g3b5n689";
    String pattern03f = "f34gb5n6";

    //������04����������04
    String source04f = "dthggvjff==1vyugbuiy1==ufxewzqaszdxcvbpo";
    String pattern04f = "=1=1vyugbuiy1==";
    //������05����������05
    String source05f = "20413";
    String pattern05f = "12340202411322";
    //������06����������06
    String source06f = "20413";
    String pattern06f = null;
}
