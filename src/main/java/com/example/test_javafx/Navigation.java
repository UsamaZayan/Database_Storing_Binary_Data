package com.example.test_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Navigation {
    public final String MAIN_FXML = "views/start.fxml";
    public final String SHOW_IMAGE_FXML = "views/ShowImage.fxml";
    public final String SUMMIT_IMAGE_FXML = "views/InsertImage.fxml";

    public void navigateTo(Parent rootPane, String path) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            rootPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
