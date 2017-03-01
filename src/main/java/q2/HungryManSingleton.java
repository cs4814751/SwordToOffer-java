package q2;

/**
 * Created by leibro on 2017/3/1.
 */
public class HungryManSingleton {
    private static HungryManSingleton instance = new HungryManSingleton();

    HungryManSingleton() {

    }

    public static HungryManSingleton getInstance() {
        return instance;
    }
}
