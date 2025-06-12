import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public abstract class Pedido {

    private Integer id;
    private Cliente cliente;
    private List<Producto> productos;
    private Estado estado;
    private DetallePedido detalle;
    private Factura factura;
    private LocalTime horario;
    private int espera;
    protected MedioNotificador medioNotificador;
    private boolean programado;

    protected Pedido(Cliente cliente, List<Producto> productos, Estado estado, LocalTime horario) {
        this.cliente = cliente;
        this.productos = productos;
        this.estado = estado;
        this.horario = horario;
        if (horario == null) {
            this.programado = false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Estado getEstado() {
        return estado;
    }

    public DetallePedido getDetalle() {
        return detalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public boolean isProgramado() {
        return programado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }

    public int getEspera() {
        return espera;
    }

    public void setMedioNotificador(MedioNotificador medioNotificador) {
        this.medioNotificador = medioNotificador;
    }

    public void notificarCambioEstado() {
        if (estado != null) {
            estado.notificarEstado(this);
        }
    }

    public void notificarUsuario(String mensaje, Usuario usuario){
        medioNotificador.notificarUsuario(mensaje, usuario);
    }

    public void generarDetalle() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
        }
        detalle = new DetallePedido(total, cliente.getCupon(), cliente);
    }

    public void generarFactura(){
        Factura factura = new Factura(detalle.getTotal(), this);
        this.factura = factura;
    }


}