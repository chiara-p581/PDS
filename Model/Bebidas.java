import java.util.*;

public class Bebidas extends Producto {

    private Boolean alcoholica;

    public Bebidas(String nombre, Boolean alcoholica, double precio,
                   List<String> ingredientes, List<String> ingredientesAlergenos, String descripcion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenos);
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
