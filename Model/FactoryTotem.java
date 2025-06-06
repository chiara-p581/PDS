import java.util.List;

public class FactoryTotem extends FactoryPedido {
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        return new PedidoTotem(cliente, productos);
    }
}

