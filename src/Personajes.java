public abstract class Personajes {

    public enum Razas{
        HUMANO,ELFO,ENANO,ORCO
    }

    private String nombre;
    private Razas raza;
    private int fuerza;

    private int inteligencia;
    private int puntosVidaMax;
    private int puntosVida;

    public Personajes(String nombre, Razas raza, int fuerza, int puntosVidaMax, int puntosVida) {
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = 0;
        this.inteligencia = 0;
        this.puntosVidaMax = 100;
        this.puntosVida = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws ErrorJuegoException {
        this.inteligencia = inteligencia;
    }

    public int getPuntosVidaMax() {
        return puntosVidaMax;
    }

    public void setPuntosVidaMax(int puntosVidaMax) {
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
