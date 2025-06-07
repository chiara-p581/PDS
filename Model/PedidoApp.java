import java.util.List;

public class PedidoApp extends Pedido {
    private Mesero mesero;
    private boolean delivery;
    private MedioNotificador medioNotificador;

    public PedidoApp(Cliente cliente, Mesero mesero, List<Producto> productos) {
        super(cliente, mesero, productos);
        this.delivery = false;
        this.medioNotificador = new MedioNotificadorApp();
    }

    public Mesero getMesero() {
        return mesero;
    }

    @Override
    public void notificarUsuario(String mensaje, Usuario usuario) {

    }

    public boolean isDelivery() {
        return delivery;
    }


}
