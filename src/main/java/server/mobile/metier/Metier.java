package server.mobile.metier;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Psycus34 on 06/10/2016.
 */

@Service
public class Metier implements I_Metier{

    @Override
    public double getTemperature(String nomCapteur) throws TemperatureException {

        // contrôle : le nom fourni est bien le nom d'un capteur connu
        if ( ! nomCapteur.equals("Salon") && ! nomCapteur.equals("Chambre-1") ) {
            throw new TemperatureException("Le nom du capteur est inconnu.");
        }
        // génération d'une température aléatoire entre 10°C et 20°C
        Random random = new Random();
        int nombre = random.nextInt(100);
        double tre = (100+nombre)/10.0; // ex: 17.6
        // résultat
        return tre;
    }

}
