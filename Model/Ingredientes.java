
import java.io.*;
import java.util.*;

//ver esto
public abstract class Ingredientes extends Producto {

    private String nombre;
    private Boolean alergenico;
    private String descripcion;

    public Ingredientes(String nombre, Boolean alergenico, String descripcion) {
        this.nombre = nombre;
        this.alergenico = alergenico;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public Boolean getAlergenico() {
        return alergenico;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}