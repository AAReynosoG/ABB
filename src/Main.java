import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        int valor;
        ArbolBinarioBusqueda ABB = new ArbolBinarioBusqueda();

        do{
            System.out.println("\n==================================");
            System.out.println("           Menú de Opciones");
            System.out.println("==================================");
            System.out.println("1. Borrar Árbol.");
            System.out.println("2. Mostrar Árbol.");
            System.out.println("3. Buscar.");
            System.out.println("4. Insertar.");
            System.out.println("5. Eliminar número.");
            System.out.println("6. Modificar.");
            System.out.println("7. Creditos.");
            System.out.println("8. Salir.");
            System.out.println("==================================\n");
            System.out.print("Selecciona una opción: ");

            input = scanner.nextLine();

            switch (input){
                case "1":
                    ABB.BorrarArbol();
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "2":
                    ABB.mostrarArbol();
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("Ingresa el valor que deseas buscar en el ABB: ");
                    valor = scanner.nextInt();
                    ABB.BuscarMostrar(valor);
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Ingresa los valores que deseas insertar en el ABB: ");
                    valor = scanner.nextInt();
                    ABB.raiz = ABB.insertar(ABB.raiz, valor);
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println("Ingresa el valor que deseas eliminar del ABB: ");
                    valor = scanner.nextInt();
                    ABB.raiz = ABB.Eliminar(valor);
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "6":
                    System.out.println("Ingresa el valor que deseas modificar del ABB: ");
                    valor = scanner.nextInt();
                    ABB.Modificar(valor);
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "7":
                    Creditos.Creditos();
                    System.out.println("Presiona 'Enter' para continuar...");
                    scanner.nextLine();
                    break;
                case "8":
                    System.out.println("Chau!");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        }while (!input.equals("8"));
        scanner.close();

    }
}