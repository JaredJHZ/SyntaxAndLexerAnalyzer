package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    @FXML private void openSaveHandler() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("guardar.fxml"));
            Stage newS = new Stage();
            newS.setScene(new Scene(loader.load()));
            Controller controller = loader.getController();
            if(this.guiInterface != null) {
                String info = this.guiInterface.getText();
            }
            controller.setInfo(info);
            newS.showAndWait();


        }catch (IOException ex) {
            System.out.println(this.guiInterface.getText());
            System.out.println(ex.getMessage());
        }
    }

    @FXML private void setInfo(String info){
        this.info = info;
    }

    @FXML private void saveFileHandler() {
        try {
            this.file = new File(  this.name.getText()+".jrd");
            if (file.createNewFile()) {
                System.out.println("Nuevo archivo creado");
                FileWriter writer ;
                writer = new FileWriter(file);
                writer.write(info);
                writer.close();
                Stage stage = (Stage) this.name.getScene().getWindow();
                stage.setTitle(this.file.getName());
                stage.close();
            }

        }catch (IOException exi) {
            System.out.println(exi.getMessage());
        }finally {

        }
    }

    @FXML private void cancelHandler() {
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
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
