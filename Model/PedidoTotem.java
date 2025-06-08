import java.util.List;

public class PedidoTotem extends Pedido {

    private MedioNotificador medioNotificador;

    public PedidoTotem(Cliente cliente, List<Producto> productos) {
        super(cliente, productos, new EnEspera());
        this.medioNotificador = new MedioNotificadorTotem();
    }

    public void notificarUsuario(String mensaje, Usuario usuario) {
        //ver
    }
}