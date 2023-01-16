public class Clerigos extends Personajes{

    public final int INTELIGENCIA_MIN = 12;
    public final int INTELIGENCIA_MAX = 16;
    public final int FUERZA_MIN = 18;
    public final int PUNTOS_CURACON = 10;
    private String dios;

    public Clerigos(String nombre, Razas raza, int fuerza, int puntosVidaMax, int puntosVida, String dios, String[] hechizos) {
        super(nombre, raza, fuerza, puntosVidaMax, puntosVida);
        this.dios = dios;
    }

    @Override
    public void setInteligencia(int inteligencia) throws ErrorJuegoException{
        if (inteligencia < INTELIGENCIA_MIN || inteligencia > INTELIGENCIA_MAX) {
            if(inteligencia < INTELIGENCIA_MIN){
                throw new ErrorJuegoException("Error. La inteligencia del mago no puede ser menos de " + INTELIGENCIA_MIN);
            }else{
                throw new ErrorJuegoException("Error. La inteligencia del mago no puede ser mayor de " + INTELIGENCIA_MAX);
            }

        } else {
            super.setInteligencia(inteligencia);
        }
    }

    @Override
    public void setFuerza(int fuerza) throws ErrorJuegoException {
        if (fuerza < FUERZA_MIN) {
            throw new ErrorJuegoException("Error. La fuerza del mago no puede ser menor de " + FUERZA_MIN);
        } else {
            super.setFuerza(fuerza);
        }
    }


}
