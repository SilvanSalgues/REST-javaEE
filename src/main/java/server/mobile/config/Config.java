package server.mobile.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Psycus34 on 06/10/2016.
 */

@ComponentScan(basePackages = { "server.mobile.metier",
        "server.mobile.web"})

@EnableAutoConfiguration
public class Config {
    /**
     * L'annotation @ComponentScan indique à Spring dans quels packages il va trouver
     * les 2 composants qu'il doit gérer :
     *      - le composant Metier, objet annoté @Service qui fournit la méthode de calcul
     *      - le composant TemperatureController, objet annoté @RestController qui
     *        décode les paramètres de la requête GET, appelle la méthode de calcul
     *        du composant Metier, et retourne un objet TemperatureReponse en Json
     *
     * L'annotation @EnableAutoConfiguration demande à Spring-Boot de configurer
     * l'application Spring MVC.
     * Spring-Boot assure de manière transparente cette tâche de configuration
     * en examinant les packages référencés dans les dépendances du projet.
     * On ne connait pas le résultat, c'est à dire la liste des classes Java
     * qui vont implémenter les couches logicielles appelées par les classes
     * métier : par exemple Hibernate, ...
     * La démarche utilisée par Spring-Boot pour générer tout cela est basée
     * sur la notion de "convention over configuration" qui dit que si on respecte
     * certaines conventions dans les dépendances, la configuration produite sera minimale.
     */
}
