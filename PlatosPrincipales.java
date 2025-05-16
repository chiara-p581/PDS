
import java.io.*;
import java.util.*;

public class PlatosPrincipales extends Producto {

    private String nombre;
    private int tamañoPorcion;
    private double precio;
    private List<String> ingredientes;
    private List<String> ingredientesAlergenicos;
    private String descripcion;

    public PlatosPrincipales(String nombre, int tamañoPorcion, double precio, List<String> ingredientes, List<String> ingredientesAlergenicos, String descripcion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos);
        this.tamañoPorcion = tamañoPorcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getTamañoPorcion() {
        return tamañoPorcion;
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
        return super.toString() +
                "Tamaño de Porción" +
                tamañoPorcion;
    }
}