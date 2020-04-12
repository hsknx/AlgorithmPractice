package observer;

/**
 * @author liujun
 * @version 1.0
 * @date�� 2018-9-22 ����07:37:22
 * @author��Email:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class ObserverTest {

    public static void main(String[] args) {

        AnimalObservable animal = new AnimalObservable();
        HumanObserver human = new HumanObserver();
        DoctorObserver doc = new DoctorObserver();

        //����۲���
        animal.addObserver(human);
        animal.addObserver(doc);

        //���±��۲�Ĳ����
        animal.eat();
    }
}
