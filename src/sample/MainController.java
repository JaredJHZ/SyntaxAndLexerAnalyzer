package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lexer.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class MainController {

    // Atributos

    ArrayList<Token> lex1;

    ObservableList<TK> tks = FXCollections.observableArrayList();

    ObservableList<Token> data;

    BufferedReader br = null;

    FileReader fr = null;

    File file = null;

    String info;

    boolean archivoGuardado = false;

    // Componentes de fxml

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
    @FXML
            TextArea message;



    @FXML public void initialize() {



            this.guiInterface.setOnKeyReleased(e -> {
                if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.BACK_SPACE) {
                    this.setNumberLines();
                }
            });

            this.save.setOnAction( e -> {

                Stage stage = (Stage) myMenuBar.getScene().getWindow();

            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Jared Compiler File(*.jrd)", "*.jrd");

            fileChooser.getExtensionFilters().add(extFilter);

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

        this.newFileHandler();


    }

    @FXML private void closeButtonHandler(ActionEvent e) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        if(!this.archivoGuardado){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Archivo no guardado");
            alert.setHeaderText("Archivo no guardado");
            alert.setContentText("Desea guardar el archivos?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK){


                FileChooser fileChooser = new FileChooser();

                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Jared Compiler File(*.jrd)", "*.jrd");

                fileChooser.getExtensionFilters().add(extFilter);

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

            } else {
                System.out.println("no guardado");
            }
        }
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
            Parent root1 = FXMLLoader.load(getClass().getResource("tabla.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            System.out.println(getClass().getResource("tabla.fxml"));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openStaticRelTokens (ActionEvent e) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("tablaR.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openLogicStaticTokens (ActionEvent e) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("LogicTable.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openWordsTokens(ActionEvent e) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("CharacterTable.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openSpecialCharacter(ActionEvent e) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("SpecialChTable.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void openDynamicTable(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DynamicTable.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            DynamicTableController controller = loader.getController();

            controller.setData(this.data);
            stage.showAndWait();

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML private void openProfile(ActionEvent e) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("profile.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML private void doLexer(){
        Lexer2 lex = new Lexer2();

        Scanner sn = new Scanner(this.guiInterface.getText());

        String res = "";

        while (sn.hasNextLine()){
            res += sn.nextLine() + " newL ";
        }

        this.lex1 = lex.lex(res);


        this.data = FXCollections.observableArrayList(lex1);



    }

    @FXML private void doSyntax(){

        this.tks.clear();

        doLexer();

        for(Token tk : this.lex1) {
            this.tks.add(new TK(tk.getValor(), tk.getTipo(), tk.getGrupo(), tk.getLinea()));
        }

        Syntax sx = new Syntax();

        sx.addElements(this.tks);

        var errores = sx.effectSyntax();

        if(errores == null || errores.isEmpty()) {
            this.message.setText("Programa compilado con exito");
        } else {
            for(var error: errores) {
                this.message.setText("Error en linea: " + error.getLinea());
            }
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

    @FXML private void copy() {
        this.guiInterface.copy();
    }

    @FXML private void paste() {
        if(Clipboard.getSystemClipboard().hasString()) {
            this.guiInterface.paste();
        }
    }

    @FXML private void cut() {
        this.guiInterface.getSelectedText();
    }





}
