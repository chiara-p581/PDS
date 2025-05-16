import java.util.HashMap;
import java.util.Map;

public class ClienteControler {

    private Map<Integer, Cliente> clientes = new HashMap<>();

    private int generarNuevoId() {
        return clientes.size() + 1;
    }

    public Cliente crearCliente(String nombre, MedioNotificador notificador, MedioPago pago, double saldoEnCuenta) {
        int nuevoId = generarNuevoId();
        Cliente cliente = new Cliente(nombre, notificador, pago, saldoEnCuenta);
        cliente.setId(nuevoId);
        clientes.put(nuevoId, cliente);

        System.out.println("========================================");
        System.out.println("🆕 ¡Cliente creado exitosamente!");
        System.out.println("🆔 ID: " + nuevoId);
        System.out.println("👤 Nombre: " + nombre);
        System.out.println("📣 Medio de notificación preferido: " + notificador.getClass().getSimpleName());
        System.out.println("💳 Medio de pago: " + pago.getClass().getSimpleName());
        System.out.println("💰 Saldo inicial: $" + saldoEnCuenta);
        System.out.println("🎟 Cupon: Sin cupón aplicado");
        System.out.println("========================================");

        return cliente;
    }

    public Cliente crearClienteCupon(String nombre, MedioNotificador notificador, MedioPago pago, Cupon cupon, double saldoEnCuenta) {
        int nuevoId = generarNuevoId();
        Cliente cliente = new Cliente(nombre, notificador, cupon, pago, saldoEnCuenta);
        cliente.setId(nuevoId);
        clientes.put(nuevoId, cliente);

        System.out.println("========================================");
        System.out.println("🆕 ¡Cliente creado exitosamente!");
        System.out.println("🆔 ID: " + nuevoId);
        System.out.println("👤 Nombre: " + nombre);
        System.out.println("📣 Medio de notificación preferido: " + notificador.getClass().getSimpleName());
        System.out.println("💳 Medio de pago: " + pago.getClass().getSimpleName());
        System.out.println("💰 Saldo inicial: $" + saldoEnCuenta);
        System.out.println("🎟 Cupon: Código " + cupon.getCodigo() + ", Descuento: " + cupon.getPorcentajeDescuento() + "%, Válido hasta: " + cupon.getVencimiento());
        System.out.println("========================================");

        return cliente;
    }

    public boolean existeCliente(Integer id) {
        return clientes.containsKey(id);
    }
}
