package threadPool;

public class MyTest {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(2, 4, 20);
        for (int i = 0; i < 30; i++) {
            pool.submit(new MyTask(i));
        }
    }
}
