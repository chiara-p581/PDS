import java.util.List;

public interface FactoryPedido {
    Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos);
}