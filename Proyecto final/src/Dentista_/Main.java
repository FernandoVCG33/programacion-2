package Dentista_;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Creamos un paciente de prueba
        Persona paciente = new Paciente("Joel", "15756", "Masculino", 25 , "Dolor en la muela A2", "Dientes rotos");

        // Creamos un odontólogo y lo autenticamos
        Odontologo od = new Odontologo("Rafael", "4542","Masculino", 45, "rafa_15", 45424);

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
