package org.example.demo4;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChuckJoke implements Model{
    public String getRandomChuckJoke() {
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            JSONObject json = new JSONObject(response.toString());
            return json.getString("value");
        } catch (Exception e) {
            e.printStackTrace();
            return "Помилка отримання жарту.";
        }
    }
    public void print(Label resultLabel) {
        resultLabel.setText(getRandomChuckJoke());
    }
    @Override
    public void printImage(ImageView imageView) {
    }
}