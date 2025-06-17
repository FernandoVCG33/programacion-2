package Dentista_;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Creamos un paciente de prueba
        Persona paciente = new Paciente("Rafel", "88545", "Masculino", 25 , "Dolor en la muela A2", "Dientes rotos");

        // Creamos un odontólogo y lo autenticamos
        Odontologo od = new Odontologo("Juan de la torre", "12345","Masculino", 45, "Juan", 45424);

        System.out.println("--- Inicio de Sesión ---");
        if (od.getPassword()==45424) {
        	System.out.println("Bienvenido doc");
        	VentanaLogin frame = new VentanaLogin();
			frame.setVisible(true);
        }
        else {
        	System.out.println("contraseña incorrecta");
        }
	}

}
