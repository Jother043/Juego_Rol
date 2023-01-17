import EntradaSalida.Lectora;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {


        int opciones;
        do {
            System.out.println(menu());
            opciones = Lectora.leerEnteroDeRango("Introduce la opción deseada. ", 5, 0);
            opciones(opciones);
        } while (opciones != 7);

        Personajes.Razas razas;
        String raza = Lectora.solicitarCadenaMayus("Introduce la raza");
        String Hechizo = "hola";
        razas = Personajes.Razas.valueOf(raza);
        Magos magoA;
        try {
            magoA = new Magos("juan", razas, 11, 100, 17);
        } catch (ErrorJuegoException e) {
            throw new RuntimeException(e);
        }
        Magos magoB;
        try {
            magoB = new Magos("jose", razas, 11, 100, 17);
        } catch (ErrorJuegoException e) {
            throw new RuntimeException(e);
        }
        Clerigos clerigo;
        try {
            clerigo = new Clerigos("jose", razas, 18, 100, 15, "Geova");
        } catch (ErrorJuegoException e) {
            throw new RuntimeException(e);
        }

        try {
            magoA.setHechizos(Hechizo);
        } catch (ErrorJuegoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(magoA);

        try {
            magoA.lanzaHechizo(magoB, Hechizo);
        } catch (ErrorJuegoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(magoB);

        clerigo.curar(magoB);

        System.out.println(magoB);
    }

    public static void opciones(int opciones) {
        switch (opciones) {
            case 1:
                try {
                    altaPersonajes();
                } catch (ErrorJuegoException e) {
                    System.err.println("Error. No se ha podido dar de alta el personaje");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    public static void altaPersonajes() throws ErrorJuegoException {

        /*
        Introducimos el tipo de personaje y verificamos que solo se pueda introducir magos y clérigos.
        Esto lo conseguimos con if (tipoPersonaje.equals("mago") || tipoPersonaje.equals("clérigo")).
         */
        boolean correcto = false;
        String tipoPersonaje;
        while (!correcto) {
            tipoPersonaje = Lectora.solicitarCadenaMinus("Introduce que personaje quieres crear [ Mago o Clérigo ]. ");
            if (tipoPersonaje.equals("mago") || tipoPersonaje.equals("clerigo")){
                correcto = true;
            }else{
                throw new ErrorJuegoException("El tipo introducido no coincide con los existentes. ");
            }
        }
        /*
        Le pedimos al usuario que introduzca el nombre del personaje y le verificamos que no sea nulo ni espacios solos.
         */
        correcto = false;
        String nombre;
        while (!correcto) {
            try {
                nombre = Lectora.solicitarCadenaMinus("Introduce el nombre del personaje. ");
                if (!(nombre == null || nombre.trim().isEmpty())) {
                    correcto = true;
                } else {
                    throw new ErrorJuegoException();
                }
            }catch (ErrorJuegoException e){
                System.err.println("Error. No puedes dejar el campo nombre en blanco. ");
            }
        }

        correcto = false;
        String raza;
        Personajes.Razas razas;
        while (!correcto) {
            try {
                raza = Lectora.solicitarCadenaMayus("Introduce la raza del personaje. " + Arrays.toString(Personajes.Razas.values()));
                if (!(raza == null || raza.trim().isEmpty())) {
                    razas = Personajes.Razas.valueOf(raza);
                    correcto = true;
                }

            }catch (IllegalArgumentException e){
                System.err.println("Error. No existe la raza seleccionada. ");
            }
        }


    }

    public static String menu() {
        StringBuilder string = new StringBuilder();
        string.append("Elige una opción: ").append("\n");
        string.append("1. Alta de personaje. ").append("\n");
        string.append("2. Mago aprende hechizo. ").append("\n");
        string.append("3. Mago lanza hechizo. ").append("\n");
        string.append("4. Clérigo cura mago. ").append("\n");
        string.append("5. Lista de personajes. ").append("\n");
        string.append("6. Lista personajes por puntos actuales. ").append("\n");
        string.append("7. Salir. ");
        return string.toString();
    }


}
