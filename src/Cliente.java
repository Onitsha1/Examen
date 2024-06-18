import java.util.ArrayList;
import java.util.Random;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<Cuenta> cuentas;
    private float efectivoTotal;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        cuentas = new ArrayList<>();
        efectivoTotal = 0;

    }

    public boolean menuCliente() {

        System.out.println("-- Gestión cliente " + this.nombre + " " + this.apellido + " --");
        System.out.println("1. Alta cuenta");
        System.out.println("2. Gestionar cuenta");
        System.out.println("9. Volver al menú principal");
        int opcion = Utilidades.leerEntero("opción deseada");

        switch (opcion) {
            case 1:
                this.altaCuenta();
                break;

            case 2:
                this.gestionCuenta();
                break;

            case 9:
                App.menuPrincipal();
                return true;
            default:
                System.out.println("No existe esa opción");
                break;
        }
        return false;
    }

    public void altaCuenta() {
        while (true) {
            int numero = generarNumeroCuenta();
            Cuenta cuenta = buscarCuenta(numero);
            if (cuenta == null) {
                cuenta = new Cuenta(this, numero);
                this.cuentas.add(cuenta);
                System.out.println("Cuenta creada con número " + numero);
                return;
            }
        }
    }

    public void gestionCuenta() {
        System.out.println("Cuentas del cliente " + this.nombre + " " + this.apellido + ":");
        for (Cuenta it : this.cuentas) {
            System.out.println("- " + cuentas.indexOf(it) + " " + it.getNumero() + " Saldo: " + it.getSaldo());
        }
        int indiceCuenta = Utilidades.leerEntero("el índice de la cuenta deseada");

        if (!cuentas.isEmpty()) {
            Cuenta cuenta = buscarCuenta(cuentas.get(indiceCuenta).getNumero());

            System.out.println("-- Gestión de cuenta--");
            System.out.println("1. Ingresar efectivo");
            System.out.println("2. Retirar efectivo");
            System.out.println("3. Baja cuenta");
            System.out.println("9. Volver a menú de cliente");
            int opcion = Utilidades.leerEntero("opción deseada");

            switch (opcion) {
                case 1:
                    ingresarEfectivo(cuenta);
                    break;

                case 2:
                    retirarEfectivo(cuenta);
                    break;

                case 3:
                    bajaCuenta(cuenta);
                    break;

                case 9:
                    return;

                default:
                    System.out.println("Esa opción no existe");
                    break;
            }
        } else {
            System.out.println("No existen cuentas");
        }
    }

    public void ingresarEfectivo(Cuenta cuenta) {
        int ingreso = Utilidades.leerEntero("cantidad a ingresar");

        if (ingreso > 0) {
            cuenta.setSaldo(ingreso + cuenta.getSaldo());
            System.out.println("Ingreso realizado correctamente. Nuevo saldo: " + cuenta.getSaldo());
        } else {
            System.out.println("Escriba una cantidad válida");
        }
    }

    public void retirarEfectivo(Cuenta cuenta) {
        int extracto = Utilidades.leerEntero("cantidad a retirar");

        if (extracto > 0 && extracto <= cuenta.getSaldo()) {
            cuenta.setSaldo(cuenta.getSaldo() - extracto);
            System.out.println("Extracto realizado correctamente");

        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void bajaCuenta(Cuenta cuenta) {
        cuentas.remove(cuenta);
        System.out.println("Cuenta eliminada correctamente.");
    }

    public int generarNumeroCuenta() {
        Random random = new Random();

        int min = 100000;
        int max = 200000;
        int numeroCuenta = random.nextInt(max - min + 1) + min;

        return numeroCuenta;
    }

    public Cuenta buscarCuenta(int numero) {
        for (Cuenta it : this.cuentas) {
            if (it.getNumero() == numero) {
                return it;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public float getEfectivoTotal() {
        for (Cuenta it : cuentas) {
            efectivoTotal = efectivoTotal + it.getSaldo();
        }
        return efectivoTotal;
    }
}