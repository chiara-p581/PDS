public class EnPreparacion extends Estado {

    public EnPreparacion() {
        this.nombre = "En preparación";
        System.out.println("👨‍🍳 Estado actual: En preparación.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
        System.out.println("✅ El pedido ID: " + pedido.getId() + " avanzó de 'En preparación' a 'Listo para entregar'.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente: su pedido está en preparación...");
        pedido.notificarCliente("Su pedido está en preparación.");
    }

    public void cancelarPedido(Pedido pedido) {
        System.out.println("🛑 Cancelando pedido ID: " + pedido.getId() + " en estado 'En preparación'...");

        // Cambiar el estado a Cancelado
        pedido.setEstado(new Cancelado());

        // Notificar al cliente
        pedido.notificarCliente("Su pedido fue cancelado mientras estaba en preparación.");

        // Reembolsar si corresponde
        if (pedido.getDetalle().getPago()) {
            System.out.println("💸 Procesando reembolso...");
            // Lógica de reembolso si se desea
        } else {
            System.out.println("ℹ️ No se necesita reembolso ya que el pago no fue realizado.");
        }
    }
}