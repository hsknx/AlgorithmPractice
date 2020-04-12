package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-9-22 ����08:27:55
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class DoctorObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        System.out.println("DoctorObserver:" + arg.toString());
    }

}
