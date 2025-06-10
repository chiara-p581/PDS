public class Cancelado extends Estado{

    public Cancelado() {
        this.nombre = "Cancelado";
        System.out.println("❌ Estado final: El pedido fue cancelado.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        throw new IllegalStateException("No se puede avanzar un pedido cancelado.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente que el pedido fue Cancelado...");
        pedido.notificarUsuario("Su pedido fue cancelado.", pedido.getCliente());
    }

    public void reeembolsar(Pedido pedido) {
        System.out.println("Monto de reeembolso: $" + pedido.getDetalle().getTotal()*0.75);
    }
}