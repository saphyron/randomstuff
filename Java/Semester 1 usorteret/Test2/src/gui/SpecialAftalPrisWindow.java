package gui;

import application.KvitteringsLinje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SpecialAftalPrisWindow extends Stage {

    public SpecialAftalPrisWindow(KvitteringsLinje kvitteringsLinje) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        
        this.kvitteringsLinje = kvitteringsLinje;
        setTitle("Aftal pris eller rabat");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private KvitteringsLinje kvitteringsLinje;
    private VBox knapper;
    private RadioButton button1, button2, button3;
    private ToggleGroup group;
    private final String prisId = "pris";
    private final String rabatId = "rabat";
    private final String nulstilId = "nulstil";
    private TextField txfVærdiIndsætter;
    private Label lblÆndre, lblInfo;
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        pane.add(new Label("Produkt:"), 0, 0);
        
        TextField TxfProduktNvn = new TextField(kvitteringsLinje.getPris().getProdukt().toString());
        TextField TxfProduktPris = new TextField(""+kvitteringsLinje.getPris().getStandardPris());
        
        TxfProduktNvn.setDisable(true);
        TxfProduktPris.setDisable(true);
        
        pane.add(TxfProduktNvn, 1, 0);
        pane.add(new Label("Normal pris:"), 0, 1);
        pane.add(TxfProduktPris, 1, 1);
        
        group = new ToggleGroup();
        button1 = new RadioButton("Specialpris");
        button1.setId(prisId);
        button1.setToggleGroup(group);
        button1.setSelected(true);
        button2 = new RadioButton("Special Rabat");
        button3 = new RadioButton("Nulstil pris");
        
        button2.setId(rabatId);
        button2.setToggleGroup(group);
        
        
        button3.setToggleGroup(group);
        button3.setId(nulstilId);
        knapper = new VBox(7.5);
        //knapper.setOnMouseClicked(event -> skiftSpeicalType());
        
        button1.setOnMouseClicked(event -> skiftSpeicalType());
        button2.setOnMouseClicked(event -> skiftSpeicalType());
        button3.setOnMouseClicked(event -> skiftSpeicalType());
        
        knapper.getChildren().addAll(button1, button2, button3);
        
        pane.add(knapper, 0, 2, 2, 1);
        
        lblÆndre = new Label("Indsæt pris:");
        lblÆndre.setMinWidth(90.0);
        pane.add(lblÆndre, 0, 4);
        txfVærdiIndsætter = new TextField("");
        pane.add(txfVærdiIndsætter, 1, 4);
       
        Button btnAnnuller = new Button("Annuller");
        Button btnBekræft = new Button("Bekræft");
        
        btnBekræft.setOnAction(event -> bekræft());
        btnBekræft.setAlignment(Pos.BASELINE_RIGHT);
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        btnAnnuller.setOnAction(event -> hide());
        HBox hBox = new HBox(btnAnnuller, region, btnBekræft);
        hBox.setStyle("-fx-padding: 5;");
        pane.add(hBox, 0, 5,2,1);
        
        lblInfo = new Label();
        lblInfo.setWrapText(true);
        pane.add(lblInfo, 0, 6, 2, 1);
    }
    
    private void skiftSpeicalType() {
    	
    	 RadioButton valgteRb = (RadioButton)group.getSelectedToggle(); 
    	 if (valgteRb == null) {
    		 return;
    	 }
    	 if (valgteRb.getId().equals(prisId)) {
    		 lblÆndre.setText("Indsæt pris:");
    		 txfVærdiIndsætter.setDisable(false);
    		 prisEllerRabatÆndre = new SætPris();
    		 txfVærdiIndsætter.setText("");
         }
    	 else if (valgteRb.getId().equals(rabatId)) {
    		 lblÆndre.setText("Indsæt rabat:");
    		 txfVærdiIndsætter.setDisable(false);
    		 prisEllerRabatÆndre = new SætRabat();
    		 txfVærdiIndsætter.setText("");
    		
         } 
    	 else if (valgteRb.getId().equals(nulstilId)) {
    		 lblÆndre.setText("Indsæt pris:");
    		 txfVærdiIndsætter.setText(""+kvitteringsLinje.getPris().getStandardPris());
    		 txfVærdiIndsætter.setDisable(true);
    		 prisEllerRabatÆndre = new Nulstil();
         } 
    	 
    }
    
    private void bekræft() {
    	
    	double værdi;
    	try {
    		værdi = Double.parseDouble(txfVærdiIndsætter.getText());
    	}
    	catch (NumberFormatException e) {
    		lblInfo.setTextFill(Color.RED);
			lblInfo.setText("Ugyldig double");
			return;
		}
    	try {
    		prisEllerRabatÆndre.ændrePris(værdi);
    	}
    	catch (IllegalArgumentException e) {
    		lblInfo.setTextFill(Color.RED);
			lblInfo.setText(e.getMessage());
			return;
		}
    	hide();
    }
    
    PrisEllerRabatÆndre prisEllerRabatÆndre = new SætPris();

    interface PrisEllerRabatÆndre {
    	void ændrePris(double værdi);
    }
    
    class SætPris implements PrisEllerRabatÆndre {

		@Override
		public void ændrePris(double værdi) {
			kvitteringsLinje.setSpeialtAftaltPris(værdi);
		}
    	
    }
    
    class SætRabat implements PrisEllerRabatÆndre {

		@Override
		public void ændrePris(double værdi) {
			kvitteringsLinje.setSpecialAftaltRabat(værdi);
		}
    	
    }
    class Nulstil implements PrisEllerRabatÆndre {

		@Override
		public void ændrePris(double værdi) {
			kvitteringsLinje.nulstillPrisOgRabat();
		}
    	
    }
}

