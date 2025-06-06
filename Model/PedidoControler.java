import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoControler implements Observer {
    private Map<Integer, Pedido> pedidos = new HashMap<>();

    // Crea un nuevo pedido y lo agrega al mapa
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        int nuevoId = pedidos.size() + 1;
        Estado estadoInicial = new EnEspera();
        Pedido pedido = new Pedido(cliente, mesero, productos);
        pedido.setId(nuevoId); // Asignar ID al pedido
        pedidos.put(nuevoId, pedido);

        System.out.println("========================================");
        System.out.println("✅ ¡Pedido generado exitosamente!");
        System.out.println("🆔 ID del Pedido: " + nuevoId);
        System.out.println("👤 Cliente: " + cliente.getNombre() + " (ID: " + cliente.getId() + ")");
        System.out.println("🧑‍🍳 Mesero: " + mesero.getNombre());
        System.out.println("🛒 Productos solicitados:");
        for (Producto producto : productos) {
            System.out.println("   • " + producto.getNombre() + " - $" + producto.getPrecio());
        }
        System.out.println("📦 Estado inicial: " + estadoInicial.getClass().getSimpleName());
        System.out.println("========================================");

        return pedido;
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

    @Override
    public void actualizarHora(LocalDateTime hora) {
        System.out.println("Cambio de hora");
        System.out.println(hora.toString());
    }
}
