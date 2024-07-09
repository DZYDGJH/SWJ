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

public class SS extends JFrame {

    private BufferedImage bgImage;
    private int x = 0;
    private int y = 0;
    private int dx = 1;
    private int dy = 1;
    private boolean moving = false;

    public SS() {
        setTitle("坑爹游戏");
        setSize(new Dimension(500, 550));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 加载图片
        try {
            InputStream inputStream = getClass().getResourceAsStream("/头像.png");
            bgImage = ImageIO.read(inputStream);
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
        Timer timer = new Timer(10, new ActionListener() {
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
        if (bgImage != null) {
            g.drawImage(bgImage, x, y, 50, 50, this);
        }
        draw(g);
    }

    private void moveImage() {
        x += dx;
        y += dy;
        if (x < 0 || x + 50 > getWidth()) {
            dx = -dx;
        }
        if (y < 0 || y + 50 > getHeight()) {
            dy = -dy;
        }
    }

    private void updateDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                dx = -1;
                dy = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 1;
                dy = 0;
                break;
            case KeyEvent.VK_UP:
                dx = 0;
                dy = -1;
                break;
            case KeyEvent.VK_DOWN:
                dx = 0;
                dy = 1;
                break;
        }
    }

    private void draw(Graphics g) {
        // 左上角
        g.setColor(Color.WHITE);
        g.drawRect(10, 40, 50, 50);
        g.drawString("1", 25, 80);

        // 右上角
        g.drawRect(500 - 50 - 10, 40, 50, 50);
        g.drawString("2", 455, 80);

        // 左下角
        g.drawRect(10, 550 - 50 - 10, 50, 50);
        g.drawString("3", 25, 520);

        // 右下角
        g.drawRect(500 - 50 - 10, 550 - 50 - 10, 50, 50);
        g.drawString("4", 455, 520);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SS frame = new SS();
            frame.setVisible(true);
        });
    }
}
