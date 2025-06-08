import java.util.List;

public class FactoryApp implements FactoryPedido {
    @Override
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        return new PedidoApp(cliente, productos, mesero);
    }
}
