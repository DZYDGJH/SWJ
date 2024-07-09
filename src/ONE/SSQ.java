package ONE;
//2205900101宋玮杰
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SSQ {
    public static void main(String[] args) {
        // 创建一个Random对象用于生成随机数
        Random random = new Random();
        // 创建一个HashSet用于存储不重复的红色球号码
        Set<Integer> redBalls = new HashSet<>();
        // 创建一个变量用于存储蓝色球号码
        int blueBall;

        // 循环生成6个不重复的红色球号码
        while (redBalls.size() < 6) {
            // 生成1到33之间的随机数
            int redBall = random.nextInt(33) + 1;
            // 将随机数添加到HashSet中，自动去重
            redBalls.add(redBall);
        }

        // 生成1到16之间的随机数作为蓝色球号码
        blueBall = random.nextInt(16) + 1;

        // 打印红色球号码，由于HashSet是无序的，我们需要将其转换为数组再排序
        int[] redBallsArray = redBalls.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(redBallsArray);
        System.out.print("红色球号码：");
        for (int redBall : redBallsArray) {
            System.out.print(redBall + " ");
        }

        // 打印蓝色球号码
        System.out.println("\n蓝色球号码：" + blueBall);
    }
}
