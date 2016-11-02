package server.mobile.web;

/**
 * Created by Psycus34 on 06/10/2016.
 *
 * Classe identique dans le serveur et dans le client
 * hormis le package conteneur

 */

public class TemperatureReponse {

    // data
    private String nomCapteur; // identifie la réponse
    private int erreur; // 0 si pas d'erreur
    private String errorMessage; // si erreur != 0
    private double temp; // stocke la température du capteur

    // getters et setters

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


    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getNomCapteur() {
        return nomCapteur;
    }
    public void setNomCapteur(String nomCapteur) {
        this.nomCapteur = nomCapteur;
    }

}
