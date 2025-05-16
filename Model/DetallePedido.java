public class DetallePedido {

    private double total;
    private Cupon cupon;
    private Cliente cliente;
    private boolean pago;

    public DetallePedido(double total, Cupon cupon, Cliente cliente) {
        this.total = total;
        this.cupon = cupon;
    }

    public double getTotal() {
        return total;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public double getTotalConDescuento(){
        if (cupon != null){
            return (100- cupon.getPorcentajeDescuento())/100 * total;
        }
        return total;
    }

    public void pagar(double total){
        pago = cliente.pagar(getTotalConDescuento());
    }


}
