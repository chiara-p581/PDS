public class Usuario {
    private String nombre;
    private String email;
    private int id;

    public Usuario(String nombre, String email) {
        this.nombre = "";
        this.id = id;
        this.email = "";
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
}
