package ONE;
//2205900101宋玮杰
import java.util.Arrays;

public class Comparable {
    static class Student implements java.lang.Comparable<Student> {
        String name;
        int age;
        float score;

        public Student(String name, int age, float score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public int compareTo(Student other) {
            if (this.score != other.score) {
                return Float.compare(other.score, this.score); // 降序排序
            } else {
                return Integer.compare(this.age, other.age); // 年龄升序排序
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("liusan", 20, 90.0F),
                new Student("lisi", 22, 90.0F),
                new Student("wangwu", 20, 99.0F),
                new Student("sunliu", 22, 100.0F)
        };

        Arrays.sort(students);

        for (Student student : students) {
            System.out.println(student.name + " " + student.age + " " + student.score);
        }
    }
}