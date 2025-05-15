
import java.io.*;
import java.util.*;

/**
 * 
 */
public class TarjetaCredito extends Tarjeta {

    /**
     * Default constructor
     */
    public TarjetaCredito() {
    }

    /**
     * 
     */
    private String numero;

    /**
     * 
     */
    private String titular;

    /**
     * @param monto
     */
    public void procesarPago(double monto) {
        // TODO implement here
    }

    /**
     * @param total 
     * @return
     */
    public abstract Boolean pagar(Float total);

}