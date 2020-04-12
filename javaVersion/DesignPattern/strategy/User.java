package strategy;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-8-22 ����12:11:51
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class User {

    public static void main(String[] args) {
        Strategy s = new strategy02();
        StrategyMethod sm = new StrategyMethod(s);
        sm.opera();
    }
}
