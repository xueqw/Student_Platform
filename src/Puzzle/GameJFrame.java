package Puzzle;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] arr = new int[4][4];

    int x = 0;
    int y = 0;
    //    记录空白方块在二维数组中的位置
    String path = "C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\Puzzle\\images\\";

    int step = 0;

    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登陆");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem Picture1 = new JMenuItem("xjy");









    public GameJFrame() {
        initJmenubBar();

        initJmenuBar();

        initData();

        initImage();

        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int index;
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            index = r.nextInt(tempArr.length);
            int temp = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arr[i / 4][i % 4] = tempArr[i];
        }
    }


    private void initImage() {
        this.getContentPane().removeAll();

        JLabel stepCount = new JLabel("步数: " + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = arr[i][j];
//                注意！！！这里的j在内层，i在外层，所以j是表示一行内的循环，i是表示每次新建一行
//                所以j为横坐标，i为纵坐标
                JLabel jLable = new JLabel(new ImageIcon(path + "05eb85119046d02c93051cf941b3c22_1 (" + num + ").gif"));
                jLable.setBounds(97 * j + 90, 97 * i + 147, 97, 97);
                this.getContentPane().add(jLable);
                jLable.setBorder(new BevelBorder(0));
            }
        }
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\Puzzle\\images\\画板 1.gif"));
        background.setBounds(35, -10, 500, 600);
        this.getContentPane().add(background);

        this.getContentPane().repaint();

    }


    private void initJmenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJmenu = new JMenu("功能");
        JMenu aboutJmenu = new JMenu("关于我们");

        JMenu pictureItem = new JMenu("更换图片");

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        pictureItem.addActionListener(this);

        pictureItem.add(Picture1);

        functionJmenu.add(replayItem);
        functionJmenu.add(reLoginItem);
        functionJmenu.add(closeItem);
        functionJmenu.add(pictureItem);

        aboutJmenu.add(accountItem);

        jMenuBar.add(functionJmenu);
        jMenuBar.add(aboutJmenu);


        this.setJMenuBar(jMenuBar);

    }

    private void initJmenubBar() {
        this.setSize(600, 608);

        this.setTitle("拼图单机版");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(3);

        this.setLayout(null);

        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "05eb85119046d02c93051cf941b3c22.jpg"));
            all.setBounds(83, 143, 400, 400);
            this.getContentPane().add(all);

            JLabel background = new JLabel(new ImageIcon(path + "画板 1.gif"));
            background.setBounds(35, -10, 500, 600);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            System.out.println("向左移动");
            arr[x][y] = arr[x][y + 1];
            arr[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            System.out.println("向上移动");
            arr[x][y] = arr[x + 1][y];
            arr[x + 1][y] = 0;
            x++;
            step++;
            initImage();
        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            System.out.println("向右移动");
            arr[x][y] = arr[x][y - 1];
            arr[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            System.out.println("向下移动");
            arr[x][y] = arr[x - 1][y];
            arr[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            arr = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            initImage();
        }


        this.getContentPane().repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            System.out.println("重新游戏");

            step = 0;
            initData();
            initImage();

        } else if (obj == reLoginItem) {
            System.out.println("重新登陆");
            this.setVisible(false);
        } else if (obj == accountItem) {
            System.out.println("公众号");
        }else if(obj == closeItem){
            System.out.println("关闭游戏");
        }
    }
}
