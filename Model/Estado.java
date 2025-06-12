public abstract class Estado {

    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public abstract void avanzarEstado(Pedido pedido);

    public abstract void notificarEstado(Pedido pedido);
}
