package SSS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SWJ extends JFrame {

    private BufferedImage bgImage;
    private BufferedImage dd; // 假设这是要绘制的图像
    private int ddX = 400; // 图像的X坐标
    private int ddY = 400; // 图像的Y坐标
    private int dx = 50; // X方向移动步长
    private int dy = 50; // Y方向移动步长
    private boolean moving = false;
    private Rectangle[] corners = new Rectangle[4]; // 四个角的矩形框
    private Random random = new Random(); // 用于生成随机数

    public SWJ() {
        setTitle("坑爹游戏");
        setSize(new Dimension(800, 800)); // 窗口大小设置为800x800
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口背景色为蓝色
        setBackground(Color.BLUE);

        // 初始化四个角的矩形框
        corners[0] = new Rectangle(10, 40, 100, 100); // 左上角
        corners[1] = new Rectangle(690, 40, 100, 100); // 右上角
        corners[2] = new Rectangle(10, 690, 100, 100); // 左下角
        corners[3] = new Rectangle(690, 690, 100, 100); // 右下角

        // 加载图片
        try {
            InputStream inputStream = getClass().getResourceAsStream("/头像.png");
            dd = ImageIO.read(inputStream); // 假设dd和bgImage是同一张图片

            // 缩放图片到50x50像素
            dd = resizeImage(dd, 50, 50);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "加载背景图片失败！", "错误", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // 添加键盘监听器
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moving = true;
                updateDirection(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                moving = false;
            }
        });

        // 启动定时器
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moving) {
                    moveImage();
                }
                repaint();
            }
        });
        timer.start();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 设置背景色为蓝色
        g.setColor(new Color(102, 210, 25));
        g.fillRect(0, 0, getWidth(), getHeight());

        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        }
        draw(g);
    }


    private void moveImage() {
        int steps = 40; // 设置移动的步数
        for (int i = 0; i < steps; i++) {
            int nextX = ddX + dx;
            int nextY = ddY + dy;

            // 判断是否将要超出边界
            if (nextX >= 0 && nextX + dd.getWidth() <= getWidth() && nextY >= 0 && nextY + dd.getHeight() <= getHeight()) {
                // 如果不会超出边界，则更新位置
                ddX = nextX;
                ddY = nextY;
            } else {
                // 如果将要超出边界，则改变移动方向
                if (nextX < 0 || nextX + dd.getWidth() > getWidth()) {
                    dx = -dx;
                }
                if (nextY < 0 || nextY + dd.getHeight() > getHeight()) {
                    dy = -dy;
                }
            }
        }
    }

    private void updateDirection(KeyEvent e) {
        // 随机选择一个方向
        int directionX = random.nextInt(3) - 1; // -1, 0, 1
        int directionY = random.nextInt(3) - 1; // -1, 0, 1
        dx = directionX;
        dy = directionY;
    }

    private void draw(Graphics g) {
        // 绘制图像
        g.drawImage(dd, ddX, ddY, this);

        // 检查图片是否进入四个角中的任何一个矩形框
        int cornerIndex = checkCorners();
        if (cornerIndex != -1) {
            System.out.println("进入了第 " + (cornerIndex + 1) + " 号框");
        }

        // 绘制四个角的矩形框
        for (Rectangle corner : corners) {
            g.setColor(Color.RED); // 设置线颜色为红色
            g.drawRect(corner.x, corner.y, corner.width, corner.height);
        }
    }

    private int checkCorners() {
        Rectangle ddRect = new Rectangle(ddX, ddY, dd.getWidth(), dd.getHeight());
        for (int i = 0; i < corners.length; i++) {
            if (ddRect.intersects(corners[i])) {
                return i;
            }
        }
        return -1;
    }

    // 缩放图片的方法
    private BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return resizedImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SWJ frame = new SWJ();
            frame.setVisible(true);
        });
    }
}
