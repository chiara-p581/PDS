public class Cliente extends Usuario {

    private Integer id;
    private String nombre;
    private Cupon cupon;
    private MedioPago medioPago;
    private double saldoEnCuenta;

    public Cliente(String nombre,MedioPago medioPago, double saldoEnCuenta) {
        this.nombre = nombre;
        this.medioPago = medioPago;
        this.cupon = null;
        this.saldoEnCuenta = saldoEnCuenta;
    }

    public Cliente(String nombre, Cupon cupon, MedioPago medioPago, double saldoEnCuenta) {
        this.nombre = nombre;
        this.cupon = cupon;
        this.medioPago = medioPago;
        this.saldoEnCuenta = saldoEnCuenta;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Cupon getCupon() {
        return this.cupon;
    }

    public MedioPago getMedioPago() {
        return this.medioPago;
    }

    public boolean pagar(double monto) {
        return medioPago.procesarPago(monto, saldoEnCuenta);
    }

}