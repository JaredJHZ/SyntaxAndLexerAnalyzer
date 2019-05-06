package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class Main extends Application {
    Boolean archivoGuardado;
    String title;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.title = "IDE Metacompilador ------> [Documento]";
        this.archivoGuardado = false;
        Parent root = FXMLLoader.load(getClass().getResource("menuMain.fxml"));
        primaryStage.setTitle(this.title);
        primaryStage.setScene(new Scene(root, 640, 500));
        primaryStage.setOnCloseRequest(e -> {
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
