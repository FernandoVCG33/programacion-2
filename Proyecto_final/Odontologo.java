public class Odontologo extends Persona{
    private String email;
    private String contasenia;

    public Odontologo(String nombre, String ci, int edad, String email, String contasenia) {
        super(nombre, ci, edad);
        this.email = email;
        this.contasenia = contasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContasenia() {
        return contasenia;
    }

    public void setContasenia(String contasenia) {
        this.contasenia = contasenia;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "email='" + email + '\'' +
                ", contasenia='" + contasenia + '\'' +
                '}';
    }
}
