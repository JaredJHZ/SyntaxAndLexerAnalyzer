package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lexer.Token;

public class LogicalOperatorsDynamicTableController {
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

        TableColumn idem = new TableColumn();
        idem.setText("idem");
        idem.setCellValueFactory(new PropertyValueFactory("idem"));


        tabla.getColumns().addAll(tipo, valor, grupo, linea, idem);
    }

    public void setData(ObservableList<Token> data) {
        System.out.println(data.get(0).getGrupo());

        for(var tk : data) {
            if (tk.getGrupo().equals("2")) {
                System.out.println(tk.getIdem());
                this.data.add(new TK(tk.getValor(), tk.getTipo(), tk.getGrupo(), tk.getLinea(), tk.getIdem()));
            }
        }

        this.tabla.setItems(this.data);
    }
}
