
public class MedioNotificadorTotem extends MedioNotificador{


    public void notificarUsuario(String mensaje, Usuario usuario) {
        System.out.println("Enviando Totem notification a " + usuario.getEmail() + ": " + mensaje);
    }
}
