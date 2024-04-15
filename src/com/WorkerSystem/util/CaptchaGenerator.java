package com.WorkerSystem.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CaptchaGenerator {
    private static final int WIDTH = 120; // 验证码图片宽度
    private static final int HEIGHT = 40; // 验证码图片高度
    private static final int CODE_LENGTH = 6; // 验证码长度
    private static final int FONT_SIZE = 20; // 字体大小


    // 验证码字符集
    private static final String CODE_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static String captchaString;

    // 生成验证码
    public static BufferedImage generateCaptcha() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();

        // 设置背景色
        g.setColor(getRandomColor(200, 250));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 生成验证码
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CODE_SET.length());
            char codeChar = CODE_SET.charAt(index);
            captcha.append(codeChar);
            g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
            g.setColor(getRandomColor(20, 130));
            g.drawString(String.valueOf(codeChar), i * WIDTH / CODE_LENGTH, HEIGHT / 2 + FONT_SIZE / 2 - 5);
        }



        // 释放资源
        g.dispose();

        // 返回验证码图片和验证码内容
        captchaString = captcha.toString();
        return image;
    }

    //获取验证码
    public static String getCaptcha(){
        return captchaString;
    }

    //保存图片到文件
    public static void saveImage(BufferedImage image) throws IOException {
        File output = new File("captcha.png");
        ImageIO.write(image, "png", output);
    }


    // 获取随机颜色
    private static Color getRandomColor(int min, int max) {
        Random random = new Random();
        int r = min + random.nextInt(max - min);
        int g = min + random.nextInt(max - min);
        int b = min + random.nextInt(max - min);
        return new Color(r, g, b);
    }
}
