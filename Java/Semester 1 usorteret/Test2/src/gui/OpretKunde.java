package gui;

import application.Kunde;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class OpretKunde extends GridPane {
	
    private VBox knapper;
    private RadioButton button1, button2, button3;
    private ToggleGroup group;
    private final String ALMINDELIG_ID = "almindelig";
    private final String STUDERENDE_ID = "studerende";
    private final String ERHVERV_ID = "erhverv";
    
    private TextField txfKundeNvn;
    private Button btnOpret;
    private Label lblInfo;
    private ListView<Kunde> lsvKunder;
	private Controller controller = Controller.getSingletonIntance();

	public OpretKunde() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		// -----------------------

        group = new ToggleGroup();
        button1 = new RadioButton("Almindelig Kunde");
        button1.setId(ALMINDELIG_ID); // fix button2 til fx. rbnAlmindelig
        button1.setToggleGroup(group);
        button1.setSelected(true);
        button2 = new RadioButton("Studerende");
        button3 = new RadioButton("Erhverv");
        
        button2.setId(STUDERENDE_ID);
        button2.setToggleGroup(group);
        
        
        button3.setToggleGroup(group);
        button3.setId(ERHVERV_ID);
        knapper = new VBox(7.5);

        knapper.getChildren().addAll(button1, button2, button3);
        
        txfKundeNvn = new TextField();
        btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> opretKunde());
        
        this.add(new Label("Kunde navn:"), 0, 0);
        this.add(txfKundeNvn, 0, 1);
        this.add(knapper, 0, 2);
        this.add(btnOpret, 0, 4);
        
        lblInfo = new Label("");
        this.add(lblInfo, 0, 5, 2,1);
        
        lsvKunder = new ListView<Kunde>();
        this.add(lsvKunder, 1, 0, 1, 4);
        
        lsvKunder.getItems().clear();
        lsvKunder.getItems().addAll(controller.getKunder());
        Button btnFjernKunde = new Button("Fjern kunde");
        btnFjernKunde.setOnAction(event -> fjernKunde());
        this.add(btnFjernKunde, 1, 4);
        
        
	}

	private void fjernKunde() {
		
		Kunde kunde = lsvKunder.getSelectionModel().getSelectedItem();
		
		if (kunde == null) {
			return;
		}
		controller.removeKunde(kunde);
		lsvKunder.getItems().clear();
		lsvKunder.getItems().addAll(controller.getKunder());
		
		lblInfo.setTextFill(Color.GREEN);
		lblInfo.setText("Kunde " + kunde + " fjernet");
	}

	private void opretKunde() {
	 	 RadioButton valgteRb = (RadioButton)group.getSelectedToggle(); 
    	 if (valgteRb == null) {
    		 return;
    	 }
    	 boolean isStudent;
    	 boolean isErhverv;
    	    
    	 if (valgteRb.getId().equals(ALMINDELIG_ID)) {
    		 isStudent = false;
    		 isErhverv = false;
         }
    	 else if (valgteRb.getId().equals(STUDERENDE_ID)) {
    		 isStudent = true;
    		 isErhverv = false;
         } 
    	 else if (valgteRb.getId().equals(ERHVERV_ID)) {
    		 isStudent = false;
    		 isErhverv = true;
         }
    	 else {
    		 return;
    	 }
    	 
    	try {
    		controller.createKunde(txfKundeNvn.getText(), isStudent, isErhverv);
    	}
    	catch (Exception e) {
    		lblInfo.setTextFill(Color.RED);
			lblInfo.setText(e.getMessage());
			return;
		}
        lsvKunder.getItems().clear();
        lsvKunder.getItems().addAll(controller.getKunder());
        
		lblInfo.setTextFill(Color.GREEN);
		lblInfo.setText("Kunde " + txfKundeNvn.getText() + " oprettet");
		txfKundeNvn.setText("");
    	 }

	public void updateControls() {
        lsvKunder.getItems().clear();
        lsvKunder.getItems().addAll(controller.getKunder());
	}
	
	}
