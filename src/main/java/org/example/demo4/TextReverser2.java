package org.example.demo4;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TextReverser2 implements Model {
    public void print(Label resultLabel) {
        resultLabel.setText("ііі");
    }
    @Override
    public void printImage(ImageView imageView) {
    }
}