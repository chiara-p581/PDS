import java.time.LocalDateTime;
import java.util.*;

public class PedidoControler implements Observer {
    private Map<Integer, Pedido> pedidos = new HashMap<>();
    private LocalDateTime hora;

    // Crea un nuevo pedido y lo agrega al mapa
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        int nuevoId = pedidos.size() + 1;
        Estado estadoInicial = new EnEspera();
        Pedido pedido = new Pedido(cliente, mesero, productos);

        pedido.setId(nuevoId); // Asignar ID al pedido

        // Calcular y asignar tiempo de espera
        int tiempoEspera = calcularTiempoEspera();
        pedido.setEspera(tiempoEspera);

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
        System.out.println("⏳ Tiempo estimado de espera: " + tiempoEspera + " unidades");
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
        for (Pedido pedido : this.pedidos.values()) {
            if ((pedido.getCliente().getId()).equals(clienteId)) {
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
        this.hora = hora;
        cambiarPedidosDeEstado();
    }

    public void cambiarPedidosDeEstado(){
        List<Pedido> pedidosEnEspera = obtenerPedidosPorEstado(new EnEspera());

        for (Pedido pedido : pedidosEnEspera) {
            if (pedido.getHorario().isAfter(hora)) {
                pedido.setEstado(new EnPreparacion());
            }
        }
    }

    public int calcularTiempoEspera(){
        int pedidosEnEspera = obtenerPedidosPorEstado(new EnEspera()).size();
        int pedidosEnPreparacion = obtenerPedidosPorEstado(new EnPreparacion()).size();
        int pedidosTotales = pedidosEnEspera + pedidosEnPreparacion;

        // Si hay menos de 10 pedidos, el tiempo es fijo: 5 minutos
        if (pedidosTotales < 10) {
            return 5;
        }

        // Por cada 10 pedidos, sumar 20 minutos
        int bloquesDe10 = pedidosTotales / 10;
        return bloquesDe10 * 20;
    }
}