package ONE;
//2205900101宋玮杰
import java.util.Arrays;

public class Comparator {
    static class Student {
        String name;
        int age;
        float score;

        public Student(String name, int age, float score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("liusan", 20, 90.0F),
                new Student("lisi", 22, 90.0F),
                new Student("wangwu", 20, 99.0F),
                new Student("sunliu", 22, 100.0F)
        };

        Arrays.sort(students, new java.util.Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.score != s2.score) {
                    return Float.compare(s2.score, s1.score); // 降序排序
                } else {
                    return Integer.compare(s1.age, s2.age); // 年龄升序排序
                }
            }
        });

        for (Student student : students) {
            System.out.println(student.name + " " + student.age + " " + student.score);
        }
    }
}
