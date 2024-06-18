import java.util.Scanner;

public class App {
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean salir = false;
        while (!salir) {
            salir = menuPrincipal();
        }
    }

    public static boolean menuPrincipal() {

        System.out.println("-- Menú Principal --");
        System.out.println("1. Alta cliente");
        System.out.println("2. Gestión cliente");
        System.out.println("3. Lista de clientes según efectivo total");
        System.out.println("9. Salir");
        int opcion = Utilidades.leerEntero("la opción deseada");

        switch (opcion) {
            case 1:
                Sucursal.altaCliente();
                break;

            case 2:
                Sucursal.gestionCliente();
                break;

            case 3:
                Sucursal.listaClientesPorEfectivo();

            case 9:
                System.out.println("Hasta pronto");
                return true;

            default:
                System.out.println("No existe esa opción");
                break;
        }

        return false;
    }
}