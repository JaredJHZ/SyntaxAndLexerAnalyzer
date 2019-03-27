package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    String title;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.title = "IDE Metacompilador ------> [Documento]";
        System.out.println(getClass().getResource("menuMain.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("menuMain.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}