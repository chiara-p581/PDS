import java.util.List;

public class PedidoTotem extends Pedido {
    public PedidoTotem(Cliente cliente, List<Producto> productos) {
        super(cliente, productos, new EnEspera());

    }
}