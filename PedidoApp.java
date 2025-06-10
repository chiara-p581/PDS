import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class PedidoApp extends Pedido {
    private Mesero mesero;
    private boolean delivery;
    private MedioNotificador medioNotificador;

    public PedidoApp(Cliente cliente, List<Producto> productos, Mesero mesero, LocalTime horario) {
        super(cliente, productos, new EnEspera(), horario);
        this.mesero = mesero;
        this.medioNotificador = new MedioNotificadorApp();
        setMedioNotificador(medioNotificador);
    }

    public Mesero getMesero() {
        return mesero;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
}
