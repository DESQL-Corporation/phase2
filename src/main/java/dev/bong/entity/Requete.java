package dev.bong.entity;

import fr.dgac.ivy.IvyException;


public class Requete{
    private CommunicationIvy communicationIvy= CommunicationIvy.getInstance();
    private String mot;
    private EtatRequete etatRequete;
    private String destinataire;


    public Requete(String mot,String destinataire){
        this.mot = mot;
        this.destinataire = destinataire;
        this.etatRequete = EtatRequete.WAITING_FOR_INIT;
    }

    public void initRecherche(){
        try {

            communicationIvy.definirBind(mot,destinataire);

            etatRequete = EtatRequete.READY_FOR_START;

        } catch (IvyException e) {
            e.printStackTrace();
            setEtatRequete(EtatRequete.ERROR);
        }
    }

    public void initIndexation(){
        try {

            communicationIvy.definirBind(ListenerPropriete.RESULTAT,"BONGALA");

            etatRequete = EtatRequete.READY_FOR_START;

        } catch (IvyException e) {
            e.printStackTrace();
            setEtatRequete(EtatRequete.ERROR);
        }
    }

    public void start(TypeRequete requete) {
        int nbAgentReceveur;
        try {
            nbAgentReceveur = communicationIvy.envoieMessage("Interface destinataire=" + destinataire + " message=" + requete.toString() + " source=" + mot);
            if (nbAgentReceveur > 0){
                System.out.println("Protocole d'envoie de : " + mot + " --> envoyé à " + nbAgentReceveur + " agents");
                setEtatRequete(EtatRequete.RUNNABLE);
            }
            else {
                System.out.println("Protocole d'envoie de : " + mot + " --> Erreur d'envoie");
                setEtatRequete(EtatRequete.ERROR);
            }
        } catch (IvyException e) {
            e.printStackTrace();
            setEtatRequete(EtatRequete.ERROR);
       }
    }

    public void setEtatRequete(EtatRequete etatRequete) {
        this.etatRequete = etatRequete;
    }

    public EtatRequete getEtatRequete() {
        return etatRequete;
    }

    public String getMot(){
        return  mot;
    }

    public String getDestinataire() {
        return destinataire;
    }
}
