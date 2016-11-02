package server.mobile.metier;

/**
 * Created by Psycus34 on 06/10/2016.
 */
public class TemperatureException extends RuntimeException {
    public TemperatureException() {
    }

    public TemperatureException(String message) {
        super(message);
    }

    public TemperatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemperatureException(Throwable cause) {
        super(cause);
    }
}
