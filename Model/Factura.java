public class Factura {
    private double totalFinal;
    private Pedido pedido;

    public Factura(double totalFinal, Pedido pedido) {
        this.totalFinal = totalFinal;
        this.pedido = pedido;
    }

    public void enviarFactura(){
        pedido.getCliente().getMedioPreferido().notificar(toString(), pedido.getCliente());
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public Pedido getPedido() {
        return pedido;
    }



    @Override
    public String toString() {
        return "Factura{" +
                "totalFinal=" + totalFinal +
                ", pedido=" + pedido.getId() +
                '}';
    }
}
