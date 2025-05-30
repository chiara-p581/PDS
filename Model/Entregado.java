public class Entregado extends Estado {

    public Entregado() {
        this.nombre = "Entregado";
        System.out.println("🎉 Estado actual: *Entregado*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("✅ El pedido ID: " + pedido.getId() + " ya fue entregado. No puede avanzar más.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente: su pedido ha sido *entregado*...");
        pedido.notificarCliente("Su pedido ha sido entregado.");
        System.out.println("📤 Enviando factura al cliente...");
        pedido.generarFactura();
        pedido.getFactura().enviarFactura();
    }
}
