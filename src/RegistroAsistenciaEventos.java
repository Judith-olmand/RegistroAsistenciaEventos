/*Nombre, apellidos
* Email
*
* Funcionalidad:
* - Registrar asistentes
* - Buscar asistente (por email)
* - Mostrar número de asistentes
* - Mostrar listado completo de asistentes (emails)*/

import java.util.*;
import java.lang.*;

public class RegistroAsistenciaEventos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Asistente> asistentes = new HashSet<>();

        String nombre;
        String apellido;
        String email;
        int opcion;

        do {
            System.out.println("Elige una opción.");
            System.out.println("1. Registrar asistente.");
            System.out.println("2. Buscar asistente (por email).");
            System.out.println("3. Mostrar número de asistentes.");
            System.out.println("4. Mostrar listado completo de asistentes (emails).");
            System.out.println("0. Salir.");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo.");
                    break;
                case 1:
                    System.out.println("Indica un nombre.");
                    nombre = sc.nextLine();
                    System.out.println("Indica los apellidos.");
                    apellido = sc.nextLine();
                    System.out.println("Indica el email.");
                    email = sc.nextLine();
                    Asistente a = new Asistente(nombre, apellido, email);
                    if (asistentes.add(a)) {
                        System.out.println("Asistente registrado correctamente.");

                    } else {
                        System.out.println("El asistente ya está registrado.");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Indica el email a buscar.");
                    email = sc.nextLine();
                    boolean encontrado = false;
                    for (Asistente a1 : asistentes) {
                        if (a1.getEmail().equals(email)) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado == true) {
                        System.out.println("Email encontrado");
                    } else  {
                        System.out.println("Email no encontrado");
                    }
                    break;
                case 3:
                    System.out.println(asistentes.size());
                    break;
                case 4:
                    if (asistentes.isEmpty()) {
                        System.out.println("No hay asistentes registrados.");
                    } else {
                        for(Asistente a1 : asistentes) {
                            System.out.println(a1.getEmail());
                        }
                    }
                    System.out.println();
                    break;
            }
        } while (opcion != 0);
    }
}