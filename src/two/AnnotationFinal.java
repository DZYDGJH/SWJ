package two;
//2205900101宋玮杰
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationFinal {
    public static void main(String[] args) {
        // 创建Person类的对象
        Person person = new Person();
        String address = person.getAddress();
        System.out.println("Person's address: " + address);


        // 利用反射获取Person类的Class对象
        Class<?> clazz = person.getClass();

        // 获取类上的Hello注解
        Hello classHello = clazz.getAnnotation(Hello.class);
        if (classHello != null) {
            System.out.println("Class Hello Annotation:");
            System.out.println("Value: " + classHello.value());
            System.out.println("Name: " + classHello.name());
            System.out.println("Age: " + classHello.age());
        }

        // 获取成员变量上的Hello注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Hello fieldHello = field.getAnnotation(Hello.class);
            if (fieldHello != null) {
                System.out.println("Field Hello Annotation:");
                System.out.println("Value: " + fieldHello.value());
                System.out.println("Name: " + fieldHello.name());
                System.out.println("Age: " + fieldHello.age());
            }
        }

        // 获取方法上的Hello注解
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Hello methodHello = method.getAnnotation(Hello.class);
            if (methodHello != null) {
                System.out.println("Method Hello Annotation:");
                System.out.println("Value: " + methodHello.value());
                System.out.println("Name: " + methodHello.name());
                System.out.println("Age: " + methodHello.age());
            }
        }
    }
}
