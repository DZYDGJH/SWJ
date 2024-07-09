package ONE;
//2205900101宋玮杰
import java.util.Objects;

public class CS {
    private String name;
    private int age;

    public CS(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CS other = (CS) obj;
        return age == other.age &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        CS p1 = new CS("John", 30);
        CS p2 = new CS("John", 30);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // 应该输出 true
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode())); // 应该输出 true
    }
}
