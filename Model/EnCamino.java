public class EnCamino extends Estado {

    public EnCamino() {
        this.nombre = "En camino";
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(new Entregado());
        System.out.println("El pedido pasó de 'En camino' a 'Entregado'");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Su pedido está en camino.");
    }
}
