import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear medios de notificación
        MedioNotificador app = new App();
        MedioNotificador email = new Email();
        MedioPago debito = new TarjetaDebito();
        MedioPago credito = new TarjetaCredito();
        ClienteControler controlercliente = new ClienteControler();
        PedidoControler controlerPedido = new PedidoControler();

        // Crear cliente
        Cliente cliente = controlercliente.crearCliente(
                "Martin", app, debito,
                new Cupon("A123", 10, LocalDate.of(2025, 12, 15), false),
                1500
        );

        // Crear personal
        Mesero mesero = new Mesero("Carlos");
        Chef chef = new Chef("Gordon");

        // Crear productos
        Producto entrada = new Entradas("Bruschetta", false, 500,
                Arrays.asList("Pan", "Tomate"),
                Arrays.asList("Gluten"), "Tostada con verduras");
        Producto bebida = new Bebidas("Coca-Cola", false, 200,
                Arrays.asList("Azúcar", "Cafeína"),
                Arrays.asList("Cafeína"), "Bebida azucarada con gas");

        List<Producto> productos = new ArrayList<>(Arrays.asList(entrada, bebida));;

        //Crear pedido
        Pedido pedido = controlerPedido.crearPedido(cliente, mesero, productos);

        //Crear detalle
        pedido.generarDetalle();
        System.out.println("\n💳 Realizando el pago...");
        pedido.getDetalle().pagar();

        //Pasar los estados
        // Enviar notificación del estado actual
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n▶️ Avanzando al estado 'En preparación'...");
        chef.cambiarEstadoPedido(pedido); // De EnEspera a EnPreparacion
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n▶️ Avanzando al estado 'Listo para entregar'...");
        pedido.getEstado().avanzarEstado(pedido); // De EnPreparacion a ListoParaEntregar
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n▶️ Avanzando al estado 'En camino'...");
        pedido.setEstado(new EnCamino()); // Simulamos que el pedido salió
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n▶️ Avanzando al estado 'Entregado'...");
        pedido.getEstado().avanzarEstado(pedido); // De EnCamino a Entregado
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n🎊 Pedido completo.");

        //Crear pedido 2
        Cliente cliente2 = controlercliente.crearCliente(
                "Ana",
                email,
                credito,
                new Cupon("A524", 20, LocalDate.of(2025, 3, 15), false),
                50
        );

        Pedido pedido2 = new Pedido(cliente2, new Mesero("Carlos"), productos);
        pedido2.generarDetalle(); // total 1000
        pedido2.getDetalle().pagar(); // intenta pagar, debe fallar

        pedido2.setEstado(new EnEspera());
        controlerPedido.crearPedido(cliente2, new Mesero("Carlos"), productos);

        System.out.println("\n--- Pedido Cliente 2 ---");
        pedido2.notificarCambioEstado();
        chef.cambiarEstadoPedido(pedido2); // NO debe avanzar por pago no aprobado
        chef.cambiarEstadoPedido(pedido2); // sigue sin avanzar


    }
}
