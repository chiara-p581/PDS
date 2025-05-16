public class DetallePedido {

    private double total;
    private Cupon cupon;
    private Cliente cliente;
    private boolean pago;

    public DetallePedido(double total, Cupon cupon, Cliente cliente) {
        this.total = total;
        this.cupon = cupon;
        this.cliente = cliente;

        System.out.println("========================================");
        System.out.println("📄 Detalle de Pedido generado:");
        System.out.println("👤 Cliente: " + cliente.getNombre());
        System.out.println("💰 Total sin descuento: $" + total);

        if (cupon != null) {
            System.out.println("🎟 Cupón aplicado: " + cupon.getCodigo() + " (" + cupon.getPorcentajeDescuento() + "% de descuento)");
            System.out.println("💰 Total con descuento: $" + getTotalConDescuento());
        } else {
            System.out.println("🎟 Cupón: No se aplicó cupón.");
        }

        System.out.println("========================================");
    }

    public double getTotal() {
        return total;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public double getTotalConDescuento() {
        if (cupon != null) {
            return (100 - cupon.getPorcentajeDescuento()) / 100.0 * total;
        }
        return total;
    }

    public boolean getPago() {
        return pago;
    }

    public void pagar() {
        double montoFinal = getTotalConDescuento();
        System.out.println("========================================");
        System.out.println("💳 Intentando procesar pago...");
        System.out.println("👤 Cliente: " + cliente.getNombre());
        System.out.println("💰 Monto a pagar: $" + montoFinal);

        pago = cliente.pagar(montoFinal);

        if (pago) {
            System.out.println("✅ Pago realizado con éxito.");
        } else {
            System.out.println("❌ Pago fallido. Saldo insuficiente o medio de pago rechazado.");
        }
        System.out.println("========================================");
    }
}
