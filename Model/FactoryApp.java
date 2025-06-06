import java.util.List;

public class FactoryApp extends FactoryPedido {
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        return new PedidoApp(cliente, mesero, productos);
    }
}
