package controleur;

import modele.Config;

import java.io.IOException;
import java.util.List;

public class ControlModifierConfig {


    public static void modifConfig(List<Integer>listeValeur) throws IOException {
        Config config = Config.getInstance();
        int i=0;
        while(i!=6){
            switch (i){
                case 0:
                    config.setTauxSim(listeValeur.get(i));
                    break;
                case 1 :
                    config.setNbMaxMotParTexte(listeValeur.get(i));
                    break;
                case 2 :
                    config.setSeuilOccMot(listeValeur.get(i));
                    break;
                case 3 :
                    config.setNbrIntervalleAudio(listeValeur.get(i));
                    break;
                case 4 :
                    config.setNbrPointsAudio(listeValeur.get(i));
                    break;
                case 5 :
                    config.setBitQuantification(listeValeur.get(i));
                    break;
                default:
                    break;
            }
            i++;
        }
        config.majConfig();

    }
}
