package single;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-02-17 19:02
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description:
 * @blogURL:
 */
public class DCLSingletom {
    private static DCLSingletom dclSingletom = null;

    private DCLSingletom() {
    }

    //Experiments show that the double locks is faster
    public static DCLSingletom getdclSingletom() {
        if (dclSingletom == null) {
            synchronized (LazySingle.class) {
                if (dclSingletom == null) {
                    dclSingletom = new DCLSingletom();
                }
            }
        }
        return dclSingletom;
    }
}