public class Email {
    public void notificarUsuario(String mensaje, Usuario usuario) {
        System.out.println("Enviando EMAIL a " + usuario.getEmail() + ": " + mensaje);
    }
}
