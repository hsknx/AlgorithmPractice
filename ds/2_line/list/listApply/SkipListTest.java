/**
 * @author liujun
 * @version 1.0
 * @date£º 2019-10-18 02:50
 * @author¡ªEmail:ljfirst@mail.ustc.edu.cn
 * @description:
 */
public class SkipListTest {
    public static void main(String[] args) {
        SkipList l = new SkipList();
        for (int i = 25; i > 0; i--) {
            l.add(i);
        }
        System.out.println(l.SkipListlevel);
        for (int i = 0; i < 20; i++) {
            l.print();
            System.out.println();
        }
        System.out.println(l.find(22));
        System.out.println(l.find(13));
        System.out.println(l.find(102));
    }
}
