import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class PedidoTotem extends Pedido {

    private MedioNotificador medioNotificador;

    public PedidoTotem(Cliente cliente, List<Producto> productos, LocalTime horario) {
        super(cliente, productos, new EnEspera(), horario);
        this.medioNotificador = new MedioNotificadorTotem();
        setMedioNotificador(medioNotificador);
    }

}