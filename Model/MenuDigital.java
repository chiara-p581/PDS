import java.util.*;

public class MenuDigital {

    private static MenuDigital instancia;

    private List<Producto> productos;

    private MenuDigital(List<Producto> productosIniciales) {
        this.productos = new ArrayList<>(productosIniciales);
    }

    public static void inicializar(List<Producto> productosIniciales) {
        if (instancia == null) {
            instancia = new MenuDigital(productosIniciales);
        } else {
            throw new IllegalStateException("El menú ya fue inicializado.");
        }
    }

    public static MenuDigital getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("El menú no fue inicializado todavía.");
        }
        return instancia;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<String> obtenerTodosLosProductos() {
        List<String> resultado = new ArrayList<>();
        for (Producto p : productos) {
            resultado.add(p.toString());
        }
        return resultado;
    }

    public List<Producto> obtenerPorCategoria(Class<?> tipo) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (tipo.isInstance(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        if (productos.isEmpty()) {
            return "📭 El menú está vacío.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("📋 Menú Digital:\n");
        sb.append("-----------------------------\n");

        for (Producto producto : productos) {
            sb.append(producto.toString()).append("\n");
        }

        sb.append("-----------------------------");
        return sb.toString();
    }
}
