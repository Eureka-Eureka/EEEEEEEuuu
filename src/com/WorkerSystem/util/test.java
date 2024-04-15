package com.WorkerSystem.util;

import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff;

public class test {
    public static void main(String[] args) throws Exception {
        /*AdminDAO adminDAO = new AdminDAOimpl();
        List<Staff> list = adminDAO.GetWorker_inf();*/

        /*String n1 = "001";
        String n2 = "0a1";

        boolean b1 = n1.matches("[0-9]+");
        boolean b2 = n2.matches("[0-9]+");
        System.out.println(b1);
        System.out.println(b2);*/

        /*String str = "";

        String str2 = "";

        System.out.println(str.equals(str2));*/



        /*Collections.sort(list, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff o1, Staff o2) {
                        return o2.getAge()-o1.getAge();
                    }//降序
                });

                System.out.println(list);
    }*/

        /*StaffAccountDAO StaffAccount = new StaffAccountDAOimpl();
        List<Staff_Account> list1 = StaffAccount.GetAccount();
        System.out.println(list1);*/


        /*try {
            // 调用生成验证码方法
            BufferedImage captchaImage = CaptchaGenerator.generateCaptcha();

            // 保存验证码图片到文件
            File output = new File("captcha.png");
            ImageIO.write(captchaImage, "png", output);


            System.out.println("验证码已生成并保存到文件 captcha.png");
            System.out.println(CaptchaGenerator.getCaptcha());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*BufferedImage image = CaptchaGenerator.generateCaptcha();
        String captcha = CaptchaGenerator.getCaptcha();
        CaptchaGenerator.saveImage(image);
        System.out.println(captcha);*/

        StaffDAO staffDAO = new StaffDAOimpl();
        Staff staff = staffDAO.GetStaffByID("12");
        System.out.println(staff);
    }
}
