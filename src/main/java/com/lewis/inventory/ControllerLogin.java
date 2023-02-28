package com.lewis.inventory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ControllerLogin {
    private final Login l = new Login();
    private final Product p = new Product(0, null, null, 0, 0, null);

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtPass;

    @FXML
    private void btnLoginPress(ActionEvent event) throws IOException {
        if (l.login(txtUser.getText(), txtPass.getText())) {
            System.out.println("Logged in as account_id " + Login.account_id + " with username " + Login.username);
            ArrayList<Product> products = p.allProducts();

            for (Product item : products) {
                System.out.println(item.getProductId() + item.getName() + item.getDescription() + item.getCategoryId() + item.getQuantity() + item.getPrice().doubleValue());
            }

            // switch to dashboard

            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1250, 750);
            stage.setScene(scene);
            stage.show();

            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);

            //

        } else {
            System.out.println("Incorrect Login");
        }
    }

    @FXML
    private void btnCreatePress() {

    }
}