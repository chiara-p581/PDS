import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface FactoryPedido {
    Pedido crearPedido(Cliente cliente, Mesero mesero, List<Producto> productos, LocalTime horario);
}