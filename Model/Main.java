import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancias necesarias

        MedioPago efectivo = new Efectivo();
        MedioPago debito = new TarjetaDebito();
        MedioPago credito = new TarjetaCredito();
        ClienteControler clienteControler = new ClienteControler();
        PedidoControler controlerPedido = new PedidoControler();


        // Crear cliente
        //Programarlo con local time
        Cupon cupon = new Cupon("DESCUENTO10", 10, LocalDate.of(2025, 6, 9));  // suponiendo un 20% de descuento
        MedioPago medio = new TarjetaCredito();  // o cualquier clase que implementa MedioPago
        Cliente clienteConCupon = clienteControler.crearCliente("Ana Gómez", "anaGomez@gmail.com", medio, cupon, 7000);
        Cliente cliente = clienteControler.crearCliente("Juan Pérez", "juanperez@gmail.com", efectivo, null, 3000);

        // Crear personal

        Mesero mesero = new Mesero("Carlos", "carlos@gmail.com");
        Chef chef = new Chef("Gordon", "gordon@gmail.com");
        Mesero mesero1 = new Mesero("Laura", "laura@gmail.com");
        Chef chef1 = new Chef("Remy", "remy@ratatouille.com");


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

        Producto entrada1 = new Entradas("Provoleta", "Queso derretido con orégano", 600,
                Arrays.asList("Queso"), Arrays.asList("Lactosa"), false, 5);
        Producto bebida1 = new Bebidas("Agua sin gas", "Agua mineral", 150,
                Arrays.asList("Agua"), new ArrayList<>(), true, 0);
        Producto plato1 = new PlatosPrincipales("Hamburguesa", 400, 1800,
                Arrays.asList("Carne", "Pan", "Queso"), Arrays.asList("Gluten", "Lactosa"),
                "Hamburguesa con papas fritas", 15);
        Producto postre1 = new Postres("Tiramisú", true, true, 500.0F,
                Arrays.asList("Queso", "Café", "Bizcocho"), Arrays.asList("Gluten", "Lactosa"),
                "Clásico tiramisú italiano", 0);


        menu.agregarProducto(entrada);
        menu.agregarProducto(bebida);
        menu.agregarProducto(plato);
        menu.agregarProducto(postre);
        menu.agregarProducto(entrada1);
        menu.agregarProducto(bebida1);
        menu.agregarProducto(plato1);
        menu.agregarProducto(postre1);

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

        //Pedido 2 con totem

        //productos agregados a pedido
        List<Producto> productos1 = new ArrayList<>(Arrays.asList(plato1, bebida1, postre1));


        // Crear pedido desde Totem
        Pedido pedido1 = controlerPedido.crearPedidoDesdeTotem(cliente, mesero1, productos1, null);

        // Generar detalle y pagar
        pedido1.generarDetalle();
        System.out.println("\n💳 Realizando el pago...");
        pedido1.getDetalle().pagar();

        // Cambiar estados del pedido
        System.out.println(controlerPedido.cambiarPedidosDeEstado());

        // Notificar estados
        pedido1.getEstado().notificarEstado(pedido1);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'En preparación'...");
        chef.cambiarEstadoPedido(pedido1);
        pedido1.getEstado().notificarEstado(pedido1);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'Listo para entregar'...");
        pedido1.getEstado().avanzarEstado(pedido1);
        pedido1.getEstado().notificarEstado(pedido1);

        System.out.println("");

        System.out.println("\n▶️ Avanzando al estado 'Entregado'...");
        pedido1.getEstado().avanzarEstado(pedido1);
        pedido1.getEstado().notificarEstado(pedido1);

        System.out.println("\n🎊 Pedido completo desde el Totem.");

    }
}
