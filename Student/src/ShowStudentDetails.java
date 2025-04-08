import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
public class ShowStudentDetails {

    Connection con=null;
    ShowStudentDetails(){
        con=ConnectionProvider.getConnection();
        JFrame f=new JFrame("All Students");
        f.setVisible(true);
        f.setBounds(150,50,1100,500);
        f.getContentPane().setBackground(new Color(69, 199, 218));
        DefaultTableModel dtm=new DefaultTableModel();
        JTable t=new JTable(dtm);
        Font fo=new Font("Arial",Font.BOLD,13);
        t.setFont(fo);
        JScrollPane sp=new JScrollPane(t);
        f.getContentPane().add(sp);
        try{
            String query="select * from details";
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            int col=rs.getMetaData().getColumnCount();
            for(int i=1;i<=col;i++){
                dtm.addColumn(rs.getMetaData().getColumnName(i));
            }
            while(rs.next()){
                Object[] rowData=new Object[col];
                for(int i=1;i<=col;i++){
                    rowData[i-1]=rs.getObject(i);
                }
                dtm.addRow(rowData);
            }
            con.close();
            pstmt.close();
        }catch(
                SQLException e){
            throw new RuntimeException(e);
        }catch(NumberFormatException e){
            return;
        }
    }
}
