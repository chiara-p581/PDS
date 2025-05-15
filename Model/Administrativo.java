public class Administrativo extends Empleado {
    public Administrativo(String nombre) {
        super(nombre);
    }

    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        // El administrativo avanza el estado (ej: de EnEspera a EnPreparacion)
        pedido.getEstado().avanzarEstado(pedido);
        pedido.notificarCambioEstado();
    }
}
