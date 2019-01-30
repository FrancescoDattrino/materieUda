/*package applicationUda;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import applicationUdaModel.Allegato;
import applicationUdaModel.Classe;
import applicationUdaModel.Competenze;
import applicationUdaModel.CompetenzeSecondarie;
import applicationUdaModel.DisciplineCoinvolte;
import applicationUdaModel.Materia;
import applicationUdaModel.Model;
import applicationUdaModel.Sezione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleControllerUda {
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    

    @FXML // fx:id="comboMateria"
    private ComboBox<Materia> comboMateria; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
  
    	
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    
    
        assert comboMateria != null : "fx:id=\"comboMateria\" was not injected: check your FXML file 'SampleUda.fxml'.";
       
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SampleUda.fxml'.";
       
        //comboMateria.setDisable(true);
        
        

    }
   
    
}*/
package applicationUda;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import applicationUdaModel.CompetenzeSecondarie;
import applicationUdaModel.DisciplineCoinvolte;
import applicationUdaModel.Materia;
import applicationUdaModel.Model;
import applicationUdaModel.UdaFromMateria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SampleControllerUda {
	private Model model;
	
	@FXML // fx:id="comboUda"
    private ComboBox<DisciplineCoinvolte> comboUda; // Value injected by FXMLLoader

    @FXML // fx:id="btnUda"
    private Button btnUda; // Value injected by FXMLLoader
    
    @FXML // fx:id="comboCompetenze"
    private ComboBox<CompetenzeSecondarie> comboCompetenze; // Value injected by FXMLLoader


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="comboMateria"
    private ComboBox<Materia> comboMateria; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnUdaFromMateria"
    private Button btnUdaFromMateria; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnompetenze"
    private Button btnompetenze; // Value injected by FXMLLoader

    @FXML
    void onUdaFromMateria(ActionEvent event) {
    	txtResult.clear();
    	
    	try {
    		Materia m=comboMateria.getValue();
        	if(m==null ) {
        		txtResult.appendText("Errore: selezionare una materia.\n");
        		return ;
        	}

			
			List<UdaFromMateria> udaMateria = new ArrayList<UdaFromMateria>();
				udaMateria=	model.cercaUdaFromMateria(m);

			StringBuilder sb = new StringBuilder();

			for (UdaFromMateria l : udaMateria) {
	
				sb.append(String.format("%s ",l.toString() ));
				
				
				sb.append("\n");
			}
			txtResult.appendText(sb.toString());

	
		} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}

    }
    @FXML
    void onUdaContenuti(ActionEvent event) {
txtResult.clear();
    	
    	try {
    		DisciplineCoinvolte dc=comboUda.getValue();
        	if(dc==null ) {
        		txtResult.appendText("Errore: selezionare un Uda da visualizzare.\n");
        		return ;
        	}
//voglio visualizzare i contenuti dell'uda prescelto
			
			List<UdaFromMateria> udaContenuti = new ArrayList<UdaFromMateria>();
				udaContenuti=	model.cercaUda(dc);

			StringBuilder sb = new StringBuilder();

			for (UdaFromMateria l : udaContenuti) {
	
				sb.append(String.format("%s ",l.toString() ));
				
				
				sb.append("\n");
			}
			txtResult.appendText(sb.toString());

	
		} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}

    

    }
    @FXML
    void onCompetenzeContenuti(ActionEvent event) {

txtResult.clear();
    	
    	try {
    		CompetenzeSecondarie cs=comboCompetenze.getValue();
        	if(cs==null ) {
        		txtResult.appendText("Errore: selezionare una competenza da visualizzare.\n");
        		return ;
        	}
//voglio visualizzare i contenuti dell'uda prescelto
			
			List<UdaFromMateria> competenzaContenuti = new ArrayList<UdaFromMateria>();
				competenzaContenuti=	model.cercaCompetenza(cs);

			StringBuilder sb = new StringBuilder();

			for (UdaFromMateria l : competenzaContenuti) {
	
				sb.append(String.format("%s ",l.toString() ));
				
				
				sb.append("\n");
			}
			txtResult.appendText(sb.toString());

	
		} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}

    

    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert comboCompetenze != null : "fx:id=\"comboCompetenze\" was not injected: check your FXML file 'SampleUda.fxml'.";
    	 assert comboUda != null : "fx:id=\"comboUda\" was not injected: check your FXML file 'SampleUda.fxml'.";
         assert btnUda != null : "fx:id=\"btnUda\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboMateria != null : "fx:id=\"comboMateria\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnompetenze != null : "fx:id=\"btnompetenze\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnUdaFromMateria != null : "fx:id=\"btnUdaFromMateria\" was not injected: check your FXML file 'SampleUda.fxml'.";

    }
    public void setModel(Model model) {

  		this.model = model;
  		comboMateria.getItems().addAll(this.model.getMaterie());
  		comboUda.getItems().addAll(this.model.getDisciplinecoinvolte());
  		comboCompetenze.getItems().addAll(this.model.getCompetenzesecondarie());
  	
  	}
}

