import java.io.*;

public class TarjetaCredito extends Tarjeta {

    private String numero;
    private String titular;
    private double girarEnDescubierto = 300;

    public boolean procesarPago(double monto, double saldoEnCuenta) {
        if (saldoEnCuenta >= monto) {
            double nuevoSaldo = saldoEnCuenta - monto;
            System.out.println("Pago aprobado con crédito (saldo suficiente).");
            System.out.println("Monto debitado: $" + monto);
            System.out.println("Saldo restante: $" + nuevoSaldo);
            return true;
        } else if ((saldoEnCuenta + girarEnDescubierto) >= monto) {
            double descubiertoUsado = monto - saldoEnCuenta;
            System.out.println("Pago aprobado con crédito usando descubierto.");
            System.out.println("Monto debitado: $" + monto);
            System.out.println("Descubierto utilizado: $" + descubiertoUsado);
            System.out.println("Saldo restante: $0.00");
            return true;
        } else {
            System.out.println("Pago rechazado. Excede el límite de descubierto.");
            System.out.println("Saldo disponible + descubierto: $" + (saldoEnCuenta + girarEnDescubierto));
            System.out.println("Monto requerido: $" + monto);
            return false;
        }
    }
}
