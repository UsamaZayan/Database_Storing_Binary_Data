package com.example.test_javafx.controllers;

import com.example.test_javafx.Navigation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    
    @FXML
    public AnchorPane rootPane;

    Navigation nav = new Navigation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void on_insert_img() {
        nav.navigateTo(rootPane, nav.SUMMIT_IMAGE_FXML);
    }

    @FXML
    private void on_del_img() {
        nav.navigateTo(rootPane, nav.SHOW_IMAGE_FXML);
    }
}
