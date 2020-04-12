package single;

/**
 * @author liujun
 * @version 1.0
 * @date£º 2020-02-17 18:24
 * @author¡ªEmail: liujunfirst@outlook.com
 * @description: LazySinglePattren means delayed loading,
 * but exist thread safety problem.
 * So use synchronized to solve this problem,
 * but still exist performance problem.
 * @blogURL:
 */

public class LazySingle implements Singletom {
    private static LazySingle lazySinglePattren = null;

    private LazySingle() {
    }

    public static LazySingle getlLazySinglePattren() {
        synchronized (LazySingle.class) {
            if (lazySinglePattren == null) {
                lazySinglePattren = new LazySingle();
            }
        }

        return lazySinglePattren;
    }
}
