package org.example.demo4;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class Photos implements Model{
    private final String internetImageUrl = "https://picsum.photos/600/400";
    public Image getRandomInternetImage() {
        try {
            URL url = new URL(internetImageUrl);
            File tempFile = File.createTempFile("random_", ".jpg");
            try (var in = url.openStream()) {
                Files.copy(in, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            }
            return new Image(new FileInputStream(tempFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void print(Label resultLabel) {
    }
    @Override
    public void printImage(ImageView imageView) {
        imageView.setImage(getRandomInternetImage());
    }
    public File getRandomInternetImageAsFile() {
        try {
            URL url = new URL("https://picsum.photos/600/400");
            File tempFile = File.createTempFile("photo_", ".jpg");
            try (var in = url.openStream()) {
                Files.copy(in, tempFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
