public class Cancelado extends Estado{

    public Cancelado() {
        this.nombre = "Cancelado";
        System.out.println("❌ Estado final: El pedido fue cancelado.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("⛔ El pedido está cancelado. No puede avanzar a otro estado.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente que el pedido fue Cancelado...");
        pedido.notificarCliente("Su pedido fue cancelado.");
    }

    public void reeembolsar(Pedido pedido) {
        System.out.println("Monto de reeembolso: $" + pedido.getDetalle().getTotal()*0.75);
    }
}