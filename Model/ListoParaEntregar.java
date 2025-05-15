public class ListoParaEntregar extends Estado {

    public ListoParaEntregar() {
        this.nombre = "Listo para entregar";
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("El pedido ya está listo para entregar. No puede avanzar más.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Su pedido está listo para entregar.");
        pedido.getMesero().recibirNotificacion("El pedido #" + pedido.getId() + " está listo para entregar.");
    }
}
