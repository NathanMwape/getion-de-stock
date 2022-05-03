package gestion_stock;

import java.sql.*;
import javafx.collections.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class connection {

    Connection conn = null;

    public static Connection connectbd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/autre", "root", "");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /**
     *
     * @return
     */

         
        public static ObservableList<facture> insertDonner() {
        Connection cons = connectbd();
        ObservableList<facture> list = FXCollections.observableArrayList();
        try {

            PreparedStatement ps = cons.prepareStatement("select *from facture");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            list.add(new facture(rs.getString("designation"), rs.getString("date_article"), Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("quantite")), Integer.parseInt(rs.getString("prix_unitaire")), Integer.parseInt(rs.getString("prix_total"))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }finally{
            try {
                
            } catch (Exception e) {
            }
        }
        return list;
    }

}
