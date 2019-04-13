package cn.dazhiyy.high.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dazhi
 * @projectName high
 * @packageName cn.dazhiyy.high.annoations
 * @className ThreadSafe
 * @description TODO
 * @date 2019/4/8 22:06
 */
@Target(ElementType.TYPE) // 表示只能在作用类上
@Retention(RetentionPolicy.SOURCE) // 在编译的时候会被忽视
public @interface ThreadSafe {
}
