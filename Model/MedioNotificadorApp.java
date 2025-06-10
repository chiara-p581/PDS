
public class MedioNotificadorApp implements MedioNotificador{


    public void notificarUsuario(String mensaje, Usuario usuario) {
        System.out.println("");
        System.out.println("Enviando APP notification a " + usuario.getNombre() + ": " + mensaje);
        System.out.println("");
    }
}
