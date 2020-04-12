package strategy;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-8-22 ����12:10:06
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class StrategyMethod {

    Strategy strategy;

    public StrategyMethod(Strategy strategy) {
        this.strategy = strategy;
    }

    public void opera() {
        strategy.method();
    }
}
