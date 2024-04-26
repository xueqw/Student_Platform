package Puzzle;

import java.util.Scanner;

public class Test {
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的选择 1.注册 2.登陆");
        int i = sc.nextInt();
        switch (i) {
            case 1 -> GameRegistration.testUserAndPassword();
            case 2 -> new GameLogIn().checkInfo();
        }

    }
}
