public class ListoParaEntregar extends Estado {

    public ListoParaEntregar() {
        this.nombre = "Listo para entregar";
        System.out.println("📦 Estado actual: *Listo para entregar*.");
    }

    @Override
    public void avanzarEstado(Pedido pedido) {
        System.out.println("⚠️ El pedido ID: " + pedido.getId() + " ya está listo para entregar. No puede avanzar más desde aquí.");
    }

    @Override
    public void notificarEstado(Pedido pedido) {
        System.out.println("");
        System.out.println("📢 Notificando al cliente y al mesero que el pedido está *listo para entregar*...");
        pedido.notificarUsuario("Pedido está listo para entregar.", pedido.getCliente());
        System.out.println("");

        if (pedido instanceof PedidoApp pa) {
            pa.notificarUsuario("El pedido #" + pedido.getId() + " está listo para entregar.", pa.getMesero());

            if (pa.isDelivery()) {
                // Usar AdapterRappi para obtener tiempo
                AdapterRappi adapterRappi = new AdapterRappi();
                int tiempo = adapterRappi.getTiempoEstimado();
                System.out.println("⏱️ Tiempo estimado de entrega vía Rappi: " + tiempo + " minutos.");
            } else {
                System.out.println("🏃 Entrega en mesa: tiempo estimado es inmediato.");
            }
            System.out.println("");
        }
    }
}
