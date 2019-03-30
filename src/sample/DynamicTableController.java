package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DynamicTableController {
    @FXML
    TableView tabla;

    @FXML void initialize() {

        TableColumn idem = new TableColumn();
        idem.setText("idem");
        idem.setCellValueFactory(new PropertyValueFactory("idem"));

        TableColumn desc = new TableColumn();
        desc.setText("descripcion");
        desc.setCellValueFactory(new PropertyValueFactory("desc"));

        TableColumn grupo = new TableColumn();
        grupo.setText("grupo");
        grupo.setCellValueFactory(new PropertyValueFactory("grupo"));

        TableColumn linea = new TableColumn();
        linea.setText("linea");
        linea.setCellValueFactory(new PropertyValueFactory("linea"));

        tabla.getColumns().addAll(idem, desc , grupo, linea);
    }
}
