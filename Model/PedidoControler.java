import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class PedidoControler implements Observer {
    private Map<Integer, Pedido> pedidos = new HashMap<>();
    private LocalTime hora;

    public PedidoControler() {
        actualizarHora(LocalTime.now());
    }

    private int generarNuevoId() {
        return pedidos.size() + 1;
    }

    public Pedido crearPedidoDesdeApp(Cliente cliente, Mesero mesero, List<Producto> productos, LocalTime horario) {
        return crearPedido(cliente, productos, mesero, new FactoryApp(), horario);
    }

    public Pedido crearPedidoDesdeTotem(Cliente cliente, Mesero mesero, List<Producto> productos, LocalTime horario) {
        return crearPedido(cliente, productos, mesero, new FactoryTotem(), horario);
    }

    // Crea un nuevo pedido y lo agrega al mapa
    private Pedido crearPedido(Cliente cliente, List<Producto> productos, Mesero mesero, FactoryPedido factory, LocalTime horario) {
        int nuevoId = generarNuevoId();
        Pedido pedido = factory.crearPedido(cliente, mesero, productos, horario);
        pedido.setId(nuevoId);
        int espera = calcularTiempoEspera();
        pedido.setEspera(espera);
        pedidos.put(nuevoId, pedido);

        mostrarResumenPedido(pedido);
        pedido.notificarUsuario("Tu pedido ha sido registrado exitosamente.", pedido.getCliente());

        return pedido;
    }

    private void mostrarResumenPedido(Pedido pedido) {
        System.out.println("========================================");
        System.out.println("✅ ¡Pedido generado exitosamente!");
        System.out.println("🆔 ID del Pedido: " + pedido.getId());
        System.out.println("👤 Cliente: " + pedido.getCliente().getNombre());
        System.out.println("🛒 Productos solicitados:");
        for (Producto p : pedido.getProductos()) {
            System.out.println("   • " + p.getNombre() + " - $" + p.getPrecio());
        }
        System.out.println("📦 Estado inicial: " + pedido.getEstado().getClass().getSimpleName());
        System.out.println("⏳ Tiempo estimado de espera: " + pedido.getEspera() + " minutos");
        System.out.println("========================================");
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
            if (pedido.getEstado().getClass().equals(estado.getClass()) && pedido.isProgramado()) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    @Override
    public void actualizarHora(LocalTime hora) {
        this.hora = hora;
        cambiarPedidosDeEstado();
    }

    public boolean cambiarPedidosDeEstado(){
        List<Pedido> pedidosEnEspera = obtenerPedidosPorEstado(new EnEspera());

        for (Pedido pedido : pedidosEnEspera) {
            if (pedido.getHorario().isAfter(hora)) {
                pedido.setEstado(new EnPreparacion());
                System.out.println("*****************");
                System.out.println("El pedido programado " + pedido.getId() + "se pasó de estado");
                System.out.println("*****************");
                return true;
            }
        }
        return false;
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

    public void cancelarPedido(Pedido pedido) {
        Estado estadoActual = pedido.getEstado();

        if (estadoActual instanceof Cancelable) {
            ((Cancelable) estadoActual).cancelarPedido(pedido);
        } else {
            System.out.println("❌ No se puede cancelar el pedido en el estado actual: " + estadoActual.getNombre());
        }
    }
}