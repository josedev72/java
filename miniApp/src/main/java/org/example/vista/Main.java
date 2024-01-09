package org.example.vista;

import java.util.List;
import java.util.Scanner;
import org.example.controlador.AlumnoController;
import org.example.modelo.Alumno;

public class Main {
    public static void main(String[] args) {

        AlumnoController controladora = new AlumnoController();

        long id = 0;
        long contador = 0;
        Alumno alu;

        // Inicio de Menú
        Scanner scanner = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);
        String pausa = "";
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Eligió salir !!!");
                    break;
                case 1:
                    System.out.print("\nIngrese nombre de Alumno: ");
                    String nombre = datos.nextLine();
                    alu = new Alumno();
                    alu = controladora.crearAlumno(nombre);
                    break;
                case 2:
                    System.out.print("\nIngrese id de Alumno a mostrar: ");
                    id = scanner.nextInt();
                    Alumno alumnoObtenido = controladora.obtenerAlumno(id);
                    System.out.print("Alumno con id = " + id + ": " + alumnoObtenido);

                    break;
                case 3:
                    System.out.println("\nFalta implementar Mostrar Alumnos...");
                    List<Alumno> listaAlumnos = controladora.listarAlumnos();
                    contador =1;
                    for (Alumno a : listaAlumnos){
                        System.out.print(a + ";  ");
                        contador++;
                        if((contador % 3) == 0){
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    //System.out.println("\nFalta implementar Editar Alumno...");

                    System.out.print("\nIngrese id de Alumno a editar: ");
                    id = datos.nextInt();
                    System.out.print("\nIngrese nombre de Alumno: ");
                    nombre = datos.nextLine();
                    nombre = datos.nextLine();

                    alu = new Alumno();
                    alu = controladora.actualizarAlumno(id, nombre);
                    System.out.println("alu = " + alu);

                    break;
                case 5:
                    System.out.print("\nIngrese id de Alumno a eliminar: ");
                    id = scanner.nextInt();
                    if(controladora.eliminarAlumno(id)) {
                        System.out.print("Alumno con id = " + id + " fue eliminado !!!");
                    }
                    else{
                        System.out.print("El Alumno con id = " + id + " no existe o no es posible eliminar !!!");
                    }
                    break;
                default:
                    System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            // Esperar a que el usuario presione Enter
            System.out.print("\n\nPresione Enter para continuar...");
            scanner.nextLine(); // Leer la línea en blanco (Enter)
            scanner.nextLine(); // Esperar a que el usuario presione Enter nuevamente
        } while (opcion != 0);

        scanner.close();
        datos.close();
        // Fin Menú

    }

    private static void mostrarMenu() {
        System.out.println("------------");
        System.out.println("    Menú");
        System.out.println("------------");
        System.out.println("1. Agregar Alumno");
        System.out.println("2. Mostrar Alumno por id");
        System.out.println("3. Mostrar Alumnos");
        System.out.println("4. Editar Alumno");
        System.out.println("5. Eliminar Alumno");
        System.out.println("0. Salir");
        System.out.print("Ingrese opción: ");
    }
}