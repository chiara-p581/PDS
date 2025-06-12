
import java.io.*;
import java.util.*;

public class Postres extends Producto {

    private String nombre;
    private Boolean esFrio;
    private Boolean contieneAzucar;
    private Float precio;
    private List<String> ingredientes;
    private List<String> ingredientesAlergenicos;
    private String descripcion;

    public Postres(String nombre, Boolean esFrio, Boolean contieneAzucar, Float precio, List<String> ingredientes, List<String> ingredientesAlergenicos, String descripcion, int tiempoPreparacion) {
        super(nombre, descripcion, precio, ingredientes, ingredientesAlergenicos, tiempoPreparacion);
        this.esFrio = esFrio;
        this.contieneAzucar = contieneAzucar;
    }

    public Boolean getEsFrio() {
        return esFrio;
    }

    public Boolean getContieneAzucar() {
        return contieneAzucar;
    }


    @Override
    public String toString() {
        return "=== Postre ===\n" +
                super.toString() +
                String.format("¿Es frío?: %s\n¿Contiene azúcar?: %s\n",
                        esFrio ? "Sí" : "No",
                        contieneAzucar ? "Sí" : "No");
    }

}