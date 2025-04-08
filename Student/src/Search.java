import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Search extends JFrame implements ActionListener{
    Connection con=null;
    JTextField t1;
    JFrame f;
    JButton b1,b2;
    JTable rt;
    JLabel l,l1;
    Search(){
        setTitle("Search Student");
        setBounds(450,120,600,400);
        setLayout(null);

        ImageIcon imageIcon=new ImageIcon("Resources/Student.jpg");
        l=new JLabel(imageIcon);
        l.setBounds(0,0,600, 400);

        t1=new JTextField(20);
        b1=new JButton("Search");
        b2=new JButton("Exit");
        b1.setBackground(new Color(7, 135, 0));
        b2.setBackground(new Color(237, 0, 0));
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        l1=new JLabel("Enter Student 'UID' to search: ");
        Font f=new Font("Arial", Font.BOLD|Font.ITALIC, 16);
        Font f1=new Font("Arial", Font.BOLD|Font.ITALIC, 13);
        l1.setBounds(50,90,250,30);
        t1.setBounds(320,90,200,30);
        b1.setBounds(320,150,80,40);
        b2.setBounds(440,150,80,40);

        l1.setFont(f);
        t1.setFont(f);
        b1.setFont(f1);
        b2.setFont(f1);

        t1.setForeground(Color.blue);

        add(l1);
        add(t1);
        add(b1);
        add(b2);
        add(l);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            dispose();
        }
        else if (ae.getSource()==b1) {
            if (t1.getText().equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(null, "Enter a 'UID' first");
            } else {
                con = ConnectionProvider.getConnection();
                JFrame f = new JFrame("All Students");
                DefaultTableModel dtm = new DefaultTableModel();
                JTable t = new JTable(dtm);
                Font fo=new Font("Arial",Font.BOLD,13);
                t.setFont(fo);
                JScrollPane sp = new JScrollPane(t);
                f.getContentPane().add(sp);
                try {
                    String query = "select * from details where UID=?;";
                    String val = t1.getText();
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, val);
                    ResultSet rs = pstmt.executeQuery();
                    int col = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= col; i++) {
                        dtm.addColumn(rs.getMetaData().getColumnName(i));
                    }
                    while (rs.next()) {
                        Object[] rowData = new Object[col];
                        for (int i = 1; i <= col; i++) {
                            rowData[i - 1] = rs.getObject(i);
                        }
                        dtm.addRow(rowData);
                    }
                    t1.setText("");
                    con.close();
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter a valid UID...");
                    return;
                }
                f.setBounds(300, 200, 900, 300);
                f.setVisible(true);
            }
        }
    }
}