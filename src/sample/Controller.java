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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {
    @FXML
    MenuBar myMenuBar;
    @FXML
    TextArea guiInterface;
    @FXML
    Button save;
    @FXML
    Button cancel;
    @FXML
    TextField name;

    BufferedReader br = null;
    FileReader fr = null;
    File file = null;
    String info;

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
    }

    @FXML private void openSaveHandler() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("guardar.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            Controller controller = loader.getController();
            String info = this.guiInterface.getText();
            controller.setInfo(info);
            stage.showAndWait();


        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void setInfo(String info){
        this.info = info;
    }

    @FXML private void saveFileHandler() {
        try {
            File file = new File(  this.name.getText()+".jrd");
            if (file.createNewFile()) {
                System.out.println("Nuevo archivo creado");
                FileWriter writer ;
                writer = new FileWriter(file);
                writer.write(info);
                writer.close();
                Stage stage = (Stage) this.name.getScene().getWindow();
                stage.close();
            }

        }catch (IOException exi) {
            exi.printStackTrace();
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

}
