import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public abstract class Pedido {

    private Integer id;
    private Cliente cliente;
    private Mesero mesero;
    private List<Producto> productos;
    private Estado estado;
    private DetallePedido detalle;
    private Factura factura;
    private LocalDateTime horario;
    private int espera;
    private MedioNotificador medioNotificador;

    public Pedido(Cliente cliente, Mesero mesero, List<Producto> productos) {
        this.cliente = cliente;
        this.mesero = mesero;
        this.productos = productos;
        this.estado = new EnEspera();
    }

    public Pedido(Cliente cliente, List<Producto> productos, Estado estado) {
        this.cliente = cliente;
        this.productos = productos;
        this.estado = estado;
        this.mesero = null;
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

    public Mesero getMesero() {
        return mesero;
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

    public LocalDateTime getHorario() {return horario;}

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setEspera(int espera) {
        this.espera = espera;
    }

    public int getEspera() {
        return espera;
    }

    public void notificarCambioEstado() {
        if (estado != null) {
            estado.notificarEstado(this);
        }
    }

    public abstract void notificarUsuario(String mensaje, Usuario usuario);

    public void notificarMesero(String mensaje){
        mesero.recibirNotificacion(mensaje);
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