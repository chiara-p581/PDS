public class Mesero extends Empleado {

    public Mesero(String nombre) {
        super(nombre);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        // El mesero solo puede avanzar si está en "ListoParaEntregar"
        if (pedido.getEstado() instanceof ListoParaEntregar) {
            pedido.getEstado().avanzarEstado(pedido);
            pedido.notificarCambioEstado();
        } else {
            System.out.println("El mesero no puede avanzar este estado.");
        }
    }

    public void recibirNotificacion(String mensaje) {
        System.out.println("[Mesero " + getNombre() + "]: " + mensaje);
    }
}
