import java.util.*;

public class Entradas extends Producto {

    private Boolean esCaliente;

    public Entradas(String nombre, String descripcion, double precio,
                    List<String> ingredientes, List<String> ingredientesAlergenicos,
                    boolean esCaliente, int tiempoPreparacion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos, tiempoPreparacion);
        this.esCaliente = esCaliente;
    }

    public Boolean getEsCaliente() {
        return esCaliente;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Entradas{" +
                "esCaliente=" + esCaliente +
                '}';
    }
}
