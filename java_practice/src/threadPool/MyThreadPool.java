package threadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    private int currentThreads;
    private int corePoolSize;
    private int maxPoolSize;
    private int workSize;

    public MyThreadPool(int corePoolSize, int maxPoolSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.workSize = workSize;
    }

    public void submit(Runnable task) {
        if(tasks.size() >= workSize){
            System.out.println("Task:" + task + " is thrown");
        }else{
            tasks.add(task);
            execTask(task);
        }
    }

    private void execTask(Runnable task) {
        if(currentThreads < corePoolSize){
            new MyWorker("Core Thread:" + currentThreads, tasks).start();
            currentThreads++;
        }else if (currentThreads < maxPoolSize){
            new MyWorker("Non-core Thread:" + currentThreads, tasks).start();
            currentThreads++;
        }else{
            System.out.println("Task:" + task + " is saved");
        }
    }
}
