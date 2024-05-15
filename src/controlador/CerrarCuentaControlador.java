/**
 * Sample Skeleton for 'CerrarVista.fxml' Controller Class
 */

package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CerrarCuentaControlador {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtnumeroCerrarCuenta"
    private TextField txtnumeroCerrarCuenta; // Value injected by FXMLLoader

    @FXML
    void atras(ActionEvent event) {

    }

    @FXML
    void cerrarCuenta(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtnumeroCerrarCuenta != null : "fx:id=\"txtnumeroCerrarCuenta\" was not injected: check your FXML file 'CerrarVista.fxml'.";

    }

}
