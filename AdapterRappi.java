public class AdapterRappi {

    private Rappi rappi;

    public AdapterRappi() {
        this.rappi = new Rappi();
    }

    public int getTiempoEstimado() {
        return rappi.obtenerTiempoEstimado();
    }

}
