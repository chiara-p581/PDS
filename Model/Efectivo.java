public class Efectivo extends MedioPago {

    @Override
    public boolean procesarPago(double monto, double saldoEnCuenta) {
        System.out.println("💵 Procesando pago en efectivo...");

        if (saldoEnCuenta >= monto) {
            double cambio = saldoEnCuenta - monto;
            System.out.println("✅ Pago en efectivo aprobado.");
            System.out.println("💰 Monto entregado: $" + saldoEnCuenta);
            System.out.println("💳 Monto del pedido: $" + monto);
            if (cambio > 0) {
                System.out.println("🪙 Cambio a entregar: $" + cambio + " ARS");
            } else {
                System.out.println("🟰 Pago justo, sin cambio.");
            }
            return true;
        } else {
            System.out.println("❌ Pago en efectivo rechazado. Dinero insuficiente.");
            System.out.println("💰 Dinero entregado: $" + saldoEnCuenta);
            System.out.println("💳 Monto requerido: $" + monto);
            return false;
        }
    }
}