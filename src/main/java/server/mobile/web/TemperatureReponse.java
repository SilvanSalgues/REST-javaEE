package server.mobile.web;

import java.util.Map;

/**
 * Created by Psycus34 on 06/10/2016.
 *
 * Classe identique dans le serveur et dans le client
 * hormis le package conteneur

 */

public class TemperatureReponse {

    // data
    private Map<String , Double > mapCapteur;
    //private MAP<String nomCapteur, double temp> mMAP  ; // identifie la réponse
    private int erreur; // 0 si pas d'erreur
    private String errorMessage; // si erreur != 0

    // getters et setters


    public Map<String, Double> getMapCapteur() {
        return mapCapteur;
    }

    public void setMapCapteur(Map<String, Double> mapCapteur) {
        this.mapCapteur = mapCapteur;
    }

    public Double getTemp (String nomCapteur) {
        return mapCapteur.get(nomCapteur);
    }

    public int getErreur() {
        return erreur;
    }

    public void setErreur(int erreur) {
        this.erreur = erreur;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
