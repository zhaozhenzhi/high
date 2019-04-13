package cn.dazhiyy.high.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.aqs
 * @className FutureTast
 * @description TODO
 * @date 2019/4/11 21:36
 */
@Slf4j
public class FutureTast1 {


    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do more thinks");
            Thread.sleep(5000L);
            return "nihao word";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        delayQueue.add(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        })

    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());

        System.out.println(submit.get());


        FutureTask<String> task = new FutureTask<>(() -> {
            log.info("do more thinks");
            Thread.sleep(5000L);
            return "nihao ";
        });

        new Thread(task).start();
        System.out.println(task.get());
    }


}


