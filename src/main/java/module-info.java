module org.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires telegrambots.meta;
    requires telegrambots;


    opens org.example.demo4 to javafx.fxml;
    exports org.example.demo4;
}