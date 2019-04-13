package cn.dazhiyy.high.count;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.count
 * @className CountExample
 * @description TODO
 * @date 2019/4/8 23:45
 */
@Slf4j
public class CountExample2 {

    private static Integer totalCount= 500000;

    private static Integer threadCount=200;

    private static Integer count=0;


    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadCount);
        final CountDownLatch countDownLatch = new CountDownLatch(totalCount);

        for (int i = 0; i < totalCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("用时:{}",System.currentTimeMillis()-l);
        log.info("一共执行了{}条数据！",count);

    }


    private static void add(){
        count++;
    }


}


