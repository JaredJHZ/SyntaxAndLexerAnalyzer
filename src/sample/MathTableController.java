package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class MathTableController {
    @FXML
    TableView tabla;

    @FXML void initialize() {
        final ObservableList<Operators> data = FXCollections.observableArrayList(
                new Operators("+",     "1",    "1" ),
                new Operators("-",  "2",  "1" ),
                new Operators("/",     "3", "1" ),
                new Operators("*",      "4",    "1" )
        );
        TableColumn operator = new TableColumn();
        operator.setText("operator");
        operator.setCellValueFactory(new PropertyValueFactory("operator"));
        TableColumn idem = new TableColumn();
        idem.setText("idem");
        idem.setCellValueFactory(new PropertyValueFactory("idem"));
        TableColumn ai = new TableColumn();
        ai.setText("ai");
        ai.setCellValueFactory(new PropertyValueFactory("ai"));
        tabla.setItems(data);
        tabla.getColumns().addAll(operator, idem, ai);


    }



}

