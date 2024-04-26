package StudentPlatform;

import java.util.ArrayList;
import java.util.Scanner;

public class PlatformTest{
    private static final int ADD_SHIT = 1;
    private static final int DELETE_SHIT = 2;
    private static final int REVISE_SHIT = 3;
    private static final int REQUIRE_SHIT = 4;
    private static final int EXIT = 5;



    public static void ShitSystem () {
        ArrayList<Platform> list = new ArrayList<>();
        System.out.println("----------------欢迎来到答辩管理系统----------------");
        while (true) {
            System.out.println("1:添加答辩");
            System.out.println("2:删除答辩");
            System.out.println("3:修改答辩");
            System.out.println("4:查询答辩");
            System.out.println("5:退出");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("请输入您的选择");
            int choice2 = sc2.nextInt();
            switch (choice2) {
                case ADD_SHIT -> add(list);
                case DELETE_SHIT -> delete(list);
                case REVISE_SHIT -> {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("请输入要修改答辩的id");
                    String newid = sc1.next();
                    revise(list,newid);
                }
                case REQUIRE_SHIT -> queryStudent(list);
                case EXIT -> {
                    System.out.println("退出");
                    new PlatformLogInTest().logIn();
                }

            }

        }

    }

    public static void add(ArrayList<Platform> list){
        System.out.println("添加答辩");
        Platform pf = new Platform();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入答辩id");
        String id = sc.next();
        if(repeat(list,id)){
            pf.setId(id);

            System.out.println("请输入答辩姓名");
            String name = sc.next();
            pf.setName(name);

            System.out.println("请输入答辩年龄");
            int age = sc.nextInt();
            pf.setAge(age);

            System.out.println("请输入答辩地址");
            String address = sc.next();
            pf.setAddress(address);

            list.add(pf);
            System.out.println("添加成功");
        }else{
            System.out.println("id重复");
        }
    }
//    添加学生

    public static void delete(ArrayList<Platform> list){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要删除的id");
        String id = sc.next();
        int index = Index(list,id);
        if (index == -1){
            System.out.println("此id不存在");
        }else {
            list.remove(index);
            System.out.println("删除成功");
        }
    }

    public static void revise(ArrayList<Platform> list,String id){
        System.out.println("修改答辩");
        int index = Index(list,id);
        if(index == -1){
            System.out.println("不存在");
        }else{
            Scanner sc = new Scanner(System.in);
            Platform newstudent = list.get(index);

            System.out.println("请输入姓名");
            String name = sc.next();
            newstudent.setName(name);

            System.out.println("请输入年龄");
            int age  = sc.nextInt();
            newstudent.setAge(age);

            System.out.println("请输入地址");
            String address = sc.next();
            newstudent.setAddress(address);

            System.out.println("修改成功");
        }
    }

    public static boolean repeat(ArrayList<Platform> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return false;
            }
        }
        return true;
    }
//    检验是否与原有集合中id重复

    public static void queryStudent(ArrayList<Platform> list){
        System.out.println("查询答辩");
        if (list.isEmpty()){
            System.out.println("当前无答辩信息，请添加后再查询");
            return;
        }else{
            System.out.println("id\t姓名\t年龄\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getAge() + "\t" + list.get(i).getAddress());
            }
        }
    }

    public static int Index(ArrayList<Platform> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
//    根据id找到对应索引
}