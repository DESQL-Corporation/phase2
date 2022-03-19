package dev.bong.view;

import dev.bong.entity.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ParamAdminController implements Initializable {
    Config config = Config.getInstance();

    @FXML
    private Label panneauAdminText;

    @FXML
    protected void onApplyParamAdmin() throws IOException {
        Parent param = FXMLLoader.load(ParamAdminController.class.getResource("/layout/parametre.fxml"));
        Scene scene = new Scene(param);
        Stage thisStage = (Stage) panneauAdminText.getScene().getWindow();
        thisStage.setTitle("Paramètres");
        thisStage.setScene(scene);
        thisStage.show();
        System.out.println("Boutton appliqué appuyé");
    }
    @FXML
    private Button btnAffiche;

    @FXML
    private Label lbTauxSimi;
    @FXML
    private Label lbIntervalle;
    @FXML
    private Label lbOccu;
    @FXML
    private Label lbNbMotTexte;
    @FXML
    private Label lbNbPointFen;
    @FXML
    private Label lbNbBitQuant;

    @FXML
    private Spinner<Integer> spTauxSimi;
    @FXML
    private Spinner<Integer> spIntervalle; //1,2,3 pour intervalle
    @FXML
    private Spinner<Integer> spOccu;
    @FXML
    private Spinner<Integer> spNbMotTexte;
    @FXML
    private Spinner<Integer> spNbPointFen;
    @FXML
    private Spinner<Integer> spNbBitQuant;

    //Spinner Value Factory
    final int initialValue = 1; //permet d'initialisé la valeur dans la case par ex: ancienne valeur
    SpinnerValueFactory<Integer> svf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,config.getTauxSim());
    SpinnerValueFactory<Integer> svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,200,config.getNbrIntervalleAudio());
    SpinnerValueFactory<Integer> svf3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,200,config.getSeuilOccMot());
    SpinnerValueFactory<Integer> svf4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,200,config.getNbMaxMotParTexte());
    SpinnerValueFactory<Integer> svf5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,2048,config.getNbrPointsAudio());
    SpinnerValueFactory<Integer> bite = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,8,config.getBitQuantification());
    @FXML
    private TextArea taSummary;



    @FXML
    public void HandleBtnAfficheAction(ActionEvent actionEvent) {
        taSummary.clear();
        taSummary.appendText(String.valueOf("Taux de similarité : " + spTauxSimi.getValue()) + "\n");
        taSummary.appendText(String.valueOf("Nombre d'Intervalle : " + spIntervalle.getValue()) + "\n");
        taSummary.appendText(String.valueOf("Seuil Occurence : " + spOccu.getValue()) + "\n");
        taSummary.appendText(String.valueOf("Nombre de mot par texte : " + spNbMotTexte.getValue()) + "\n");
        taSummary.appendText(String.valueOf("Nombre de Point par fenêtre : " + spNbPointFen.getValue()) + "\n");
        taSummary.appendText(String.valueOf("Nombre bit Quantification : " + spNbBitQuant.getValue()) + "\n");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spTauxSimi.setEditable(true);
        spTauxSimi.setValueFactory(svf1);
        spIntervalle.setEditable(true);
        spIntervalle.setValueFactory(svf2);
        spOccu.setEditable(true);
        spOccu.setValueFactory(svf3);
        spNbMotTexte.setEditable(true);
        spNbMotTexte.setValueFactory(svf4);
        spNbPointFen.setEditable(true);
        spNbPointFen.setValueFactory(svf5);
        spNbBitQuant.setEditable(true);
        spNbBitQuant.setValueFactory(bite);

    }
}
