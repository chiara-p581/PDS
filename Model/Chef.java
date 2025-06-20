public class Chef extends Empleado {
    public Chef(String nombre, String email) {
        super(nombre, email);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        // El chef avanza el estado (ej: de EnEspera a EnPreparacion)
        pedido.getEstado().avanzarEstado(pedido);
        pedido.notificarCambioEstado();
    }
}
