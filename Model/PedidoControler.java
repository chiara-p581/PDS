import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoControler {
    private Map<Integer, Pedido> pedidos = new HashMap<>();

    // Crea un nuevo pedido y lo agrega al mapa
    public void crearPedido(Pedido pedido) {
        if (pedidos.containsKey(pedido.getId())) {
            System.out.println("Ya existe un pedido con el ID " + pedido.getId());
            return;
        }
        pedidos.put(pedido.getId(), pedido);
    }

    // Busca un pedido por ID
    public Pedido buscarPedido(Integer id) {
        return pedidos.get(id);
    }

    // Retorna todos los pedidos realizados por un cliente dado su ID
    public List<Pedido> obtenerPedidosPorCliente(Integer clienteId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos.values()) {
            if (pedido.getCliente().getId().equals(clienteId)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    // Retorna todos los pedidos que están en un estado específico
    public List<Pedido> obtenerPedidosPorEstado(Estado estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos.values()) {
            if (pedido.getEstado().getClass().equals(estado.getClass())) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }
}
