package StudentPlatform;

import Test.Menu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlatformLogInTest {
    ArrayList<PlatformLodIn> list = new ArrayList<>();
    public void logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 登陆；2 注册；3 忘记密码; 4 退出");
        System.out.println("请输入选项");
        int choice = sc.nextInt();
        while (true) {
            switch (choice) {
                case 1 -> {
                    if (LogIn(list)) {
                        PlatformTest.ShitSystem();
                    }
                }
                case 2 -> registration(list);
                case 3 -> ForgetPassword(list);
                case 4 -> {
                    System.out.println("退出");
                    Menu.Menu();
                }
            }
        }
    }

    public void registration(ArrayList<PlatformLodIn> list) {
        PlatformLodIn li = new PlatformLodIn();
        String username = Name(list);
        String userpassword = password(list);
        String useridentity = identity(list);
        String userphonenumber = PhoneNumber(list);
        li.setName(username);
        li.setPassword(userpassword);
        li.setNumber(useridentity);
        li.setPhonenumber(userphonenumber);
        list.add(li);
        this.logIn();
    }

    public static String Name(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您的用户名");
            String name = sc.next();
            if (repeat(list, name) && length1(name) && character(name)) {
                System.out.println("用户名正确，加入成功");
                return name;
            } else {
                System.out.println("用户名错误，请再次输入");
            }
        }
    }
//    加入用户名

    public static boolean repeat(ArrayList<PlatformLodIn> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
//    判断用户名是否唯一

    public static boolean length1(String name) {
        if (name.length() >= 3 && name.length() <= 15) {
            return true;
        }
        return false;
    }
//    判断用户名长度

    public static boolean character(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) - 48 < 0 || name.charAt(i) - 48 > 9) {
                return true;
            }
        }
        return false;
    }
//    字母和数字组合

    public static String password(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入密码");
            String password1 = sc.next();
            System.out.println("请第二次输入密码");
            String password2 = sc.next();
            if (password2.equals(password1)) {
                System.out.println("密码设置成功");
                return password2;
            } else {
                System.out.println("密码设置失败");
            }

        }
    }
//    验证密码

    public static String identity(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入身份证号");
            String number = sc.next();
            if (number.matches("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$")) {
                return number;
            } else {
                System.out.println("格式不对，请重新输入");
            }
        }
    }

    public static String PhoneNumber(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入手机号码");
            String number = sc.next();
            if (number.matches("^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])|(18[0-9])|(19[8,9]))\\d{8}$")) {
                return number;
            } else {
                System.out.println("手机号存在问题");
            }
        }
    }
//    验证手机号


    public static boolean LogIn(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.next();
        if (ExistName(list, name)) {
            System.out.println("用户名正确");
            TestNumber();
            while (true) {
                if (ExistPassword(list)) {
                    System.out.println("登陆成功");
                    return true;
                }else {
                    System.out.println("登陆失败");
                }
            }
        }
        return false;
    }

    public static boolean ExistName(ArrayList<PlatformLodIn> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
//    判断用户名是否存在

    public static boolean ExistPassword(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码");
            String password = sc.next();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getPassword().equals(password)) {
                    System.out.println("密码正确");
                    return true;
                }
            }
        }
        System.out.println("已输入三次，自动退出");
        return false;
    }

    public static void TestNumber() {
        Random ra = new Random();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int i = 0; i < 4; i++) {
                int number = ra.nextInt(0, 10);
                sb.append(number);
            }
            String RealNumber = sb.toString();
            System.out.println(RealNumber);
            System.out.println("请输入验证码");
            String AcceptNumber = sc.next();
            if (AcceptNumber.equals(RealNumber)) {
                System.out.println("验证码正确");
                break;
            } else {
                System.out.println("验证码错误，请再试一次");
                sb.setLength(0);
            }
        }

    }


    public static void ForgetPassword(ArrayList<PlatformLodIn> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                String newPassword = sc.next();
                list.get(i).setPassword(newPassword);
            } else {
                System.out.println("用户名不存在");
            }
        }
    }
}
