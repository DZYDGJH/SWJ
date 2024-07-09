package two;

import java.lang.reflect.Method;

// 使用 Student 注解
public class Example {

    @Student(name = "宋玮杰", age = 20, gender = "男")
    public void studentInfo() {
        // 使用反射获取注解信息
        try {
            Method method = this.getClass().getMethod("studentInfo");
            Student student = method.getAnnotation(Student.class);

            System.out.println("学生的姓名是：" + student.name());
            System.out.println("学生的年龄是：" + student.age());
            System.out.println("学生的性别是：" + student.gender());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.studentInfo();
    }
}
