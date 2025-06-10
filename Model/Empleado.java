public abstract class Empleado extends Usuario{
    private String nombre;

    public Empleado(String nombre, String email) {
        super(nombre, email);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para cambiar el estado del pedido
    public abstract void cambiarEstadoPedido(Pedido pedido);
}
