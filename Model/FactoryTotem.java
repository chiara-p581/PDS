import java.util.List;

public class FactoryTotem implements FactoryPedido {

    @Override
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        return new PedidoTotem(cliente, productos); // ignora mesero
    }

}