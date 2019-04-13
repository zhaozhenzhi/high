package cn.dazhiyy.high.count;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.count
 * @className CountExample
 * @description TODO
 * @date 2019/4/8 23:45
 */
@Slf4j
public class CountExample5 {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        atomicReference.compareAndSet(0,1);
        atomicReference.compareAndSet(1,3);
        atomicReference.compareAndSet(2,4);
        atomicReference.compareAndSet(4,3);
        atomicReference.compareAndSet(3,6);
        System.out.println(atomicReference.get());
    }
}


