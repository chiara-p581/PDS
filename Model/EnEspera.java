public class EnEspera extends Estado {

    public EnEspera() {
        this.nombre = "En espera";
        System.out.println("⏳ Estado inicial: El pedido está actualmente *En espera*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("🔄 Intentando avanzar el estado del pedido ID: " + pedido.getId());

        if (pedido.getDetalle().getPago()) {
            pedido.setEstado(new EnPreparacion());
            System.out.println("✅ El pedido pasó de 'En espera' a 'En preparación'.");
        } else {
            System.out.println("⚠️ No se puede avanzar el estado.");
            System.out.println("💳 El pago aún no fue aprobado. El pedido sigue *En espera*.");
        }
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("📢 Notificando al cliente que el pedido está *En espera*...");
        pedido.notificarCliente("Su pedido está en espera.");
    }
}
