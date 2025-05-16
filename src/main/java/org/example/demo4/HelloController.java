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
        TextReverser reverser = new TextReverser();
        String reversed = reverser.reverse(input);
        resultLabel.setText(reversed);
    }
}
