
import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Cupon {

    private String codigo;
    private double porcentajeDescuento; //se almacena como 10
    private LocalDate vencimiento;
    private Boolean valido;

    public Cupon(String codigo, double porcentajeDescuento, LocalDate vencimiento, Boolean valido) {
        this.codigo = codigo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.vencimiento = vencimiento;
        this.valido = valido;
    }

    public boolean esValido() {
        LocalDate fechaActual = LocalDate.now();
        if (vencimiento.isBefore(fechaActual))
            return true;
        return false;
    }


    public void invalidar() {
        valido = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

}