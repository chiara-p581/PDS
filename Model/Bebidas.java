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
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public List<String> getIngredientes() {
        return super.getIngredientes();
    }

    @Override
    public List<String> getIngredientesAlergenos() {
        return super.getIngredientesAlergenos();
    }
}
