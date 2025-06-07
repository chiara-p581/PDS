public class EnEspera extends Estado {

    public EnEspera() {
        this.nombre = "En espera";
        System.out.println("⏳ Estado inicial: El pedido está actualmente En espera.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("🔄 Intentando avanzar el estado del pedido ID: " + pedido.getId());

        if (pedido.getDetalle().getPago()) {
            pedido.setEstado(new EnPreparacion());
            System.out.println("✅ El pedido pasó de 'En espera' a 'En preparación'.");
        } else {
            System.out.println("⚠️ No se puede avanzar el estado.");
            System.out.println("💳 El pago aún no fue aprobado. El pedido sigue En espera.");
        }
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente que el pedido está En espera...");
        pedido.notificarUsuario("Su pedido está en espera con un tiempo estimado de " + pedido.getEspera() + "minutos", pedido.getCliente());
    }

    public void cancelarPedido(Pedido pedido) {
        System.out.println("🛑 Cancelando pedido ID: " + pedido.getId() + " en estado 'En espera'...");

        // Cambiar el estado a Cancelado
        pedido.setEstado(new Cancelado());

        // Notificar al cliente
        pedido.notificarUsuario("Su pedido fue cancelado.", pedido.getCliente());

        // Reembolsar si corresponde
        if (pedido.getDetalle().getPago()) {
            System.out.println("💸 Procesando reembolso...");
            // Acá podrías tener lógica real de reembolso si estás integrado a una pasarela de pago
        } else {
            System.out.println("ℹ️ No se necesita reembolso ya que el pago no fue realizado.");
        }
    }
}