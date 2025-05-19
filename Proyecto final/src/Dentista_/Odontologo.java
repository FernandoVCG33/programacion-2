package Dentista_;

public class Odontologo extends Persona {
		private String usuario;
		private int password;
		public Odontologo(String nombre, String ci, String sexo, int edad, String usuario, int password) {
			super(nombre, ci, sexo, edad);
			this.usuario = usuario;
			this.password = password;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
		@Override
		public String toString() {
			return "Odontologo [usuario=" + usuario + ", password=" + password + "]";
		}
		
		  public void atenderPaciente(Paciente p) {
		        System.out.println("El odontólogo " + getNombre() +
		            " atendió al paciente " + p.getNombre());
		    }
}
