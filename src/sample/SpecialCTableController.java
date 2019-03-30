package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SpecialCTableController {
    @FXML
    TableView tabla;

    @FXML void initialize() {
        final ObservableList<Operators> data = FXCollections.observableArrayList(
                new Operators("{",     "1",    "5" ),
                new Operators("}",  "2",  "5" ),
                new Operators("(",  "3",  "5" ),
                new Operators(")",  "4",  "5" ),
                new Operators("[",  "5",  "5" ),
                new Operators("]",  "6",  "5" ),
                new Operators("",  "7",  "5" ),
                new Operators("&&",  "8",  "5" ),
                new Operators("'",  "9",  "5" ),
                new Operators("|",  "10",  "5" ),
                new Operators("/",  "11",  "5" ),
                new Operators("`",  "12",  "5" ),
                new Operators("~",  "13",  "5" ),
                new Operators("_",  "14",  "5" ),
                new Operators("?",  "15",  "5" ),
                new Operators(":",  "16",  "5" ),
                new Operators(";",  "17",  "5" ),
                new Operators(".",  "18",  "5" ),
                new Operators("@",  "19",  "5" ),
                new Operators("ñ",  "20",  "5" )
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
