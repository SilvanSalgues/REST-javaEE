package server.mobile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.mobile.metier.I_Metier;
import server.mobile.metier.TemperatureException;

import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping(value = "/temps/{capteur}", method = RequestMethod.GET)
    public TemperatureReponse getTemperature( @PathVariable("capteur") String[] nomCapteur) {


        // l'objet réponse qui sera encodé en Json
        TemperatureReponse reponse = new TemperatureReponse();

        // appel à la couche métier, susceptible de lever une exception si capteur inconnu

        try {
            Map<String , Double > mapCapteur = new HashMap<String, Double>();
            for (int i = 0; i < nomCapteur.length; i++){
                mapCapteur.put( nomCapteur[i], metier.getTemperature(nomCapteur[i]) );
                reponse.setMapCapteur(mapCapteur);

                //trace de l'appel dans le serveur
                System.out.println("getTemperature : capteur=" + nomCapteur[i] + " temp="+reponse.getTemp(nomCapteur[i]));
            }
            reponse.setErreur(0);
            System.out.println(mapCapteur.toString());
        } catch ( TemperatureException e){
            reponse.setErreur(1); // => Temp = 0
            reponse.setErrorMessage( e.getMessage() );
        }

        return reponse;
    }
}
