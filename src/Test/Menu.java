package Test;

import Puzzle.Test;
import StudentPlatform.PlatformLogInTest;
import method4.Methods4Body;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你的选择\n" +
                    "1.加法测试\n" +
                    "2.双色球系统\n" +
                    "3.拼图游戏\n" +
                    "4.诚实挑战\n" +
                    "5.学生平台");
            int i = sc.nextInt();
            switch (i) {
                case 1 -> method1();
                case 2 -> method2();
                case 3 -> method3();
                case 4 -> method4();
                case 5 -> method5();
                case 6 -> System.exit(0);
                default -> System.out.println("无效的选择");
            }
            System.out.println();
        }
    }

    private static void method1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("加法测试开始");
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(r.nextInt(101) + " + " + r.nextInt(101) + " =");
        }

    }

    private static void method2() {
        int[] allball = inputnumber();
        int[] realball = createnumber();
        int redcount = 0, bluecount = 0;
        for (int i = 0; i < allball.length - 1; i++) {
            for (int j = 0; j < allball.length - 1; j++) {
                if (allball[i] == realball[j]) {
                    redcount += 1;
                    break;
                }
            }
        }  //比较记录中奖个数


        if (allball[6] == realball[6]) {
            bluecount += 1;
        }
        if ((redcount == 0 && bluecount == 1) || (redcount == 1 && bluecount == 1) || (redcount == 2 && bluecount == 1)) {
            System.out.println("恭喜中了5元");
        } else if ((redcount == 3 && bluecount == 1) || (redcount == 4 && bluecount == 0)) {
            System.out.println("恭喜中了10元");
        } else if ((redcount == 4 && bluecount == 1) || (redcount == 5 && bluecount == 0)) {
            System.out.println("恭喜中了200元");
        } else if ((redcount == 5 && bluecount == 0)) {
            System.out.println("恭喜中了3000元");
        } else if ((redcount == 6 && bluecount == 0)) {
            System.out.println("恭喜中了500万元");
        } else if ((redcount == 6 && bluecount == 1)) {
            System.out.println("恭喜中了1000万元");
        } else {
            System.out.println("抱歉，未中奖");
        }  //输出结果
    }

    public static int[] inputnumber() {
        Scanner sc = new Scanner(System.in);
        int[] mynumber = new int[7];
        for (int i = 0; i < mynumber.length; ) {
            System.out.println("请输入您的第" + (i + 1) + "个双色球号码(前六个数字在1-33之间，最后一个数字在1-16之间)：");
            int waiting = sc.nextInt();
            if (i < 6) {
                if (check(mynumber, waiting)) {
                    if (waiting >= 1 && waiting <= 33) {
                        mynumber[i] = waiting;
                        i++;
                    } else {
                        System.out.println("数据超出范围，请重新输入");
                    }
                } else {
                    System.out.println("数据重复，请重新输入");
                }
            } else {
                mynumber[i] = waiting;
                i++;
            }
        }
        return mynumber;
    }  //获得兑奖人的兑奖号码

    public static int[] createnumber() {
        Random r = new Random();
        int[] list = new int[7];
        for (int i = 0; i < list.length - 1; ) {
            int temp = r.nextInt(33) + 1;
            if (check(list, temp)) {
                list[i] = temp;
                i++;
            }
        }
        list[6] = r.nextInt(16) + 1;
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        return list;
    }  //生成获奖结果

    public static boolean check(int[] arr, int number) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == number) {
                return false;
            }
        }
        return true;
    }  //判断是否重复

    private static void method3() {
        new Test().menu();
    }

    public static void method4() {
        new Methods4Body().Buttom();
    }

    private static void method5() {
        new PlatformLogInTest().logIn();
    }

}
