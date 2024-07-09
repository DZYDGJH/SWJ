package ONE;
//2205900101宋玮杰
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class JP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = scanner.nextLine();

        // 使用LinkedHashSet来存储不重复的字符，并保持顺序
        Set<Character> uniqueChars = new LinkedHashSet<>();
        // 将字符串转换为字符数组
        char[] chars = input.toCharArray();
        // 遍历字符数组，将字符添加到LinkedHashSet中，自动去重
        for (char c : chars) {
            uniqueChars.add(c);
        }

        // 构建一个新的字符串来存放结果
        StringBuilder result = new StringBuilder();
        for (Character c : uniqueChars) {
            result.append(c);
        }

        // 打印结果
        System.out.println("去除重复字符后的字符串为：");
        System.out.println(result.toString());
    }
}
