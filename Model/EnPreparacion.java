public class EnPreparacion extends Estado implements Cancelable {

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
        int tiempoPreparacion = pedido.getProductos().size() * 3;
        System.out.println("");
        System.out.println("📢 Notificando al cliente: su pedido está en preparación...");
        pedido.notificarUsuario("Su pedido está en preparación, con un tiempo estimado de " +  tiempoPreparacion + " minutos.", pedido.getCliente());
        System.out.println("");
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        System.out.println("🛑 Cancelando pedido ID: " + pedido.getId() + " en estado 'En preparación'...");

        // Cambiar el estado a Cancelado
        pedido.setEstado(new Cancelado());

        // Notificar al cliente
        pedido.notificarUsuario("Su pedido fue cancelado mientras estaba en preparación.", pedido.getCliente());

        // Reembolsar si corresponde
        if (pedido.getDetalle().getPago()) {
            System.out.println("💸 Procesando reembolso...");
            System.out.println("Monto reembolsado: " + pedido.getDetalle().getTotalConDescuento() * 0.75);
        } else {
            System.out.println("ℹ️ No se necesita reembolso ya que el pago no fue realizado.");
        }
    }
}