
import java.io.*;
import java.util.*;

public class PlatosPrincipales extends Producto {

    private String nombre;
    private int tamañoPorcion;
    private double precio;
    private List<String> ingredientes;
    private List<String> ingredientesAlergenicos;
    private String descripcion;

    public PlatosPrincipales(String nombre, int tamañoPorcion, double precio, List<String> ingredientes, List<String> ingredientesAlergenicos, String descripcion, int tiempoPreparacion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos, tiempoPreparacion);
        this.tamañoPorcion = tamañoPorcion;
    }

    public int getTamañoPorcion() {
        return tamañoPorcion;
    }

    @Override
    public String toString() {
        return "=== Plato Principal ===\n" +
                super.toString() +
                String.format("Tamaño de porción: %d g\n", tamañoPorcion);
    }

}