
import java.io.*;
import java.util.*;

public class Pedido {

    private Integer id;
    private Cliente cliente;
    private Mesero mesero;
    private List<Producto> productos;
    private Estado estado;
    private DetallePedido detalle;

    public Pedido(Integer id, Cliente cliente, Mesero mesero, List<Producto> productos, Estado estado, DetallePedido detalle) {
        this.id = id;
        this.cliente = cliente;
        this.mesero = mesero;
        this.productos = productos;
        this.estado = estado;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void notificarCambioEstado() {
        if (estado != null) {
            estado.notificarEstado(this);
        }
    }

    public void generarDetalleYPagar() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
        }
        detalle = new DetallePedido(total, cliente.getCupon());

    }

}