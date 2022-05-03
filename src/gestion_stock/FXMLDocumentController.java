package gestion_stock;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;


public class FXMLDocumentController implements Initializable {


    @FXML
    private ComboBox design;

    @FXML
    private TextField qtes;

    @FXML
    private TextField prix_unitair;

    @FXML
    private TextField prix_total;

    @FXML
    private TableView<facture> table_produit;

    @FXML
    private TableColumn<facture, Integer> col_id;

    @FXML
    private TableColumn<facture, String> col_designation;

    @FXML
    private TableColumn<facture, Integer> col_quantite;

    @FXML
    private TableColumn<facture, Integer> col_prix;

    @FXML
    private TableColumn<facture, String> col_date;

    ObservableList<facture> listM = FXCollections.observableArrayList();
    Connection conn = null;
    PreparedStatement pst = null;
    
    @FXML
    void btn_ajout(ActionEvent event) {
         int nb_qte, nb_unit;
        double resultat;

        nb_qte = Integer.parseInt(qtes.getText());
        nb_unit = Integer.parseInt(prix_unitair.getText());
        resultat = nb_unit * nb_qte;
        prix_total.setText(String.valueOf(resultat));
        
        conn = connection.connectbd();
        String sql = "insert into facture(designation,quantite,prix_unitaire,prix_total) values(?,?,?,?)";
        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, design.getValue().toString());
            pst.setString(2, qtes.getText());
            pst.setString(3, prix_unitair.getText());
            pst.setString(4, prix_total.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "enregistrée");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        @FXML
    void btn_actualiser(ActionEvent event) {
        col_id.setCellValueFactory(new PropertyValueFactory<facture, Integer>("id"));
        col_designation.setCellValueFactory(new PropertyValueFactory<facture, String>("designation"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<facture, Integer>("quantite"));
        col_prix.setCellValueFactory(new PropertyValueFactory<facture, Integer>("prix_total"));
        col_date.setCellValueFactory(new PropertyValueFactory<facture, String>("date"));
        
        listM = connection.insertDonner();
        table_produit.setItems(listM);
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        design.getItems().addAll("chemise","pentalon");
        
        col_id.setCellValueFactory(new PropertyValueFactory<facture, Integer>("id"));
        col_designation.setCellValueFactory(new PropertyValueFactory<facture, String>("designation"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<facture, Integer>("quantite"));
        col_prix.setCellValueFactory(new PropertyValueFactory<facture, Integer>("prix_total"));
        col_date.setCellValueFactory(new PropertyValueFactory<facture, String>("date"));
        listM = connection.insertDonner();
        table_produit.setItems(listM);
    }    
    
}
