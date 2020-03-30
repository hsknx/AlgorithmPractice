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
        assert ans.equals("ҼǪԲ��Ҽ��");
        ans = digitalTrans.trans(Demo02);
        assert ans.equals("��Բ");
        ans = digitalTrans.trans(Demo021);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo022);
        assert ans.equals("ERROR");
        ans = digitalTrans.trans(Demo023);
        assert ans.equals("����");
        ans = digitalTrans.trans(Demo03);
        assert ans.equals("������ҼԲ��Ҽ��");
        ans = digitalTrans.trans(Demo04);
        assert ans.equals("ҼԲ");
        ans = digitalTrans.trans(Demo05);
        assert ans.equals("��ʰ�����Ǫ���½ʰԲ�㷡��Ҽ��");
        ans = digitalTrans.trans(Demo06);
        assert ans.equals("��������ʰ����ư���ʰ½Բ�㷡������");
        ans = digitalTrans.trans(Demo061);
        assert ans.equals("ҼǪ�㷡����Ǫ����������ʰ½Բ������");
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
