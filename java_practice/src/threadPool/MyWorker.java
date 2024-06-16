package threadPool;

import java.util.List;

public class MyWorker extends Thread{
    private String name;
    private List<Runnable> tasks;

    public MyWorker(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while(!tasks.isEmpty()){
            Runnable task = tasks.remove(0);
            task.run();
        }
    }
}
