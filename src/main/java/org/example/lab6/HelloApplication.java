package org.example.lab6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Створюємо квадрат
        Rectangle square = new Rectangle(100, 100);
        square.setFill(Color.TRANSPARENT);
        square.setStroke(Color.BLACK);

        // Створюємо кнопку "Залити жовтим"
        Button yellowButton = new Button("Залити жовтим");
        yellowButton.setOnAction(e -> square.setFill(Color.YELLOW));

        // Створюємо кнопку "Залити червоним"
        Button redButton = new Button("Залити червоним");
        redButton.setOnAction(e -> square.setFill(Color.RED));

        // Створюємо кнопку "Додати надпис"
        Button textButton = new Button("Додати надпис");
        textButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Введіть текст");
            dialog.setHeaderText(null);
            dialog.setContentText("Введіть текст:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(text -> {
                Text newText = new Text(text);
                newText.setFont(Font.font(15));
                StackPane.setAlignment(newText, javafx.geometry.Pos.CENTER);
                ((StackPane) primaryStage.getScene().getRoot()).getChildren().add(newText);
            });
        });

        // Використовуємо HBox для розташування кнопок в ряд
        HBox buttonBox = new HBox(10); // 10 - відступ між кнопками
        buttonBox.getChildren().addAll(yellowButton, redButton, textButton);
        buttonBox.setPadding(new Insets(10)); // відступи від країв

        // Розміщуємо квадрат та кнопки на макеті StackPane
        StackPane root = new StackPane();
        root.getChildren().addAll(square, buttonBox);

        // Створюємо сцену
        Scene scene = new Scene(root, 300, 250);

        // Встановлюємо сцену для primaryStage та відображаємо його
        primaryStage.setScene(scene);
        primaryStage.setTitle("Малювання та кнопки");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
