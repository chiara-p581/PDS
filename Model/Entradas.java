import java.util.*;

public class Entradas extends Producto {

    private Boolean esCaliente;

    public Entradas(String nombre, Boolean esCaliente, double precio,
                    List<String> ingredientes, List<String> ingredientesAlergenicos, String descripcion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos);
        this.esCaliente = esCaliente;
    }

    public Boolean getEsCaliente() {
        return esCaliente;
    }

}
