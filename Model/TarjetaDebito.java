
import java.io.*;
import java.util.*;

public class TarjetaDebito extends Tarjeta {

    private String numero;
    private String titular;


    public boolean procesarPago(double monto, double saldoEnCuenta) {
        return saldoEnCuenta - monto >= 0;
    }

}