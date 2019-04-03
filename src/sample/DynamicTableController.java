package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lexer.Token;

public class DynamicTableController {
    @FXML
    TableView tabla;

    ObservableList<TK> data = FXCollections.observableArrayList();

    @FXML void initialize() {

        TableColumn tipo = new TableColumn();
        tipo.setText("tipo");
        tipo.setCellValueFactory(new PropertyValueFactory("tipo"));

        TableColumn valor = new TableColumn();
        valor.setText("valor");
        valor.setCellValueFactory(new PropertyValueFactory("valor"));

        TableColumn grupo = new TableColumn();
        grupo.setText("grupo");
        grupo.setCellValueFactory(new PropertyValueFactory("grupo"));

        TableColumn linea = new TableColumn();
        linea.setText("linea");
        linea.setCellValueFactory(new PropertyValueFactory("linea"));


        tabla.getColumns().addAll(tipo, valor, grupo, linea);
    }

    public void setData(ObservableList<Token> data) {

        for(var tk : data) {
            this.data.add(new TK(tk.getValor(), tk.getTipo(), tk.getGrupo(), tk.getLinea()));
        }

        this.tabla.setItems(this.data);
    }
}
