
public class MedioNotificadorTotem implements MedioNotificador{

    private MedioNotificador adapter;

    public MedioNotificadorTotem() {
        this.adapter = new AdapterMedioNotificadorTotem(); // Usa el adapter como backend
    }

    public void notificarUsuario(String mensaje, Usuario usuario) {
        System.out.println("Enviando Totem notification a " + usuario.getEmail() + ": " + mensaje);
    }
}
