public class App extends MedioNotificador{

    @Override
    public void notificar(String mensaje, Cliente cliente) {
        System.out.println("Enviando APP notification a " + cliente.getNombre() + ": " + mensaje);
    }
}
