package org.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HelloController {

    public ImageView imageView;
    @FXML
    private Label resultLabel;

    private final Model model1 = new Photos();
    private final Model model2 = new ChuckJoke();
    private final Randomizer randomizer = new Randomizer();

    @FXML
    protected void onReverseButtonClick() {
        int i = randomizer.generate();
        if (i == 0){
            model1.printImage(imageView);
        }
        if (i == 1){
            model2.print(resultLabel);
        }
        i = -1;
    }
}
