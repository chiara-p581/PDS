import java.util.*;

public abstract class Producto {

    private String nombre;
    private String descripcion;
    private double precio;
    private List<String> ingredientes;
    private List<String> ingredientesAlergenos;
    private int tiempoPreparacion;

    public Producto(String nombre, String descripcion, double precio,
                    List<String> ingredientes, List<String> ingredientesAlergenos, int tiempoPreparacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.ingredientesAlergenos = ingredientesAlergenos;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public List<String> getIngredientesAlergenos() {
        return ingredientesAlergenos;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    @Override
    public String toString() {
        return String.format(
                "Nombre: %s\nDescripción: %s\nPrecio: $%.2f\nIngredientes: %s\nAlergénicos: %s\nTiempo de preparación: %d min\n",
                nombre, descripcion, precio, ingredientes, ingredientesAlergenos, tiempoPreparacion
        );
    }
}
