package com.hangjiang.threads;

import java.util.concurrent.*;

/**
 * Created by jianghang on 2017/11/22.
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command,clientTrace(),Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }

    private Exception clientTrace(){
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task,final Exception clientStack,String clientThreadName){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e){
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

    public static class DivTask implements Runnable{

        int a,b;

        public DivTask(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a/b;
            System.out.println(re);
        }
    }

    public static void main(String[] args){
        //SynchronousQueue没有容量，每一个插入操作都要等待一个相应的删除操作，提交的任务不会被真实的保存，而总是将新任务提交给线程执行，如果没有空闲
        //的进程，则尝试创建新的进程，如果进程数量已经达到最大值，则执行拒绝策略
        ThreadPoolExecutor poolExecutor = new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<>());
        for(int i = 0;i < 5;i++){
            poolExecutor.execute(new DivTask(100,i));
        }
    }
}
