package UnitTest.LogicTest.regulartest;

import Logic.regular.DigitalTrans;
import org.junit.Test;

/**
 * @author liujun
 * @date 2020-02-26 09:21
 * @description
 */
public class DigitalTransTest {

    DigitalTrans digitalTrans = new DigitalTrans();

    @Test
    public void Testtrans() throws Exception {

        String ans = digitalTrans.trans(Demo01);
        assert ans.equals("Ò¼ÇªÔ²ÁãÒ¼·Ö");
        ans = digitalTrans.trans(Demo02);
        assert ans.equals("ÁãÔ²");
        ans = digitalTrans.trans(Demo021);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo022);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo023);
        assert ans.equals("·¡ºÁ");
        ans = digitalTrans.trans(Demo03);
        assert ans.equals("ÎéÍòÁãÒ¼Ô²ÁãÒ¼ºÁ");
        ans = digitalTrans.trans(Demo04);
        assert ans.equals("Ò¼Ô²");
        ans = digitalTrans.trans(Demo05);
        assert ans.equals("ÈşÊ°ËÁÍò¾ÁÇªÆâ°ÛÂ½Ê°Ô²Áã·¡·ÖÒ¼ºÁ");
        ans = digitalTrans.trans(Demo06);
        assert ans.equals("ÎéÒÚÁãÎéÊ°ÍòÁã°Æ°ÛËÁÊ°Â½Ô²Áã·¡·ÖÈşºÁ");
        ans = digitalTrans.trans(Demo061);
        assert ans.equals("Ò¼ÇªÁã·¡ÒÚÈşÇªÍòÁãËÁ°ÛÎéÊ°Â½Ô²ÁãÈşÀå");
        ans = digitalTrans.trans(Demo07);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo08);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo09);
        assert ans.equals("ERROR");
    }

    String Demo01 = "1000.0100 ";
    String Demo02 = "0";
    String Demo021 = "000000";
    String Demo022 = "000001";
    String Demo023 = "0.0020";
    String Demo03 = " 50001.0010";
    String Demo04 = "1";
    String Demo05 = " 349760.021 ";
    String Demo06 = "500500846.023";
    String Demo061 = "100230000456.0003";


    String Demo07 = "15mkl6";
    String Demo08 = "005469.16";
    String Demo09 = "-1";
}
