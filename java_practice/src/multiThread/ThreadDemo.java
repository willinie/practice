package multiThread;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int cpuNumbers = runtime.availableProcessors();
        System.out.println(cpuNumbers);
        Cat cat = new Cat();
        Thread t1 = new Thread(cat);
        t1.start();
        for(int i = 0; i < 40; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("miao: " + Thread.currentThread().getName() + " " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}