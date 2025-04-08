
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener{
    Frame f;
    Button b3,b4;
    JLabel l,l1;
    Font fo;
    Image bi;
    Start() {
        f=new Frame("Login Interface");
        f.setBounds(300,150,800, 500);
        f.setVisible(true);
        f.setLayout(null);
        ImageIcon imageIcon=new ImageIcon("Resources/Start.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,30,800, 500);
        b3=new Button("Administrator Login");
        b4=new Button("Exit");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        fo=new Font("Arial",Font.ITALIC|Font.BOLD,30);
        l1=new JLabel("~Student's Detail Page~");

        l1.setForeground(Color.yellow);
        l1.setFont(fo);
        l1.setBounds(235,20,450,80);

        f.add(l1);
        f.setResizable(false);


        b3.setBounds(230,200,350,60);
        b4.setBounds(230,300,350,60);


        b3.setBackground(Color.white);
        b4.setBackground(Color.white);

        b3.setFont(fo);
        b4.setFont(fo);

        f.add(b3);
        f.add(b4);


        f.add(l);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b3){
            new AdminLogin();
        } else if (ae.getSource()==b4) {
            System.exit(0);
        }
    }
}