package two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义一个名为 Book 的注解
@Target(ElementType.METHOD) // 注解应用于方法
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时可见
public @interface Book {
    // 书名
    String value();

    // 价格
    double price() default 100;

    // 多位作者
    String[] authors();


}