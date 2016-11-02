package server.mobile.metier;

/**
 * Created by Psycus34 on 06/10/2016.
 */
public interface I_Metier {
    public double getTemperature (String nomCapteur) throws TemperatureException;
}
