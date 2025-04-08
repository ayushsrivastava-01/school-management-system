import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener{
    JFrame f;
    JLabel l,l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Font f1,f2;
    Admin(){
        f=new JFrame("Admin Page...");
        f.setBounds(100,10,1224,800);
        f.setLayout(null);
        f.setVisible(true);

        ImageIcon imageIcon=new ImageIcon("Resources/Page.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,0,1224,800);

        b1=new JButton("Register a new Student");
        b2=new JButton("Search a Student");
        b3=new JButton("Remove a Student");
        b4=new JButton("Show Details Table");
        b5=new JButton("Add new Admin");
        b6=new JButton("Remove Admin");
        b7=new JButton("All admin");
        b8=new JButton("Log Out");

        l1=new JLabel("~Student's Details~");
        l2=new JLabel("~Admin Details~");

        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.blue);

        l1.setBounds(450,15,500,50);
        l2.setBounds(450,350,500,50);

        b1.setBounds(450,110,290,70);
        b2.setBounds(160,180,290,70);
        b3.setBounds(450,250,290,70);
        b4.setBounds(740,180,290,70);

        b5.setBounds(450,430,290,70);
        b6.setBounds(160,500,290,70);
        b7.setBounds(740,500,290,70);
        b8.setBounds(450,570,290,70);

        f1=new Font("Arial",Font.ITALIC|Font.BOLD,33);
        f2=new Font("Arial",Font.ITALIC|Font.BOLD,22);

        l1.setFont(f1);
        l2.setFont(f1);
        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f2);
        b6.setFont(f2);
        b7.setFont(f2);
        b8.setFont(f2);

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);

        f.add(l1);
        f.add(l2);

        b1.setBackground(new Color(75, 0, 130));
        b2.setBackground(new Color(75,0,130));
        b3.setBackground(new Color(75,0,130));
        b4.setBackground(new Color(75,0,130));
        b5.setBackground(new Color(75,0,130));
        b6.setBackground(new Color(75,0,130));
        b7.setBackground(new Color(75,0,130));
        b8.setBackground(Color.red);
        f.add(l);


        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
        b6.setForeground(Color.white);
        b7.setForeground(Color.white);
        b8.setForeground(Color.white);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        f.setResizable(false);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new DetailEntryForm();
        }
        else if (ae.getSource()==b2) {
            new Search();
        }
        else if (ae.getSource()==b3) {
            new DeleteStudent();
        }
        else if (ae.getSource()==b4) {
            new ShowStudentDetails();
        }
        else if (ae.getSource()==b5) {
            new AddNewAdmin();
        }
        else if (ae.getSource()==b6) {
            new DeleteAdmin();
        }
        else if (ae.getSource()==b7) {
            new ShowAdminDetails();
        }
        else if (ae.getSource()==b8) {
            f.dispose();
        }
    }
}
