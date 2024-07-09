package two;
//2205900101宋玮杰
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationReflectionExample {

    public static void main(String[] args) {
        try {
            // 获取Library类的Class对象
            Class<Library> clazz = Library.class;

            // 获取Library类上的@BOOK2注解
            Annotation classAnnotation = clazz.getAnnotation(BOOK2.class);
            BOOK2 bookAnnotation = (BOOK2) classAnnotation;
            System.out.println("Class annotation - Title: " + bookAnnotation.title() + ", Author: " + bookAnnotation.author());

            // 获取displayBookInfo方法的Method对象
            Method method = clazz.getDeclaredMethod("displayBookInfo");

            // 获取displayBookInfo方法上的@BOOK2注解
            Annotation methodAnnotation = method.getAnnotation(BOOK2.class);
            bookAnnotation = (BOOK2) methodAnnotation;
            System.out.println("Method annotation - Title: " + bookAnnotation.title() + ", Author: " + bookAnnotation.author());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
