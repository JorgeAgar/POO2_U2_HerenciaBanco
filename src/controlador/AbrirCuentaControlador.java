/**
 * Sample Skeleton for 'AbrirVista.fxml' Controller Class
 */

package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Bank;
import util.Utilidades;

public class AbrirCuentaControlador {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buttonAhorro"
    private CheckBox buttonAhorro; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCorriente"
    private CheckBox buttonCorriente; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumeroDeCuenta"
    private TextField txtNumeroDeCuenta; // Value injected by FXMLLoader
    
    private Bank bank;
    
    public AbrirCuentaControlador () {
    	bank = bank.getInstance();
    }

    @FXML
    void atras(ActionEvent event) {
    	Stage stage = Utilidades.obtenerStage(event);
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/poo1/mascotas/vista/InicioVista.fxml"));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();		    		    

		} catch (IOException eio) {
			eio.printStackTrace();
		}
    }

    @FXML
    void guardar(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buttonAhorro != null : "fx:id=\"buttonAhorro\" was not injected: check your FXML file 'AbrirVista.fxml'.";
        assert buttonCorriente != null : "fx:id=\"buttonCorriente\" was not injected: check your FXML file 'AbrirVista.fxml'.";
        assert txtNumeroDeCuenta != null : "fx:id=\"txtNumeroDeCuenta\" was not injected: check your FXML file 'AbrirVista.fxml'.";

    }

}
