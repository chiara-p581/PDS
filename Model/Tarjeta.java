
import java.io.*;
import java.util.*;

public abstract class Tarjeta extends MedioPago {


    public abstract boolean procesarPago(double monto, double saldoEnCuenta);

}