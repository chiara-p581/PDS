
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Tarjeta extends MedioPago {

    /**
     * Default constructor
     */
    public Tarjeta() {
    }

    /**
     * @param total 
     * @return
     */
    public abstract Boolean pagar(Float total);

    /**
     * @param monto
     */
    public abstract void procesarPago(double monto);

}