public class ListoParaEntregar extends Estado {

    public ListoParaEntregar() {
        this.nombre = "Listo para entregar";
        System.out.println("📦 Estado actual: *Listo para entregar*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("⚠️ El pedido ID: " + pedido.getId() + " ya está listo para entregar. No puede avanzar más desde aquí.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente y al mesero que el pedido está *listo para entregar*...");
        pedido.notificarCliente("Su pedido está listo para entregar.");
        pedido.notificarMesero("El pedido #" + pedido.getId() + " está listo para entregar.");
    }
}
