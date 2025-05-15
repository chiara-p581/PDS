public class Chef extends Empleado {
    public Chef(String nombre) {
        super(nombre);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        // El chef avanza el estado (ej: de EnEspera a EnPreparacion)
        pedido.getEstado().avanzarEstado(pedido);
        pedido.notificarCambioEstado();
    }
}
