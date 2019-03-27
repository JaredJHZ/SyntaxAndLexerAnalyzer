package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {
    @FXML
    MenuBar myMenuBar;
    @FXML
    TextArea guiInterface;


    @FXML
    TextArea numberLines;
    @FXML
    TextField name;
    @FXML
    MenuItem save;

    BufferedReader br = null;
    FileReader fr = null;
    File file = null;
    String info;

    @FXML public void initialize() {
            this.guiInterface.setOnKeyReleased(e -> {
                if(e.getCode() == KeyCode.ENTER) {
                    this.setNumberLines();
                }
            });

        save.setOnAction( e -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Jared Compiler File(*.jrd)", "*.jrd");
            fileChooser.getExtensionFilters().add(extFilter);


            Stage stage = (Stage) myMenuBar.getScene().getWindow();
            this.file = fileChooser.showSaveDialog(stage);

            if (this.file != null) {
                try {
                    PrintWriter writer;
                    writer = new PrintWriter(file);
                    writer.println(this.guiInterface.getText());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    @FXML private void closeButtonHandler(ActionEvent e) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();

    }

    @FXML private void openFileHandler(ActionEvent e) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir archivo");
        try{
            this.file = fileChooser.showOpenDialog(stage);
            String line;
            this.fr = new FileReader(file.getPath());
            this.br = new BufferedReader(fr);

            while((line = br.readLine()) != null) {
                this.guiInterface.appendText(line);
            }

            stage.setTitle(this.file.getName());


        }catch (IOException ex) {

            ex.printStackTrace();

        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }

    }

    @FXML private void newFileHandler() {
        this.guiInterface.setEditable(true);
        this.numberLines.setText("1");
    }

    @FXML private void setInfo(String info){
        this.info = info;
    }


    @FXML private void closeFileHandler(){
        try {
            Stage stage = (Stage) myMenuBar.getScene().getWindow();
            this.guiInterface.setText(null);
            this.guiInterface.setEditable(false);
            stage.setTitle("IDE Metacompilador ------> [Documento]");
            this.clearNumbers();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openStaticTokens (ActionEvent e) {
        try {
            System.out.println(getClass().getResource("tabla.fxml"));
            Parent root1 = FXMLLoader.load(getClass().getResource("tabla.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            System.out.println(getClass().getResource("tabla.fxml"));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private void setNumberLines() {
        int n = this.guiInterface.getText().split("\n").length;
        String cadena = "";
        for (int i = 0 ; i < n+1 ; i++) {
            cadena += String.valueOf(i+1)+"\n";
        }
        this.numberLines.setText(cadena);
    }

    private void clearNumbers() {
        this.numberLines.setText(null);
    }

}
