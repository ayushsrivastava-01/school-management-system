import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddNewAdmin extends Frame implements ActionListener {
    Connection con=null;
    Button b1,b2;
    TextField t1,t2;
    JLabel l,l1,l2;
    JFrame f;
    Font fo;
    AddNewAdmin(){
        setVisible(true);
        setTitle("Add New Admin");
        setBounds(350,180,600,400);
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("Resources/Admin.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,0,600, 400);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        b1=new Button("Add");
        b2=new Button("Cancel");
        t1=new TextField(180);
        t2=new TextField(180);
        l1=new JLabel("Enter Admin Name: ");
        l2=new JLabel("Password: ");

        fo=new Font("Arial",Font.BOLD,14);
        b1.setBounds(200,190,60,30);
        b2.setBounds(330,190,60,30);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        t1.setBounds(200,90,190,30);
        t2.setBounds(200,150,190,30);

        t1.setForeground(Color.blue);
        t2.setForeground(Color.blue);

        l1.setBounds(50,90,160,30);
        l2.setBounds(50,150,160,30);
        l1.setFont(fo);
        l2.setFont(fo);
        t1.setFont(fo);
        t2.setFont(fo);
        b1.setFont(fo);
        b2.setFont(fo);
        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l1);
        add(l2);

//        t2.setEchoChar('*');
        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setBackground(new Color(1021));
        b2.setBackground(Color.red);

        setResizable(false);
        add(l);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {
            if (t1.getText().equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(null, "Enter 'Admin Name and UID' first");
            } else {
                String name = t1.getText();
                String passw = t2.getText();
                con = ConnectionProvider.getConnection();
                try {
                    String query = "insert into admin(Name,Password)values(?,?)";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, name);
                    pstmt.setString(2, passw);
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    throw new RuntimeException();
                }
                t1.setText("");
                t2.setText("");
                f = new JFrame();
                JOptionPane.showMessageDialog(null, "Admin added Successfully...");
            }
        }
        else if (ae.getSource()==b2) {
            dispose();
        }
    }
}
