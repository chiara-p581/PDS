
import java.io.*;
import java.util.*;

public abstract class MedioPago {

    /**
     * Default constructor
     */
    public MedioPago() {
    }



    /**
     * @param monto
     */
    public abstract void procesarPago(double monto);

}