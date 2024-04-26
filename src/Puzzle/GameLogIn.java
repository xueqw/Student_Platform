package Puzzle;

import cn.hutool.core.io.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Test.Menu;



public class GameLogIn {
    ArrayList<User>arrayList = new ArrayList<>();
    public void checkInfo(){
        Scanner sc = new Scanner(System.in);

        readUserInfo();

        while (true) {
            for (User user : arrayList) {
                System.out.println("请输入用户名");
                String userName = sc.next();
                if (user.getUsername().equals(userName)){
                    System.out.println("用户名存在");
                    while (true) {
                        System.out.println("请输入密码");
                        String password = sc.next();
                        if (user.getPassword().equals(password)){
                            System.out.println("密码正确");
                            System.out.println("登陆成功");
                            new GameJFrame();
                            Menu.Menu();
                        }else{
                            System.out.println("密码错误，请重新输入");
                        }
                    }
                }else{
                    System.out.println("用户名不存在，请重新输入");
                }
            }
        }


    }
    public void readUserInfo(){
        List<String> userInfoList = FileUtil.readUtf8Lines("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\UserInfo.txt");
        for (String s : userInfoList) {
            String[] arr = s.split("&");
            String[] arr1 = arr[0].split("=");
            String[] arr2 = arr[1].split("=");
            User u = new User(arr1[1],arr2[1]);
            arrayList.add(u);
        }


    }
}

