package Dentista_;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Creamos un paciente de prueba
        Paciente paciente = new Paciente("Andres", "157896", "Masculino", 20 , "Dolor en la muela B2", "Dientes chuecos");

        // Creamos un odontólogo y lo autenticamos
        Odontologo od = new Odontologo("Rafael", "4542","Masculino", 45, "rafa_15", 45424);

        System.out.println("--- Inicio de Sesión ---");
        if (od.getPassword()==45424) {
        	System.out.println("Bienvenido doc");
        }
        else {
        	System.out.println("contrase;a incorrecta");
        }
	}

}
