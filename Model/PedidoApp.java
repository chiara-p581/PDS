import java.util.List;

public class PedidoApp extends Pedido {
    private Mesero mesero;
    private boolean delivery;

    public PedidoApp(Cliente cliente, Mesero mesero, List<Producto> productos) {
        super(cliente, mesero,productos); // o super(cliente, mesero, productos) si Pedido lo permite
        this.delivery = false;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public boolean isDelivery() {
        return delivery;
    }
}
