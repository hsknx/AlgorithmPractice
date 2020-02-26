package Logic.regular;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-5-13 Time������10:31:25
 * @author��Email:liujunfirst@outlook.com
 * @description:trans ����Ҵ�Сдת�� digital trans to capital
 * method:
 * 1.ȥ�ո�.
 * 2.�����жϣ� 2.1 ����һ��С����Ͷ�����֣������ַ������ԡ�
 * 2.2 ��0��ͷ�Ĳ���ȷ(022,02.2)������0.x
 * 3.�ֳ�������С�����ִ���.
 * 4.������С�����ֺϲ���ȥ��.
 */
public class DigitalTrans {

    String[] digital = {"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"};
    String[] element = {"Բ", "ʰ", "��", "Ǫ", "��", "ʰ��", "����", "Ǫ��", "��","ʰ��","����","Ǫ��"};
    String[] small = {"��", "��", "��", "��"};

    public String trans(String num) {

        //1.ȥ�ո�
        num = num.trim();
        //2.�����ж�:1)����һ��С����Ͷ�����֣������ַ������ԡ�2)��0��ͷ�Ĳ���ȷ(022,02.2)������0.x
        if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
            //throw new Exception("Ǯ����ʽ����");
            return "ERROR";
        }
        //3.�ֳ�������С�����ִ�����Ԥ����
        String[] deal = num.split("\\.");
        //�����������ֻ����ʮ��λ�������ڲ���
        String wholenum = deal[0];
        if (deal[0].length() > 12) {
            int k = deal[0].length() - 12;
            wholenum = deal[0].substring(k);
        }
        //3.�ֳ�������С�����ִ���������
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        int index = wholenum.length() - 1;
        for (int i = 0; i <= wholenum.length() - 1; i++) {
            //������������0ʱ���кϲ�����
            if (!flag && wholenum.charAt(i) == '0') {
                sb.append("��");
                flag = true;
            }
            //������ֵ
            if (wholenum.charAt(i) != '0') {
                sb.append(digital[Integer.parseInt(wholenum.charAt(i) + "")] + element[index]);
                flag = false;
            }
            //������λ�ǴӺ���ǰ�����
            index--;
        }
        //������������β�����滻��Բ
        if (sb.lastIndexOf("��") == sb.length() - 1) {
            sb.replace(sb.length() - 1, sb.length(), "Բ");
        }
        //����������ֽ������㣬��0.1����ֱ��ȥ��(��Ϊ��������ı��滻��Բ��������Բ��Ϊƥ��)
        if (sb.toString().equals("Բ")) {
            sb = new StringBuffer();
        }
        //���������Ѻ����
		while(sb.lastIndexOf("��")!=sb.indexOf("��")){
			int cut = sb.indexOf("��");
			sb.replace(cut, cut+1, "");
		}
		while(sb.lastIndexOf("��")!=sb.indexOf("��")){
			int cut = sb.indexOf("��");
			sb.replace(cut, cut+1, "");
		}
        //�������С��
        if (deal.length > 1) {
            //С���������ֻ����С�������λ�������ڲ���
            String decimal = deal[1];
            if (deal[1].length() > 4) {
                decimal = deal[1].substring(0, 4);
            }
            index = 0;
            flag = false;
            for (int i = 0; i <= decimal.length() - 1; i++) {
                //������������0���кϲ�����
                if (!flag && decimal.charAt(i) == '0') {
                    sb.append("��");
                    flag = true;
                }
                if (decimal.charAt(i) != '0') {
                    sb.append(digital[Integer.parseInt(decimal.charAt(i) + "")] + small[index]);
                    flag = false;
                }
                index++;
            }
            //���С�������β����ֱ��ȥ��
            while (sb.lastIndexOf("��") == sb.length() - 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
        //�������С������Ӧ�����㿪ͷ�����ҽ�������0.0020�������Ƶ�һ�ֿ���
		if (sb.indexOf("��") == 0){
			sb.replace(0, 1, "");
		}
        //4.������С�����ֺϲ���ȥ��
        return sb.toString().equals("") ? "��Բ" : sb.toString();
    }
}
