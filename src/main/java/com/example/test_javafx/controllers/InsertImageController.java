package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import com.example.test_javafx.models.DBModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InsertImageController implements Initializable {

    DBModel db = DBModel.getModel();
    Navigation nav = new Navigation();
    @FXML
    private TextField std_id_ta;
    @FXML
    private Label out_lbl;
    @FXML
    private TextField path_ta;
    @FXML
    private AnchorPane rootPane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void on_brs_btn(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(("png image"), "*.png"));
        File f = fileChooser.showOpenDialog(null);
        path_ta.setText(f.getAbsolutePath());
    }

    @FXML
    private void on_sbmt_btn(ActionEvent event) {

        int isValidId = 0;
        try {
            isValidId = db.isIdValid(std_id_ta.getText());
        } catch (SQLException ex) {
            //Logger.getLogger(InsertImageController.class.getName()).log(Level.SEVERE, null, ex);
            out_lbl.setText(ex.getMessage());
        }

        if (isValidId == 1) {
            try {
                db.insertPhoto(path_ta.getText(), std_id_ta.getText());
                out_lbl.setText("Student Picture Has Been Submited");

            } catch (SQLException | IOException ex) {
                out_lbl.setText(ex.getMessage());
            }
        } else {
            out_lbl.setText("ID is not valid");
        }

    }

    @FXML
    private void on_back_btn(ActionEvent event) {
        nav.navigateTo(rootPane, nav.MAIN_FXML);
    }

}
