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
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", ingredientes=" + ingredientes +
                ", ingredientesAlergenos=" + ingredientesAlergenos +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
}
