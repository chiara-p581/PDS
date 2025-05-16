
import java.util.*;

public class MenuDigital {

    private List<Producto> productos;

    public MenuDigital(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).equals(producto)) {
                productos.remove(i);
            }
        }
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

}