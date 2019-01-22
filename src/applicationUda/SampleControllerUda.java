package applicationUda;

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
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="txtUda"
    private TextField txtUda; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnAttivaCompSec"
    private Button btnAttivaCompSec; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnInsrisciCompSec"
    private Button btnInserisciCompSec; // Value injected by FXMLLoader
    

    @FXML // fx:id="txtPeso"
    private TextField txtPeso; // Value injected by FXMLLoader
    
   // @FXML // fx:id="sliaderPeso"
   // private Slider sliderPeso; // Value injected by FXMLLoader

    @FXML // fx:id="comboComSec"
    private ComboBox<CompetenzeSecondarie> comboComSec; // Value injected by FXMLLoader

    @FXML // fx:id="comboSezione"
    private ComboBox<Sezione> comboSezione; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnAttivaBoxComPrim"
    private Button btnAttivaBoxComPrim; // Value injected by FXMLLoader

    @FXML // fx:id="comboInizio"
    private DatePicker comboInizio; // Value injected by FXMLLoader

    @FXML // fx:id="txtCompetenzaSecondaria"
    private TextArea txtCompetenzaSecondaria; // Value injected by FXMLLoader

    @FXML // fx:id="comboComPrim"
    private ComboBox<Competenze> comboComPrim; // Value injected by FXMLLoader

    @FXML // fx:id="comboFine"
    private DatePicker comboFine; // Value injected by FXMLLoader DatePicker comboFine; /

    @FXML // fx:id="comboAllegato"
    private ComboBox<Allegato> comboAllegato; // Value injected by FXMLLoader

    @FXML // fx:id="txtArgomento"
    private TextArea txtArgomento; // Value injected by FXMLLoader

    @FXML // fx:id="txtOreDedicate"
    private TextField txtOreDedicate; // Value injected by FXMLLoader

    @FXML // fx:id="btnSalvaDati"
    private Button btnSalvaDati; // Value injected by FXMLLoader

    @FXML // fx:id="comboMateria"
    private ComboBox<Materia> comboMateria; // Value injected by FXMLLoader

    @FXML // fx:id="comboClasse"
    private ComboBox<Classe> comboClasse; // Value injected by FXMLLoader

    @FXML // fx:id="btnNuovaComp"
    private Button btnNuovaComp; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    void onAttivaBoxComPrim(ActionEvent event) {
    	txtResult.clear();
    	Allegato a = comboAllegato.getValue() ;
    	Classe c= comboClasse.getValue();
    	Sezione s= comboSezione.getValue();
    	
    	if(a==null || c==null || s==null) {
    		txtResult.appendText("Errore: selezionare allegato , classe e sezione\n");
    		return ;
    	}
    	//List<Competenze> competenze=model.getCompetenzePrimarieFromAllegato(a.getCodAllegato()) ;                                //new ArrayList<Competenze>(model.getCompetenzePrimarieFromAllegato(a.getCodAllegato()));
    	/*for(Competenze c: competenze) {
    		txtResult.appendText(c.toString()+"\n");
    	}*/
    	
    	// riempi ed abilita la seconda tendina
    	comboComPrim.getItems().clear();
    	comboComPrim.getItems().addAll(model.getCompetenzePrimarieFromAllegato(a.getCodAllegato())) ;
    	comboComPrim.setDisable(false);
    	
    	comboMateria.getItems().clear();
    	comboMateria.getItems().addAll(model.getMaterieFromClasseSezione(c.getCodClasse(), s.getCodSezione())) ;
    	comboMateria.setDisable(false);
    }
    @FXML
    void onAttivaCompSec(ActionEvent event) {
    	txtResult.clear();
    	Competenze c=comboComPrim.getValue();
    	if(c==null ) {
    		txtResult.appendText("Errore: selezionare competenza primaria.\n");
    		return ;
    	}
    	comboComSec.getItems().clear();
    	comboComSec.getItems().addAll(model.getCompetenzeSecodarieFromCompetenzaPrimaria(c.getCodCompetenze())) ;
    	comboComSec.setDisable(false);
    	
    }

    @FXML
    void onNuovaComp(ActionEvent event) {
    	txtResult.clear();
    	comboComSec.getItems().clear();
    	Competenze c=comboComPrim.getValue();
    	if(c==null ) {
    		txtResult.appendText("Errore: selezionare competenza primaria.\n");
    		return ;
    	}
    	txtResult.appendText("L'area di testo a fianco è ora editabile, digitare la nuova competenza e inserirla nella tendina per essere selezionata. \n");
    	txtCompetenzaSecondaria.setDisable(false);
    	txtCompetenzaSecondaria.setEditable(true);
    	
    }
    
    @FXML
    void onInserisciCompSec(ActionEvent event) {
    	txtResult.clear();
    	String competenzasecondarianuova  =txtCompetenzaSecondaria.getText();
    	txtCompetenzaSecondaria.clear();
    	txtCompetenzaSecondaria.setDisable(true);
    	txtCompetenzaSecondaria.setEditable(false);
    	if( competenzasecondarianuova.length()==0 ) {
    		txtResult.appendText("Occorre completare l'area di testo con la nuova competenza.");
    		return ;
    	}
    	//chiedo al model di effettuare l'inserimento
    	Competenze c=comboComPrim.getValue();//recupero la competenza primaria
    	CompetenzeSecondarie newcompsec = new CompetenzeSecondarie(c.getCodCompetenze(), competenzasecondarianuova) ;
    	boolean result = model.addCompetenzaSecondaria(newcompsec) ;
    	// aggiorna la vista con il risultato dell'operazione
    	if(result) {
    		txtResult.appendText("Competenza secondaria aggiunta correttamente. Occorre ricompilare il form dall'inizio per scegliere la nuova competenza.\n");
    	} else {
    		txtResult.appendText("Competenza secondaria NON AGGIUNTA \n");
    	}
    	
    	
    }
    
    @FXML
    void onSalvaDati(ActionEvent event) {
    	txtResult.clear();

    	try {
    		CompetenzeSecondarie cs=comboComSec.getValue();
        	if(cs==null) {
        		txtResult.appendText("Devi inserire una competenza secondaria .\n");
        		return;
        	}
        	String uda = txtUda.getText();
        	if(uda.length()==0) {
        		txtResult.appendText("Devi inserire una unità di apprendimento .\n");
        		return;
        	}
        	
        	String oreS = txtOreDedicate.getText();
        	if(oreS.length()==0) {
        		txtResult.appendText("Devi inserire un numero di ore dedicate .\n");
        		return;
        	}
        	//Integer ore= Integer.parseInt(oreS);
        	Integer ore = Integer.valueOf(oreS);
        	txtResult.appendText("Intero inserito.\n");
        	
        	String pesoS = txtPeso.getText();
        	if(pesoS.length()==0) {
        		txtResult.appendText("Devi inserire la percentuale dedicata .\n");
        		return;
        	}
        	//Integer ore= Integer.parseInt(oreS);
        	Integer peso = Integer.parseInt(pesoS);
        	txtResult.appendText("Intero peso inserito.\n");
        	//Double peso = sliderPeso.getValue();
        	//if(peso==0.0) {
        	//	txtResult.appendText("Devi inserire una percentuale .\n");
        	//	return;
        	//}
        	String argomento = txtArgomento.getText();
        	if(argomento.length()==0) {
        		txtResult.appendText("Devi inserire un argomento .\n");
        		return;
        	}
           	//Date inizio = static Date valueOf(LocalDate comboInizio);
        	LocalDate datainizio=comboInizio.getValue();
        	if(datainizio==null) {
        		txtResult.appendText("Devi inserire una data di inizio .\n");
        		return;
        	}
        	
        	LocalDate datafine =comboFine.getValue();
        	if(datafine==null) {
        		txtResult.appendText("Devi inserire una data di terminazione .\n");
        		return;
        	}
        	Classe c= comboClasse.getValue();
        	Sezione s= comboSezione.getValue();
        	Materia m= comboMateria.getValue();
        	Integer classe = c.getCodClasse();
        	Integer sezione = s.getCodSezione();
        	Integer materia = m.getIdMateria();
        	txtResult.appendText("codici classe"+classe+" sezione "+sezione+" materia"+materia+" \n");
        	if(c==null || s==null) {
        		txtResult.appendText("Errore: selezionare  classe e sezione\n");
        		return ;
        	}
        	//creo il nuovo oggetto discipline coinvolte
       	DisciplineCoinvolte newdisciplinacoinvolta = new DisciplineCoinvolte(ore, peso, argomento, datainizio, datafine,
        			c.getCodClasse(), s.getCodSezione() , m.getIdMateria() , cs.getCodCompetenzaSecondaria(),uda ) ;
       	
//       	txtResult.appendText(newdisciplinacoinvolta.getArgomento());
       	boolean result = model.addDisciplineCoinvolte(newdisciplinacoinvolta) ;
        	// aggiorna la vista con il risultato dell'operazione
        	if(result) {
        		txtResult.appendText("Dati memorizzati correttamente. \n");
        	} else {
        		txtResult.appendText("Dati non memorizzati. Errore \n");
        	}
        	

			
			
		} catch (RuntimeException e) {
			txtResult.setText("Errore di connession al DB");
		}
	}

    	
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtPeso != null : "fx:id=\"txtPeso\" was not injected: check your FXML file 'SampleUda.fxml'.";
    	assert txtUda != null : "fx:id=\"txtUda\" was not injected: check your FXML file 'SampleUda.fxml'.";
        //assert sliderPeso != null : "fx:id=\"sliaderPeso\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnInserisciCompSec != null : "fx:id=\"btnInsrisciCompSec\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnAttivaCompSec != null : "fx:id=\"btnAttivaCompSec\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboComSec != null : "fx:id=\"comboComSec\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboSezione != null : "fx:id=\"comboSezione\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnAttivaBoxComPrim != null : "fx:id=\"btnAttivaBoxComPrim\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboInizio != null : "fx:id=\"comboInizio\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert txtCompetenzaSecondaria != null : "fx:id=\"txtCompetenzaSecondaria\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboComPrim != null : "fx:id=\"comboComPrim\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboFine != null : "fx:id=\"comboFine\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboAllegato != null : "fx:id=\"comboAllegato\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert txtArgomento != null : "fx:id=\"txtArgomento\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert txtOreDedicate != null : "fx:id=\"txtOreDedicate\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnSalvaDati != null : "fx:id=\"btnSalvaDati\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboMateria != null : "fx:id=\"comboMateria\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert comboClasse != null : "fx:id=\"comboClasse\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert btnNuovaComp != null : "fx:id=\"btnNuovaComp\" was not injected: check your FXML file 'SampleUda.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SampleUda.fxml'.";
        comboComPrim.setDisable(true);
        comboComSec.setDisable(true);
        comboMateria.setDisable(true);
        
        

    }
    public void setModel(Model model) {

  		this.model = model;
  		 comboClasse.getItems().addAll(this.model.getClassi()) ;
  		comboSezione.getItems().addAll(this.model.getSezioni()) ;
  		comboAllegato.getItems().addAll(this.model.getAllegati()) ;
  		comboComPrim.getItems().clear();
  		comboComSec.getItems().clear();
  		comboMateria.getItems().clear();
  	
  	}
    
}
