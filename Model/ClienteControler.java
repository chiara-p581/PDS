import java.util.HashMap;
import java.util.Map;

public class ClienteControler {

    private Map<Integer, Cliente> clientes = new HashMap<>();

    public Cliente crearCliente(Integer id, String nombre, MedioNotificador notificador, MedioPago pago) {
        if (clientes.containsKey(id)) {
            System.out.println("Cliente con ID " + id + " ya existe.");
            return clientes.get(id);
        }

        Cliente cliente = new Cliente(id, nombre, notificador, pago);
        clientes.put(id, cliente);
        return cliente;
    }

    public Cliente crearClienteCupon(Integer id, String nombre, MedioNotificador notificador, MedioPago pago, Cupon cupon) {
        if (clientes.containsKey(id)) {
            System.out.println("Cliente con ID " + id + " ya existe.");
            return clientes.get(id);
        }

        Cliente cliente = new Cliente(id, nombre, notificador, cupon, pago);
        clientes.put(id, cliente);
        return cliente;
    }

    public boolean existeCliente(Integer id) {
        return clientes.containsKey(id);
    }
}
