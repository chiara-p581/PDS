public class GooglePay extends MedioPago {

    @Override
    public boolean procesarPago(double monto, double saldoEnCuenta) {
        System.out.println("Procesando pago con Google Pay...");

        if (saldoEnCuenta >= monto) {
            double nuevoSaldo = saldoEnCuenta - monto;
            System.out.println("✅ Pago aprobado con Google Pay.");
            System.out.println("💳 Monto debitado: $" + monto);
            System.out.println("💰 Saldo restante: $" + nuevoSaldo);
            return true;
        } else {
            System.out.println("❌ Pago rechazado con Google Pay. Fondos insuficientes.");
            System.out.println("💰 Saldo disponible: $" + saldoEnCuenta);
            System.out.println("💸 Monto requerido: $" + monto);
            return false;
        }
    }
}