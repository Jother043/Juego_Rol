import javax.swing.plaf.PanelUI;

public class Magos extends Personajes {

    public final int INTELIGENCIA_MIN = 17;
    public final int FUERZA_MAX = 15;
    public final int NUM_MAX_HECHIZO = 4;
    private String[] hechizos;
    public final int DAYO_JUGADOR = 10;

    public Magos(String nombre, Razas raza, int fuerza, int puntosVidaMax, int puntosVida) {
        super(nombre, raza, fuerza, puntosVidaMax, puntosVida);
        hechizos = new String[NUM_MAX_HECHIZO];
    }

    /**
     * Método en el que controlamos que la inteligencia no sea menor que la inteligencia minima, si es menor
     * lanzamos una excepción.
     *
     * @param inteligencia
     * @throws ErrorJuegoException
     */
    @Override
    public void setInteligencia(int inteligencia) throws ErrorJuegoException {
        if (inteligencia < INTELIGENCIA_MIN) {
            throw new ErrorJuegoException("Error. La inteligencia del mago no puede ser menos de " + INTELIGENCIA_MIN);
        } else {
            super.setInteligencia(inteligencia);
        }
    }

    /**
     * Método en el que controlamos que la fuerza no sea mayor que la fuerza maxima, si es mayor
     * lanzamos una excepción.
     *
     * @param fuerza
     * @throws ErrorJuegoException
     */
    @Override
    public void setFuerza(int fuerza) throws ErrorJuegoException {
        if (fuerza > FUERZA_MAX) {
            throw new ErrorJuegoException("Error. La fuerza del mago no puede ser mayor de " + FUERZA_MAX);
        } else {
            super.setFuerza(fuerza);
        }
    }

    /**
     * Método con el que añadimos un nuevo hechizo a la lista de hechizos del mago.
     * Lo introducimos con un bucle for cuando encuentre el primer null (hueco).
     *
     * @param hechizo
     * @throws ErrorJuegoException
     */
    public void setHechizos(String hechizo) throws ErrorJuegoException {

        if(hechizo == null || hechizo.trim().isEmpty()){
            throw new ErrorJuegoException("No puedes dejar el campo nulo o vacío (espacios). ");
        }

        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = hechizo;
            } else {
                throw new ErrorJuegoException("No hay hueco en el array. ");
            }
        }


    }

    /**
     * Método con el que buscamos un hechizo y atacamos al jugador.
     * Creamos un bucle for para encontrar el hechizo si lo encuentra le resta los puntos al jugador y pone el booleano
     * en true para después si existe le pasamos el número del hechizo para que no lo tengamos que buscar cada vez que
     * quiera eliminar un equipo.
     * @param personaje
     * @param hechizo
     * @return
     * @throws ErrorJuegoException
     */
    public Personajes lanzaHechizo(Personajes personaje, String hechizo) throws ErrorJuegoException {

        boolean aprendido = false;
        int numeroHechizo = 0;

        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i].equals(hechizo)) {
                personaje.setPuntosVida(getPuntosVida() - DAYO_JUGADOR);
                aprendido = true;
                numeroHechizo = i;
            } else {
                throw new ErrorJuegoException("Aun no ha aprendido ese hechizo. ");
            }
        }
        if (aprendido) {
            hechizos[numeroHechizo] = null;
        }

        return personaje;
    }


}
