public class Cliente {

    private Integer id;
    private String nombre;
    private MedioNotificador medioPreferido;
    private Cupon cupon;
    private MedioPago medioPago;
    private double saldoEnCuenta;

    public Cliente(Integer id, String nombre, MedioNotificador medioPreferido, Cupon cupon, MedioPago medioPago, double saldoEnCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.medioPreferido = medioPreferido;
        this.cupon = cupon;
        this.medioPago = medioPago;
        this.saldoEnCuenta = saldoEnCuenta;
    }

    public Cliente(Integer id, String nombre, MedioNotificador medioPreferido, MedioPago medioPago, double saldoEnCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.medioPreferido = medioPreferido;
        this.medioPago = medioPago;
        this.cupon = null;
        this.saldoEnCuenta = saldoEnCuenta;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Cupon getCupon() {
        return this.cupon;
    }

    public MedioNotificador getMedioPreferido() {
        return this.medioPreferido;
    }

    public void recibirNotificacion(String mensaje) {
        if (medioPreferido != null) {
            medioPreferido.notificar(mensaje, this);
            return;
        }
        System.out.println("[Cliente " + nombre + "]: " + mensaje);
    }

    public MedioPago getMedioPago() {
        return this.medioPago;
    }

    public boolean pagar(double monto) {
        return medioPago.procesarPago(monto, saldoEnCuenta);
    }

    public void hacerPedido() {
        // TODO implement here
    }

}