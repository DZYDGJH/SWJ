package two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 定义一个名为 Student 的注解
@Target(ElementType.METHOD) // 注解应用于方法
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时可见
public @interface Student {
    String name(); // 姓名
    int age() default 18; // 年龄，默认值为18
    String gender() default "男"; // 性别，默认值为"男"
}

