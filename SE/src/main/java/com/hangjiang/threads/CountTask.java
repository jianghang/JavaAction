package com.hangjiang.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jianghang on 2017/4/29.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;
    private int end;

    public CountTask(){

    }

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        System.out.println("canCompute: " + canCompute);

        if(canCompute){
            for(int i = start;i <= end;i++){
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle + 1,end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            System.out.println("leftResult: " + leftResult + " rightResult: " + rightResult);

            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (task.isCompletedAbnormally()){
            System.out.println(task.getException());
        }
    }
}
