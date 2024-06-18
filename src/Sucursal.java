import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Sucursal {

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void altaCliente() {
        String dni = Utilidades.leerString("DNI");
        Cliente cliente = buscarCliente(dni);
        if (cliente == null) {
            String nombre = Utilidades.leerString("nombre del cliente");
            String apellido = Utilidades.leerString("apellido");
            cliente = new Cliente(nombre, apellido, dni);
            clientes.add(cliente);
            System.out.println("Alta realizada correctamente");
        } else {
            System.out.println("Ese cliente ya existe");
        }
    }

    public static void bajaCliente(Cliente cliente) {
        String confirmacion = Utilidades.leerString("BORRAR para confirmar baja del cliente");
        if (confirmacion.equals("BORRAR")) {
            clientes.remove(cliente);
            System.out.println("Baja realizada correctamente");
        } else {
            System.out.println("No es válido");
        }
    }

    public static void gestionCliente() {
        String dni = Utilidades.leerString("dni del cliente");
        Cliente cliente = buscarCliente(dni);
        boolean salir = false;
        if (cliente != null) {
            while (!salir) {
                salir = cliente.menuCliente();
            }
        } else {
            System.out.println("No existe ese cliente");
        }
    }

    public static void listaClientesPorEfectivo() {
        if (!clientes.isEmpty()) {
            Collections.sort(clientes, Comparator.comparing(Cliente::getEfectivoTotal).reversed());
            System.out.println("Lista de clientes según efectivo:");
            for (Cliente it : clientes) {
                System.out.println(
                        "- " + it.getNombre() + " " + it.getApellido() + " Efectivo total: " + it.getEfectivoTotal());
            }
        } else {
            System.out.println("No hay clientes dados de alta");
        }
    }

    public static Cliente buscarCliente(String dni) {
        for (Cliente it : clientes) {
            if (it.getDni().equals(dni)) {
                return it;
            }
        }
        return null;
    }
}