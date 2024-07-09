package two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 定义一个名为 Stu 的注解，并使用 @Target 元注解指定它可以应用于方法和类
@Target({ElementType.METHOD, ElementType.TYPE})
@interface Stu {
    String name();
}

/*
@Stu(name="jack")
public class AnnotationDemo02 {
    // 成员变量
    @Stu(name = "lily") // 编译失败
    private String gender;
    // 成员方法
    @Stu(name="rose")
    public void test(){
    }
    // 构造方法
    @Stu(name="lucy") // 编译失败
    public AnnotationDemo02(){}
}
*/
