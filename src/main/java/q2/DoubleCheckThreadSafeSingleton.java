package q2;

/**
 * Created by leibro on 2017/3/1.
 */
public class DoubleCheckThreadSafeSingleton {
    private static DoubleCheckThreadSafeSingleton instance = null;

    DoubleCheckThreadSafeSingleton() {

    }

    public static DoubleCheckThreadSafeSingleton getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckThreadSafeSingleton.class) {
                if(instance ==null)
                    instance = new DoubleCheckThreadSafeSingleton();
            }
        }
        return instance;
    }
}
