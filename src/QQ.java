//2205900101宋玮杰
import java.util.HashSet;
import java.util.Set;

public class QQ {
    public static void main(String[] args) {
        String[] qqNumbers = {"12345", "67891", "12347809933", "98765432102", "67891", "12347809933"};

        // 使用HashSet来存储不重复的QQ号码
        Set<String> uniqueQQNumbers = new HashSet<>();
        // 使用HashSet来存储重复的QQ号码
        Set<String> duplicateQQNumbers = new HashSet<>();

        for (String qq : qqNumbers) {
            // 检查QQ号码的长度是否合法
            if (qq.length() >= 5 && qq.length() <= 11) {
                // 如果已经存在，则添加到重复号码集合
                if (!uniqueQQNumbers.add(qq)) {
                    duplicateQQNumbers.add(qq);
                }
            } else {
                System.out.println("无效的QQ号码: " + qq);
            }
        }

        // 打印不重复的QQ号码
        System.out.println("不重复的QQ号码:");
        for (String qq : uniqueQQNumbers) {
            System.out.println(qq);
        }

        // 打印重复的QQ号码
        System.out.println("重复的QQ号码:");
        for (String qq : duplicateQQNumbers) {
            System.out.println(qq);
        }
    }
}
