import java.util.List;

public abstract class FactoryPedido {
    public abstract Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos);
}
