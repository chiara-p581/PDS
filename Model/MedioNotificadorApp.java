
public class MedioNotificadorApp extends MedioNotificador{


    public void notificarUsuario(String mensaje, Usuario usuario) {
        System.out.println("Enviando APP notification a " + usuario.getEmail() + ": " + mensaje);
    }
}
