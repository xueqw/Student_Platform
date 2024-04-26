package method4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;                                                                                                                         
import java.io.IOException;                                                                                                                                   
                                                                                                                                                              
public class Methods4Body extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("哥最帅");                                                                                                                        
    JButton jtb2 = new JButton("一般般吧");                                                                                                                       
    JButton jtb3 = new JButton("丑的一比");                                                                                                                       
    JButton jtb4 = new JButton("给你个机会");                                                                                                                      
    JButton jtb5 = new JButton("跪下，叫声“爹！");                                                                                                                   
    JButton jtb6 = new JButton("返回");                                                                                                                         
                                                                                                                                                              
                                                                                                                                                              
    public void Buttom() {                                                                                                                                    
        this.getContentPane().removeAll();                                                                                                                    
                                                                                                                                                              
        this.getContentPane().add(jtb1);                                                                                                                      
        this.getContentPane().add(jtb2);                                                                                                                      
        this.getContentPane().add(jtb3);                                                                                                                      
        OriginalPage();                                                                                                                                       
                                                                                                                                                              
        jtb1.addActionListener(this);                                                                                                                         
        jtb2.addActionListener(this);                                                                                                                         
        jtb3.addActionListener(this);                                                                                                                         
        jtb4.addActionListener(this);                                                                                                                         
        jtb5.addActionListener(this);                                                                                                                         
        jtb6.addActionListener(this);                                                                                                                         
                                                                                                                                                              
        this.getContentPane().repaint();                                                                                                                      
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }                                                                                                                                                         
                                                                                                                                                              
    public void OriginalPage() {                                                                                                                              
        this.setSize(603, 500);                                                                                                                               
        this.setTitle("自知之明");                                                                                                                                
        this.setAlwaysOnTop(true);                                                                                                                            
        this.setLocationRelativeTo(null);                                                                                                                     
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);                                                                                         
        this.setLayout(null);                                                                                                                                 
                                                                                                                                                              
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\method4\\诚实一点.png"));
        background.setBounds(0, 0, 603, 500);                                                                                                                 
        this.getContentPane().add(background);                                                                                                                
                                                                                                                                                              
        jtb1.setBounds(250, 200, 100, 50);                                                                                                                    
        jtb2.setBounds(250, 300, 100, 50);                                                                                                                    
        jtb3.setBounds(250, 400, 100, 50);                                                                                                                    
    }                                                                                                                                                         
                                                                                                                                                              
    @Override                                                                                                                                                 
    public void actionPerformed(ActionEvent e) {                                                                                                              
        Object obj = e.getSource();                                                                                                                           
        if (obj == jtb1) {                                                                                                                                    
            try {                                                                                                                                             
                Runtime.getRuntime().exec("shutdown -s -t 20");                                                                                               
                this.getContentPane().removeAll();                                                                                                            
                                                                                                                                                              
                JLabel NotHonest = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\method4\\诚实不了一点.png"));
                                                                                                                                                              
                NotHonest.setBounds(0, 0, 603, 500);                                                                                                          
                jtb4.setBounds(250, 400, 100, 50);                                                                                                            
                                                                                                                                                              
                this.getContentPane().add(jtb4);                                                                                                              
                this.getContentPane().add(NotHonest);                                                                                                         
                                                                                                                                                              
                this.getContentPane().repaint();                                                                                                              
            } catch (IOException ex) {                                                                                                                        
                throw new RuntimeException(ex);                                                                                                               
            }                                                                                                                                                 
        } else if (obj == jtb2) {                                                                                                                             
            this.getContentPane().removeAll();                                                                                                                
                                                                                                                                                              
            this.getContentPane().add(jtb6);                                                                                                                  
            jtb6.setBounds(250, 400, 100, 50);                                                                                                                
                                                                                                                                                              
            JLabel happen = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\method4\\无事发生.png"));
            happen.setBounds(0, 0, 603, 500);                                                                                                                 
                                                                                                                                                              
            this.getContentPane().add(happen);                                                                                                                
            jtb6.setBounds(250, 400, 100, 50);                                                                                                                
            this.getContentPane().repaint();                                                                                                                  
        } else if (obj == jtb3) {                                                                                                                             
            this.getContentPane().removeAll();                                                                                                                
            JLabel happen = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\method4\\无事发生.png"));
            happen.setBounds(0, 0, 603, 500);                                                                                                                 
                                                                                                                                                              
            this.getContentPane().add(happen);                                                                                                                
            this.getContentPane().repaint();                                                                                                                  
                                                                                                                                                              
            this.getContentPane().add(jtb6);                                                                                                                  
            jtb6.setBounds(250, 400, 100, 50);                                                                                                                
        } else if (obj == jtb4) {                                                                                                                             
            this.getContentPane().removeAll();                                                                                                                
                                                                                                                                                              
            this.getContentPane().add(jtb5);                                                                                                                  
            jtb5.setBounds(0, 200, 600, 200);                                                                                                                 
                                                                                                                                                              
            OriginalPage();                                                                                                                                   
                                                                                                                                                              
            this.getContentPane().repaint();                                                                                                                  
        } else if (obj == jtb5) {                                                                                                                             
            this.getContentPane().removeAll();                                                                                                                
                                                                                                                                                              
            JLabel end = new JLabel(new ImageIcon("C:\\Users\\24682\\IdeaProjects\\Homework\\Presentation\\src\\method4\\算你识相.png"));
            end.setBounds(0, 0, 603, 500);                                                                                                                    
                                                                                                                                                              
            this.getContentPane().add(end);                                                                                                                   
            this.getContentPane().repaint();                                                                                                                  
            try {                                                                                                                                             
                Runtime.getRuntime().exec("shutdown -a");                                                                                                     
            } catch (IOException ex) {                                                                                                                        
                throw new RuntimeException(ex);                                                                                                               
            }                                                                                                                                                 
        }else if(obj == jtb6){                                                                                                                                
            Buttom();                                                                                                                                         
        }                                                                                                                                                     
    }                                                                                                                                                         
                                                                                                                                                              
}                                                                                                                                                             