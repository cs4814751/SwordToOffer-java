package q2;

/**
 * Created by leibro on 2017/3/1.
 */
public class EnumThreadSafeSingleton {
    private enum Singleton {
        FACTORY;

        private EnumThreadSafeSingleton instance = null;

        Singleton() {
            instance = new EnumThreadSafeSingleton();
        }

        private EnumThreadSafeSingleton getInstance() {
            return instance;
        }
    }

    public static EnumThreadSafeSingleton getInstance() {
        return Singleton.FACTORY.getInstance();
    }
}
