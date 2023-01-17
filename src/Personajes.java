public abstract class Personajes {

    public static final int FUERZA_MAX = 20;
    public static final int FUERZA_MIN = 0;
    public static final int INTELIGENCIA_MAX = 20;
    public static final int INTELIGENCIA_MIN = 0;
    public static final int PUNTOS_VIDA_MAX = 100;
    public static final int PUNTOS_VIDA_MIN = 0;

    public enum Razas{
        HUMANO,ELFO,ENANO,ORCO
    }

    private String nombre;
    private Razas raza;
    private int fuerza;

    private int inteligencia;
    private int puntosVidaMax;
    private int puntosVida;

    public Personajes(String nombre, Razas raza, int fuerza, int puntosVidaMax, int inteligencia) throws ErrorJuegoException {
        this.nombre = nombre;
        this.raza = raza;
        this.setFuerza(fuerza);
        this.setInteligencia(inteligencia);
        this.setPuntosVidaMax(puntosVidaMax);
        this.puntosVida = puntosVidaMax;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ErrorJuegoException {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new ErrorJuegoException("El nombre no puede ser nulo o en blanco (con espacios)");
        }
        this.nombre = nombre;
    }

    public Razas getRaza() {
        return raza;
    }

    public void setRaza(Razas raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws ErrorJuegoException {
        if(fuerza < FUERZA_MIN || fuerza >  FUERZA_MAX){
            throw new ErrorJuegoException("La fuerza no puede ser un valor menor a 0 ni mayor a 20. ");
        }
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws ErrorJuegoException {
        if(inteligencia < INTELIGENCIA_MIN || inteligencia > INTELIGENCIA_MAX){
            throw new ErrorJuegoException("La fuerza no puede ser un valor menor a 0 ni mayor a 20. ");
        }
        this.inteligencia = inteligencia;
    }

    public int getPuntosVidaMax() {
        return puntosVidaMax;
    }

    public void setPuntosVidaMax(int puntosVidaMax) throws ErrorJuegoException {
        if(puntosVida < PUNTOS_VIDA_MIN || puntosVida > PUNTOS_VIDA_MAX){
            throw new ErrorJuegoException("La vida no puede ser un valor menor a 0 ni mayor a 100. ");
        }
        this.puntosVidaMax = puntosVidaMax;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {

        this.puntosVida = puntosVida;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", puntosVidaMax=" + puntosVidaMax +
                ", puntosVida=" + puntosVida +
                '}';
    }
}
