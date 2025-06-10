public class MercadoPago extends MedioPago {

    @Override
    public boolean procesarPago(double monto, double saldoEnCuenta) {
        System.out.println("Procesando pago con Mercado Pago...");

        if (saldoEnCuenta >= monto) {
            double nuevoSaldo = saldoEnCuenta - monto;
            System.out.println("✅ Pago aprobado con Mercado Pago.");
            System.out.println("💳 Monto debitado: $" + monto);
            System.out.println("💰 Saldo restante en cuenta: $" + nuevoSaldo);
            return true;
        } else {
            System.out.println("❌ Pago rechazado con Mercado Pago. Fondos insuficientes.");
            System.out.println("💰 Saldo disponible: $" + saldoEnCuenta);
            System.out.println("💸 Monto requerido: $" + monto);
            return false;
        }
    }
}