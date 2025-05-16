public class EnPreparacion extends Estado {

    public EnPreparacion() {
        this.nombre = "En preparación";
        System.out.println("👨‍🍳 Estado actual: *En preparación*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
        System.out.println("✅ El pedido ID: " + pedido.getId() + " avanzó de 'En preparación' a 'Listo para entregar'.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente: su pedido está *en preparación*...");
        pedido.getCliente().recibirNotificacion("Su pedido está en preparación.");
    }
}
