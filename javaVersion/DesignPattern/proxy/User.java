package proxy;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-8-17 ����02:15:55
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:�û�������
 */
public class User {

    public static void main(String[] args) {

        ProxyInterface r = new Real();
        ProxyInterface p = new Proxy(r);
        p.work();
    }
}
