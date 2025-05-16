
import java.io.*;
import java.util.*;

public class TarjetaCredito extends Tarjeta {

    private String numero;
    private String titular;
    private double girarEnDescubierto = 300;

    public boolean procesarPago(double monto, double saldoEnCuenta) {
        if(saldoEnCuenta - monto >= 0) {
            return true;
        }else{
            return (saldoEnCuenta - monto + girarEnDescubierto) >= 0;
        }
    }


}