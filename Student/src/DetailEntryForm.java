import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class DetailEntryForm extends Frame implements ActionListener {
    Connection con=null;
    Button b1,b2;
    TextField t2,t3,t4,t5,t6,t7,t8,t9;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JFrame f1;
    JFrame f;
    Font fo,fon,font,fonts;
    Panel p;

    DetailEntryForm(){
        f=new JFrame("New User");
        f.setBounds(100,10,950,700);
        f.setVisible(true);
        f.setLayout(null);


        ImageIcon imageIcon=new ImageIcon("Resources/Student.jpg");
        l11=new JLabel(imageIcon);
        l11.setBounds(0,0,950,700);


        b1=new Button("Submit");
        b2=new Button("Cancel");

        t2=new TextField(180);
        t3=new TextField(180);
        t4=new TextField(180);
        t5=new TextField(180);
        t6=new TextField(180);
        t7=new TextField(180);
        t8=new TextField(180);
        t9=new TextField(180);

        l1=new JLabel("👍Registration Details👍");
        l2=new JLabel("1. Student Name: ");
        l3=new JLabel("2. Student Father's Name: ");
        l4=new JLabel("3. Student Mother's Name: ");
        l5=new JLabel("4. Date of Birth: ");
        l6=new JLabel("5. Gender: ");
        l7=new JLabel("6. UID: ");
        l8=new JLabel("7. Phone: ");
        l9 = new JLabel("8. E-mail: ");
        l10=new JLabel("* Note: Each Field is Mandatory");


        fo=new Font("Arial",Font.BOLD,18);
        fon=new Font("Arial",Font.BOLD,18);
        font=new Font("Arial",Font.BOLD,30);
        fonts=new Font("Arial",Font.PLAIN,17);

        l1.setBounds(300,10,400,100);
        l2.setBounds(250,180,240,30);
        l3.setBounds(250,220,240,30);
        l4.setBounds(250,260,240,30);
        l5.setBounds(250,300,240,30);
        l6.setBounds(250,340,240,30);
        l7.setBounds(250,380,240,30);
        l8.setBounds(250,420,240,30);
        l9.setBounds(250,460,240,30);
        l10.setBounds(400,105,200,30);

        t2.setBounds(500,180,240,30);
        t3.setBounds(500,220,240,30);
        t4.setBounds(500,260,240,30);
        t5.setBounds(500,300,240,30);
        t6.setBounds(500,340,240,30);
        t7.setBounds(500,380,240,30);
        t8.setBounds(500,420,240,30);
        t9.setBounds(500,460,240,30);

        b2.setBounds(500,520,70,35);
        b1.setBounds(675,520,70,35);

        l10.setForeground(Color.red);
        l1.setFont(font);
        l1.setForeground(new Color(57, 66, 237, 234));
        l2.setFont(fo);
        l3.setFont(fo);
        l4.setFont(fo);
        l5.setFont(fo);
        l6.setFont(fo);
        l7.setFont(fo);
        l8.setFont(fo);
        l9.setFont(fo);

        t2.setForeground(Color.blue);
        t3.setForeground(Color.blue);
        t4.setForeground(Color.blue);
        t5.setForeground(Color.blue);
        t6.setForeground(Color.blue);
        t7.setForeground(new Color(0, 109, 148));
        t8.setForeground(Color.blue);
        t9.setForeground(Color.blue);

        t2.setFont(fon);
        t3.setFont(fon);
        t4.setFont(fon);
        t5.setFont(fon);
        t6.setFont(fon);
        t7.setFont(fon);
        t8.setFont(fon);
        t9.setFont(fon);

        b1.setFont(fonts);
        b2.setFont(fonts);

        b1.setBackground(new Color(0,0,255));
        b2.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setBackground(Color.red);

        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);
        f.add(t8);
        f.add(t9);

        f.add(b1);
        f.add(b2);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(l10);

        f.add(l11);

        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setResizable(false);
    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            if (t2.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")|| t4.getText().equals("") ||t5.getText().equals("")||t6.getText().equals("")||t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("") || t9.getText().equals("")) {
                f1=new JFrame();
                JOptionPane.showMessageDialog(null, "Each field is mandatory...");
            }
            String name=t2.getText();
            String fname=t3.getText();
            String mname=t4.getText();
            String dname=t5.getText();
            String gname=t6.getText();
            String uname=t7.getText();
            String pname=t8.getText();
            String ename=t9.getText();

            con= ConnectionProvider.getConnection();
            try{
                String query="insert into details(Student_Name,Father_Name,Mother_Name,D_O_B,Gender,UID,Phone,E_mail) values(?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1,name);
                pstmt.setString(2,fname);
                pstmt.setString(3,mname);
                pstmt.setString(4,dname);
                pstmt.setString(5,gname);
                pstmt.setString(6,uname);
                pstmt.setString(7,pname);
                pstmt.setString(8,ename);

                pstmt.executeUpdate();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            f1=new JFrame();
            JOptionPane.showMessageDialog(null, "Student Added Successfully...");

            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
        }
        else if (ae.getSource()==b2) {
            f.dispose();
        }
    }
}
