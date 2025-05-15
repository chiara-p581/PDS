public class Email extends MedioNotificador {

    @Override
    public void notificar(String mensaje, Cliente cliente) {
        System.out.println("Enviando EMAIL a " + cliente.getNombre() + ": " + mensaje);
    }
}
