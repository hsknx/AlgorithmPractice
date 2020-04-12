package factory.simplefactory;

import factory.simplefactory.CT1;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2019-3-31 ����03:51:33
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 * @URL:
 */
public class SimpleFactory {

    public static CT1 createClass() {

        System.out.print("SimpleFactory:");
        return new CT1();
    }
}


