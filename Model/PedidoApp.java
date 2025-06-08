import java.util.List;

public class PedidoApp extends Pedido {
    private Mesero mesero;
    private boolean delivery;
    private MedioNotificador medioNotificador;

    public PedidoApp(Cliente cliente, List<Producto> productos, Mesero mesero) {
        super(cliente, productos, new EnEspera());
        this.mesero = mesero;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void notificarUsuario(String mensaje, Usuario usuario) {
        //ver
    }

    public boolean isDelivery() {
        return delivery;
    }


}
