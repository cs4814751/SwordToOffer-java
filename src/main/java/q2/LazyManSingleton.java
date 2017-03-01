package q2;

/**
 * Created by leibro on 2017/3/1.
 */

public class LazyManSingleton {
    private static LazyManSingleton instance = null;

    LazyManSingleton() {

    }

    public static LazyManSingleton getInstance() {
        if(instance == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazyManSingleton();
        }
        return instance;
    }

}
