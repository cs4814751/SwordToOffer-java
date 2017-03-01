package q2;

/**
 * Created by leibro on 2017/3/1.
 */

/*测试可得懒汉模式是非线程安全的*/
public class Test extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + EnumThreadSafeSingleton.getInstance());
    }

    public static void main(String[] args) {
        Test[] tests = new Test[10];
        for(int i = 0;i < tests.length;i ++) {
            tests[i] = new Test();
        }
        for(int i = 0;i < tests.length;i ++) {
            tests[i].start();
        }
    }
}
