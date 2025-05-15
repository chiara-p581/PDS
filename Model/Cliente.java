
import java.io.*;
import java.util.*;


public class Cliente {

    private Integer id;
    private String nombre;
    private MedioNotificador medioPreferido;
    private Cupon cupon;
    private MedioPago medioPago;

    public Cliente(Integer id, String nombre, MedioNotificador medioPreferido, Cupon cupon, MedioPago medioPago) {
        this.id = id;
        this.nombre = nombre;
        this.medioPreferido = medioPreferido;
        this.cupon = cupon;
        this.medioPago = medioPago;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Cupon getCupon() {
        return this.cupon;
    }

    public MedioNotificador getMedioPreferido() {
        return this.medioPreferido;
    }

    public void recibirNotificacion(String mensaje) {
        if (medioPreferido != null) {
            medioPreferido.notificar(mensaje, this);
            return;
        }
        System.out.println("[Cliente " + nombre + "]: " + mensaje);
    }

    public MedioPago getMedioPago() {
        return this.medioPago;
    }

    public void pagar(double monto) {
        // TODO implement here
    }

    public void hacerPedido() {
        // TODO implement here
    }

}