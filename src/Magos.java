import javax.swing.plaf.PanelUI;
import java.util.Arrays;

public class Magos extends Personajes {

    public final int INTELIGENCIA_MIN = 17;
    public final int FUERZA_MAX = 15;
    public final int NUM_MAX_HECHIZO = 4;
    private String[] hechizos;
    public final int DAYO_JUGADOR = 10;

    public Magos(String nombre, Razas raza, int fuerza, int puntosVidaMax, int inteligencia) throws ErrorJuegoException {
        super(nombre, raza, fuerza, puntosVidaMax, inteligencia);
        this.hechizos = new String[NUM_MAX_HECHIZO];
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
        boolean aprendido = false;
        for (int i = 0; i < hechizos.length & !aprendido; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = hechizo;
                aprendido = true;
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

        boolean encontrado = false;
        int numeroHechizo = 0;

        for (int i = 0; i < hechizos.length & !encontrado; i++) {
            if (hechizos[i].equals(hechizo)) {
                if(personaje.getPuntosVida() > PUNTOS_VIDA_MIN) {
                    personaje.setPuntosVida(getPuntosVida() - DAYO_JUGADOR);
                    hechizos[i] = null;
                    encontrado = true;
                }else {
                    personaje.setPuntosVida(PUNTOS_VIDA_MIN);
                }
            }
        }
        return personaje;
    }

    @Override
    public String toString() {
        return "Magos{" +
                "hechizos=" + Arrays.toString(hechizos) +
                "} " + super.toString();
    }

}
