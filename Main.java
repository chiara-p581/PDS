import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancias necesarias

        MedioPago debito = new TarjetaDebito();
        MedioPago credito = new TarjetaCredito();
        ClienteControler clienteControler = new ClienteControler();
        PedidoControler controlerPedido = new PedidoControler();
        //controlerPedido.actualizarHora(LocalTime.now());


        // Crear cliente
        //Programarlo con local time
        Cupon cupon = new Cupon("DESCUENTO10", 10, LocalDate.of(2025, 6, 9));  // suponiendo un 20% de descuento
        MedioPago medio = new TarjetaCredito();  // o cualquier clase que implementa MedioPago
        Cliente clienteConCupon = clienteControler.crearCliente("Ana Gómez", "anaGomez@gmail.com", medio, cupon, 7000);


        // Crear personal

        Mesero mesero = new Mesero("Carlos", "carlos@gmail.com");
        Chef chef = new Chef("Gordon", "gordon@gmail.com");


        //Crear menu

        MenuDigital menu = new MenuDigital();


        // Crear productos

        Producto entrada = new Entradas("Bruschetta", "Tostada con verduras", 500,
                Arrays.asList("Pan", "Tomate"), Arrays.asList("Gluten"), false,
                5
        );
        Producto bebida = new Bebidas("Coca-Cola", "Bebida azucarada con gas", 200,
                Arrays.asList("Azúcar", "Cafeína"), Arrays.asList("Cafeína"), false,
                0
        );

        Producto plato = new PlatosPrincipales(
                "Milanesa con papas", 400, 1500,
                Arrays.asList("Carne", "Pan rallado", "Papa"), Arrays.asList("Gluten"),
                "Clásica milanesa con papas fritas", 20
        );

        Producto postre = new Postres(
                "Helado", true, true, 350f,
                Arrays.asList("Leche", "Azúcar"), Arrays.asList("Lactosa"),
                "Helado artesanal", 0
        );

        menu.agregarProducto(entrada);
        menu.agregarProducto(bebida);
        menu.agregarProducto(plato);
        menu.agregarProducto(postre);

        List<Producto> productos = new ArrayList<>(Arrays.asList(entrada, bebida));

        System.out.println(menu.toString());


        // Usar la factory
        FactoryApp factoryA = new FactoryApp();
        FactoryTotem factoryTotem = new FactoryTotem();


        //Crear pedido programado
        Pedido pedido = controlerPedido.crearPedidoDesdeApp(clienteConCupon, mesero, productos, LocalTime.now().plusMinutes(10));

        if (pedido instanceof PedidoApp pedidoApp) {
            pedidoApp.setDelivery(true); // o false, según corresponda
        }


        //Crear detalle
        pedido.generarDetalle();
        System.out.println("\n💳 Realizando el pago...");
        pedido.getDetalle().pagar();

        //Pasar los estados

        System.out.println(controlerPedido.cambiarPedidosDeEstado());


        // Enviar notificación del estado actual
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'En preparación'...");
        chef.cambiarEstadoPedido(pedido); // De EnEspera a EnPreparacion
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'Listo para entregar'...");
        pedido.getEstado().avanzarEstado(pedido); // De EnPreparacion a ListoParaEntregar
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'En camino'...");
        pedido.setEstado(new EnCamino()); // Simulamos que el pedido salió
        pedido.getEstado().notificarEstado(pedido);

        controlerPedido.cancelarPedido(pedido);

        System.out.println("\n▶️ Avanzando al estado 'Entregado'...");
        pedido.getEstado().avanzarEstado(pedido); // De EnCamino a Entregado
        pedido.getEstado().notificarEstado(pedido);

        System.out.println("\n🎊 Pedido completo.");

        /*
        //Crear pedido 2
        Cliente cliente2 = controlercliente.crearCliente(
                "Ana",
                medioNotificador,
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

        */
    }
}
