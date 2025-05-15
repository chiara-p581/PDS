public class Entregado extends Estado {

    public Entregado() {
        this.nombre = "Entregado";
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("El pedido ya fue entregado. No puede avanzar más.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Su pedido ha sido entregado.");
    }
}
