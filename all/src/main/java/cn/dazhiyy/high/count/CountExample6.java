package cn.dazhiyy.high.count;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.count
 * @className CountExample
 * @description TODO
 * @date 2019/4/8 23:45
 */
@Slf4j
public class CountExample6 {

    private static AtomicIntegerFieldUpdater<CountExample6> updater = AtomicIntegerFieldUpdater.newUpdater(CountExample6.class,"count");

    @Getter
    private volatile Integer count = 100;



    public static void main(String[] args) {
        CountExample6 countExample6 = new CountExample6();
        System.out.println(updater.compareAndSet(countExample6,100,12));
        System.out.println(updater.compareAndSet(countExample6,10,12));
        System.out.println(updater.compareAndSet(countExample6,12,122));

    }
}


