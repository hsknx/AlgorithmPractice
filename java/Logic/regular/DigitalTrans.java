package Logic.regular;

/**
 * @author liujun
 * @version 1.0
 * @date： 2018-5-13 Time：下午10:31:25
 * @author—Email:liujunfirst@outlook.com
 * @description:trans 人民币大小写转换 digital trans to capital
 * method:
 * 1.去空格.
 * 2.数字判断： 2.1 除了一个小数点和多个数字，其他字符都不对。
 * 2.2 以0开头的不正确(022,02.2)，除了0.x
 * 3.分成整数和小数部分处理.
 * 4.整数和小数部分合并，去零.
 */
public class DigitalTrans {

    String[] digital = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    String[] element = {"圆", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万", "亿","拾亿","佰亿","仟亿"};
    String[] small = {"角", "分", "毫", "厘"};

    public String trans(String num) {

        //1.去空格
        num = num.trim();
        //2.数字判断:1)除了一个小数点和多个数字，其他字符都不对。2)以0开头的不正确(022,02.2)，除了0.x
        if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
            //throw new Exception("钱数格式错误！");
            return "ERROR";
        }
        //3.分成整数和小数部分处理——预处理
        String[] deal = num.split("\\.");
        //整数部分最多只保留十二位，仅用于测试
        String wholenum = deal[0];
        if (deal[0].length() > 12) {
            int k = deal[0].length() - 12;
            wholenum = deal[0].substring(k);
        }
        //3.分成整数和小数部分处理——处理
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        int index = wholenum.length() - 1;
        for (int i = 0; i <= wholenum.length() - 1; i++) {
            //遇见非连续的0时进行合并操作
            if (!flag && wholenum.charAt(i) == '0') {
                sb.append("零");
                flag = true;
            }
            //附加数值
            if (wholenum.charAt(i) != '0') {
                sb.append(digital[Integer.parseInt(wholenum.charAt(i) + "")] + element[index]);
                flag = false;
            }
            //计量单位是从后往前计算的
            index--;
        }
        //如果整数以零结尾，则替换成圆
        if (sb.lastIndexOf("零") == sb.length() - 1) {
            sb.replace(sb.length() - 1, sb.length(), "圆");
        }
        //如果整数部分仅包括零，如0.1，则直接去掉(因为仅包括零的被替换成圆，所以以圆作为匹配)
        if (sb.toString().equals("圆")) {
            sb = new StringBuffer();
        }
        //整数部分友好输出
		while(sb.lastIndexOf("万")!=sb.indexOf("万")){
			int cut = sb.indexOf("万");
			sb.replace(cut, cut+1, "");
		}
		while(sb.lastIndexOf("亿")!=sb.indexOf("亿")){
			int cut = sb.indexOf("亿");
			sb.replace(cut, cut+1, "");
		}
        //如果包含小数
        if (deal.length > 1) {
            //小数部分最多只保留小数点后四位，仅用于测试
            String decimal = deal[1];
            if (deal[1].length() > 4) {
                decimal = deal[1].substring(0, 4);
            }
            index = 0;
            flag = false;
            for (int i = 0; i <= decimal.length() - 1; i++) {
                //遇见非连续的0进行合并操作
                if (!flag && decimal.charAt(i) == '0') {
                    sb.append("零");
                    flag = true;
                }
                if (decimal.charAt(i) != '0') {
                    sb.append(digital[Integer.parseInt(decimal.charAt(i) + "")] + small[index]);
                    flag = false;
                }
                index++;
            }
            //如果小数以零结尾，则直接去掉
            while (sb.lastIndexOf("零") == sb.length() - 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
        //如果仅有小数，不应该以零开头，而且仅存在向0.0020这种类似的一种可能
		if (sb.indexOf("零") == 0){
			sb.replace(0, 1, "");
		}
        //4.整数和小数部分合并，去零
        return sb.toString().equals("") ? "零圆" : sb.toString();
    }
}
