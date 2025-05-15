
import java.io.*;
import java.util.*;

public abstract class Postres extends Producto {

    private String nombre;
    private Boolean esFrio;
    private Boolean contieneAzucar;
    private Float precio;
    private List<String> ingredientes;
    private List<String> ingredientesAlergenicos;
    private String descripcion;

    public Postres(String nombre, Boolean esFrio, Boolean contieneAzucar, Float precio, List<String> ingredientes, List<String> ingredientesAlergenicos, String descripcion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos);
        this.esFrio = esFrio;
        this.contieneAzucar = contieneAzucar;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public Boolean getEsFrio() {
        return esFrio;
    }

    public Boolean getContieneAzucar() {
        return contieneAzucar;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public List<String> getIngredientesAlergenicos() {
        return ingredientesAlergenicos;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Postres{" +
                "esFrio=" + esFrio +
                ", contieneAzucar=" + contieneAzucar +
                '}';
    }
}