/**
 * Sample Skeleton for 'InicioVista.fxml' Controller Class
 */

package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Bank;
import util.Utilidades;

public class InicioControlador implements Initializable{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    
    private Bank bank;
    
    public InicioControlador() {
    	bank = Bank.getInstance();
    }

    @FXML
    void abrirCuenta(ActionEvent e) {
    	
    	Stage stage = Utilidades.obtenerStage(e);
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("AbrirVista.fxml"));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();	    		    

		} catch (IOException eio) {
			eio.printStackTrace();
		}

    }

    @FXML
    void cerrarCuenta(ActionEvent event) {
    	Stage stage = Utilidades.obtenerStage(event);
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("CerrarVista.fxml"));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();		    		    

		} catch (IOException eio) {
			eio.printStackTrace();
		}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
