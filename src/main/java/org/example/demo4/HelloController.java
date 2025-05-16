package org.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField inputField;

    @FXML
    private Label resultLabel;

    private final TextReverser reverser = new TextReverser();

    @FXML
    protected void onReverseButtonClick() {
        String input = inputField.getText();
        String reversed = reverser.reverse(input);
        resultLabel.setText(reversed);
    }
}
