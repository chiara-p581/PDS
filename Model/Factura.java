public class Factura {
    private double totalFinal;
    private Pedido pedido;

    public Factura(double totalFinal, Pedido pedido) {
        this.totalFinal = totalFinal;
        this.pedido = pedido;

        System.out.println("========================================");
        System.out.println("🧾 Factura generada:");
        System.out.println("🆔 Pedido ID: " + pedido.getId());
        System.out.println("👤 Cliente: " + pedido.getCliente().getNombre());
        System.out.println("💰 Total final a pagar: $" + totalFinal);
        System.out.println("========================================");
    }

    public void enviarFactura() {
        System.out.println("📬 Enviando factura al cliente " + pedido.getCliente().getNombre() + " mediante su medio preferido...");
        pedido.notificarUsuario(toString(), pedido.getCliente());
        System.out.println("✅ Factura enviada con éxito.");
        System.out.println("========================================");
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    @Override
    public String toString() {
        return "🧾 Factura{" +
                "Total final = $" + totalFinal +
                ", Pedido ID = " + pedido.getId() +
                '}';
    }
}
