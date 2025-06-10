public class AdapterMedioNotificadorTotem implements MedioNotificador {
    private Email emailService;

    public AdapterMedioNotificadorTotem() {
        this.emailService = new Email();
    }

    @Override
    public void notificarUsuario(String mensaje, Usuario usuario) {
        emailService.notificarUsuario(mensaje, usuario.getEmail());
    }
}
