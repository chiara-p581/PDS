public abstract class Empleado {
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para cambiar el estado del pedido
    public abstract void cambiarEstadoPedido(Pedido pedido);
}
