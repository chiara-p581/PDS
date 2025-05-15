public class EnPreparacion extends Estado {

    public EnPreparacion() {
        this.nombre = "En preparación";
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        pedido.setEstado(new ListoParaEntregar());
        System.out.println("El pedido pasó de 'En preparación' a 'Listo para entregar'");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Su pedido está en preparación.");
    }
}

