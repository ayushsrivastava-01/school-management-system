import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteStudent extends JFrame implements ActionListener {
    Connection con = null;
    JFrame f;
    JLabel l1,l2,l;
    JButton b1, b2;
    JTextField t1;

    DeleteStudent() {
        setVisible(true);
        setTitle("Remove Student");
        setBounds(350, 150, 600, 400);
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("Resources/Student.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,0,600, 400);

        b1 = new JButton("Delete");
        b2 = new JButton("Cancel");
        l1 = new JLabel("Enter Student 'UID' to Remove: ");
        t1 = new JTextField(100);

        b1.setBackground(new Color(34, 34, 95));
        b2.setBackground(new Color(237, 0, 0));
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        Font f = new Font("Arial", Font.ITALIC | Font.BOLD, 16);
        Font fb = new Font("Arial", Font.ITALIC | Font.BOLD, 13);
        l1.setBounds(50, 90, 250, 30);
        t1.setBounds(320, 90, 200, 30);
        b1.setBounds(320, 150, 80, 40);
        b2.setBounds(440, 150, 80, 40);

        t1.setForeground(Color.blue);

        add(l1);
        add(t1);
        add(b1);
        add(b2);

        l1.setFont(f);
        t1.setFont(f);
        b1.setFont(fb);
        b2.setFont(fb);

        add(l);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            if (t1.getText().equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(null, "Enter a 'UID' first");
            }
            else {
                con = ConnectionProvider.getConnection();
                String query = "delete from details where UID=?;";
                try {
                    String val = t1.getText();
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, val);
                    int rd = pstmt.executeUpdate();
                    if (rd > 0) {
                        f = new JFrame();
                        JOptionPane.showMessageDialog(null, "Student Deleted Successfully...");
                        t1.setText("");
                    } else {
                        f = new JFrame();
                        JOptionPane.showMessageDialog(null, "'UID' not Found...");
                        t1.setText("");
                    }
                } catch (SQLException e) {
                    f = new JFrame();
                    JOptionPane.showMessageDialog(null, "Invalid 'UID'...");
                }
            }
        } else if (ae.getSource()==b2) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteStudent();
    }
}