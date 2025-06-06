public class EnCamino extends Estado {

    public EnCamino() {
        this.nombre = "En camino";
        System.out.println("🛵 Estado actual: *En camino*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(new Entregado());
        System.out.println("✅ El pedido ID: " + pedido.getId() + " avanzó de 'En camino' a 'Entregado'.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente: su pedido está *en camino*...");
        pedido.notificarCliente("Su pedido está en camino.");
    }
}
