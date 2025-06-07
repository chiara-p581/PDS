import java.util.*;

public class Bebidas extends Producto {

    private Boolean alcoholica;

    public Bebidas(String nombre, String descripcion, double precio,
                   List<String> ingredientes, List<String> ingredientesAlergenos,
                   boolean alcoholica, int tiempoPreparacion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenos, tiempoPreparacion);
        this.alcoholica = alcoholica;
    }

    public Boolean getAlcoholica() {
        return alcoholica;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Bebidas{" +
                "alcoholica=" + alcoholica +
                '}';
    }
}
