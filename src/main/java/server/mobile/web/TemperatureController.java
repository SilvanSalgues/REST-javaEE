package server.mobile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.mobile.metier.I_Metier;
import server.mobile.metier.TemperatureException;

/**
 * Created by Psycus34 on 06/10/2016.
 */

@RestController
public class TemperatureController {
    /**
     * L'annotation @RestController de la classe indique :
     * - que la classe contient des méthodes qui vont traiter des requêtes REST pour
     *      certaines URL de la webApp
     * - que ces méthodes génèrent elles-mêmes la réponse envoyée au client
     * - que la réponse envoyée est une chaîne de caractères au format JSON
     */

    // couche métier
    @Autowired
    private I_Metier metier;
    /**
     * L'annotation @Autowired demande à Spring d'injecter dans l'attribut metier de
     * la classe, un composant de type IMetier.
     * La classe Metier du package serveur.mobile.metier implémente cette interface
     * IMetier
     * Elle est donc capable de fournir une méthode pour traiter un service REST
     * Ceci est indiqué par l'annotation @Service de la classe Metier qui fait de cette
     * instance, un composant Spring injectable
     */

    // Action Get Temperature, en paramètre : le nom du capteur
    @RequestMapping(value = "/{capteur}", method = RequestMethod.GET)
    public TemperatureReponse getTemperature( @PathVariable("capteur") String nomCapteur) {
        /**
         * L'annotation @RequestMapping fait de cette méthode une méthode de traitement du
         * service REST
         *
         * Elle traite une requête de type GET /capteur
         *      "capteur" est un paramètre dont la valeur est transmise dans la requête
         *      l'annotation @PathVariable("capteur") associe cette variable au
         *      paramètre formel de la méthode 'nomCapteur'
         * Ex: la requête GET /Salon : http://192.168.1.34:8080/Salon
         *      est mappée avec l'appel de la méthode getTemperature("Salon")
         *      avec en paramètre : nomCapeur = "Salon"
         * RQ : les valeurs des variables du service sont transportées par HTTP,
         *      c'est donc une valeur de type String
         * Les paramètres de la méthode pourraient être d'un type primitif Java : int,
         * double... ; cette valeur serait alors convertie par Spring, avec
         * éventuellement levée d'une exception de décodage
         *
         * La réponse envoyée au client du service est un objet TemperatureReponse
         * qui a 3 attributs :
         *      - erreur, de type int, 0 si pas d'erreur
         *      - errorMessage, de type String, si erreur != 0
         *      - temp, de type double, stocke la température du capteur
         * C'est le fait d'annoter la classe avec @RequestMapping qui fait que cet objet
         * sera sérialisé au format JSON, transporté en HTTP, récupéré dans le client,
         * puis désérialisé, ce qui rend les attributs de l'objet TemperatureReponse
         * disponibles.
         */

        // l'objet réponse qui sera encodé en Json
        TemperatureReponse reponse = new TemperatureReponse();

        // appel à la couche métier, susceptible de lever une exception si capteur inconnu
        reponse.setNomCapteur(nomCapteur);
        try {
            reponse.setTemp( metier.getTemperature( nomCapteur) );
            reponse.setErreur(0);
        } catch ( TemperatureException e){
            reponse.setErreur(1); // => Temp = 0
            reponse.setErrorMessage( e.getMessage() );
        }

        //trace de l'appel dans le serveur
        System.out.println("getTemperature : capteur="+nomCapteur +" temp="+reponse.getTemp());

        return reponse;
    }
}
