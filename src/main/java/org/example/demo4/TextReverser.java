package org.example.demo4;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TextReverser implements Model {
    public void print(Label resultLabel) {
        resultLabel.setText("і");
    }
    @Override
    public void printImage(ImageView imageView) {
    }
}