import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class FactoryApp implements FactoryPedido {
    @Override
    public Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos, LocalTime horario) {
        return new PedidoApp(cliente, productos, mesero, horario);
    }
}
