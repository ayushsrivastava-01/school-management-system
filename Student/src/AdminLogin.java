import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends Frame implements ActionListener {
    Connection con=null;
    Button b1,b2;
    TextField t1,t2;
    JLabel l,l1,l2;
    JFrame f1;
    Frame f;
    Font fo;

    AdminLogin(){
        setVisible(true);
        setTitle("Login Page");
        setBounds(450,200,500,400);
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("Resources/AdminLogin.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,30,600, 400);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        b1=new Button("Login");
        b2=new Button("Cancel");
        t1=new TextField(180);
        t2=new TextField(180);
        l1=new JLabel("Enter Username: ");
        l2=new JLabel("Password: ");
        fo=new Font("Arial",Font.BOLD,14);
        b1.setBounds(150,190,60,30);
        b2.setBounds(290,190,60,30);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b1.setFont(fo);
        b2.setFont(fo);
        t1.setBounds(150,90,200,30);
        t2.setBounds(150,150,200,30);
        l1.setBounds(10,90,140,30);
        l2.setBounds(10,150,140,30);

        l1.setForeground(Color.white);
        l2.setForeground(Color.white);

        t1.setForeground(Color.blue);
        t2.setForeground(Color.red);

        l1.setFont(fo);
        l2.setFont(fo);
        t1.setFont(fo);
        t2.setFont(fo);

        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l1);
        add(l2);

        add(l);

        t2.setEchoChar('*');
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBackground(new Color(1021));
        b2.setBackground(Color.red);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            if(t1.getText().equals("") || t2.getText().equals("")){
                f1=new JFrame();
                JOptionPane.showMessageDialog(null, "Username and password is needed to Login...");
            }
            else {
                con = ConnectionProvider.getConnection();
                String query = "select * from admin;";
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        String passw = rs.getString("Password");
                        if (t1.getText().equals(name) && t2.getText().equals(passw)) {
                            dispose();
                            new Admin();
                            break;
                        }
//                            t1.setText("Enter correct admin name...");
//                            t2.setText("Enter correct...");
//                            Thread.sleep(500);
//                            t1.setText("");
//                            t2.setText("");
//                            break;
                    }
                    con.close();
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
//                catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
        else if(ae.getSource()==b2){
            dispose();
            new Start();
        }
    }
}
