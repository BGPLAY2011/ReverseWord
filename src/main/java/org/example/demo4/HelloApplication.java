package org.example.demo4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Загружаем первое окно
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/demo4/view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Текст навпаки");
        stage.setScene(scene);
        stage.show();

        // Загружаем второе окно
        FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("/org/example/demo4/hello-view.fxml"));
        Scene secondScene = new Scene(secondLoader.load(), 500, 500);
        Stage secondStage = new Stage();
        secondStage.setTitle("Второе окно");
        secondStage.setScene(secondScene);
        secondStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
