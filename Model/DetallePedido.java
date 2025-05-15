public class DetallePedido {

    private double total;
    private Cupon cupon;

    public DetallePedido(double total, Cupon cupon) {
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
        return total; //en caso de que no haya un cupon, revisar
    }
}
