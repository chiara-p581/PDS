public class AdapterEmail extends MedioNotificador {
    private Email email;

    public AdapterEmail(Email email) {
        this.email = email;
    }

    @Override
    public void notificarUsuario(String mensaje, Usuario usuario) {
        email.notificarUsuario(mensaje, usuario);
    }
}