import java.io.*;

public class TarjetaDebito extends Tarjeta {

    private String numero;
    private String titular;

    public boolean procesarPago(double monto, double saldoEnCuenta) {
        if (saldoEnCuenta >= monto) {
            double nuevoSaldo = saldoEnCuenta - monto;
            System.out.println("========================================");
            System.out.println("Pago aprobado con débito.");
            System.out.println("Monto debitado: $" + monto);
            System.out.println("Saldo restante: $" + nuevoSaldo);
            System.out.println("========================================");
            return true;
        } else {
            System.out.println("========================================");
            System.out.println("Pago rechazado. Fondos insuficientes.");
            System.out.println("Saldo disponible: $" + saldoEnCuenta + " | Monto requerido: $" + monto);
            System.out.println("========================================");
            return false;
        }
    }
}
