package server.mobile.boot;

import org.springframework.boot.SpringApplication;
import server.mobile.config.Config;

/**
 * Created by Psycus34 on 06/10/2016.
 */
public class Application {
    public static void main(String[] args) {

        // lancement du serveur d'application
        SpringApplication.run(Config.class);
        /**
         * 1er param : la classe de configuration générée par les annotations Spring
         *             (dans le package config)
         * 2nd param : le tableau des arguments passés à la méthode main()
         */
    }
}
