package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowImageController implements Initializable {

    @FXML
    private Button show_btn;
    @FXML
    private ImageView std_imgV;
    @FXML
    private TextField std_id_tf;
    @FXML
    private Label out_lbl;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button back_btn;


    //
    DBModel db = DBModel.getModel();
    Navigation nav = new Navigation();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void on_show_btn(ActionEvent event) {
        try {
            Image img = db.getPhoto(std_id_tf.getText());
            if (img != null){
                std_imgV.setImage(img);
                std_imgV.setFitHeight(180);
                std_imgV.setFitWidth(150);
                out_lbl.setText("Done");
            }else{
                out_lbl.setText("No Image");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowImageController.class.getName()).log(Level.SEVERE, null, ex);
            out_lbl.setText(ex.getMessage());
        }

    }

    @FXML
    private void on_back_btn(ActionEvent event) {
        nav.navigateTo(rootPane, nav.MAIN_FXML);
    }

}
