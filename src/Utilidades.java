public class Utilidades {

    public static int leerEntero(String dato) {
        while (true) {
            try {
                System.out.println("Escriba " + dato + ":");
                String datoLeido = App.lector.nextLine();
                int entero = Integer.parseInt(datoLeido);
                return entero;
            } catch (Exception e) {
                System.out.println("Valor inválido");
            }
        }
    }

    public static float leerFloat(String dato) {
        while (true) {
            try {
                System.out.println("Escriba " + dato + ":");
                String datoLeido = App.lector.nextLine();
                float decimal = Float.parseFloat(datoLeido);
                return decimal;
            } catch (Exception e) {
                System.out.println("Valor inválido");
            }
        }
    }

    public static String leerString(String dato) {
        System.out.println("Escriba " + dato + ":");
        String datoLeido = App.lector.nextLine();
        return datoLeido;
    }
}