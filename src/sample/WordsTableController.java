package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WordsTableController {
    @FXML
    TableView tabla;

    @FXML void initialize() {
        final ObservableList<Operators> data = FXCollections.observableArrayList(
                new Operators("for",     "1",    "4" ),
                new Operators("while",  "2",  "4" ),
                new Operators("integer",  "3",  "4" ),
                new Operators("decimal",  "4",  "4" ),
                new Operators("string",  "5",  "4" ),
                new Operators("bool",  "6",  "4" ),
                new Operators("console",  "7",  "4" ),
                new Operators("in",  "8",  "4" ),
                new Operators("out",  "9",  "4" ),
                new Operators("if",  "10",  "4" ),
                new Operators("else",  "11",  "4" )

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
