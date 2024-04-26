package Puzzle;

import cn.hutool.core.io.FileUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRegistration {
    public static void testUserAndPassword(){
        ArrayList<User> allUsers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        System.out.println("按1直接退出");

        AddUser(allUsers,checkUsername(sc),checkPassword(sc));


    }


    private static String checkPassword(Scanner sc) {
        while (true) {
            System.out.println("请输入密码(最少六位，至少包含一个小写字母，一个数字)");
            String password1 = sc.next();
            if (!password1.matches("^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[a-z])\\S*")){
                System.out.println("密码格式不正确");
            }else {
                while (true) {
                    System.out.println("请再次输入密码");
                    String password2 = sc.next();
                    if (!password1.equals(password2)){
                        System.out.println("两次密码不一样，请重设密码");
                    }else{
                        System.out.println("密码设置成功！");
                        return password2;
                    }
                }
            }


        }
    }

    private static String checkUsername(Scanner sc) {
        String username;
        while (true) {
            System.out.println("必须是字母或数字，长度在四到十六之间");
            username = sc.next();
            if (!username.matches("^[a-zA-Z0-9]{4,16}")){
                System.out.println("用户名格式不正确,请重新输入");
            }else{
                return username;
            }
        }
    }

    public static void AddUser(ArrayList<User>allUsers,String userName,String password){
        allUsers.add(new User(userName,password));
        FileUtil.writeLines(allUsers,
                "C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\UserInfo.txt",
                "UTF-8");
    }
}
