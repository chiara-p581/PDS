public class EnEspera extends Estado {

    public EnEspera() {
        this.nombre = "En espera";
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        // Avanza al siguiente estado, por ejemplo: "En preparación"
        if (pedido.getDetalle().getPago()){
            pedido.setEstado(new EnPreparacion());
            System.out.println("El pedido pasó de 'En espera' a 'En preparación'");
        }
        System.out.println("El pago debe estar aprobado para poder avanzar");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        pedido.getCliente().recibirNotificacion("Su pedido está en espera.");
    }
}
