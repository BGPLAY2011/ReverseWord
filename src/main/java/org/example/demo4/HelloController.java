package org.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField inputField;

    @FXML
    private Label resultLabel;

    @FXML
    protected void onReverseButtonClick() {
        String input = inputField.getText();
        String reversed = new StringBuilder(input).reverse().toString();
        resultLabel.setText(reversed);
    }
}
