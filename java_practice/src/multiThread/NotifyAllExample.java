package multiThread;

public class NotifyAllExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread waitingThread1 = new Thread(new WaitingTask(), "WaitingThread-1");
        Thread waitingThread2 = new Thread(new WaitingTask(), "WaitingThread-2");
        waitingThread1.start();
        waitingThread2.start();

        try {
            Thread.sleep(1000); // 确保等待线程先启动并等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notifyAll(); // 唤醒所有等待线程
        }
    }

    static class WaitingTask implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    lock.wait(); // 等待
                    System.out.println(Thread.currentThread().getName() + " is resumed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
