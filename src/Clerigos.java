public class Clerigos extends Personajes{

    public final int INTELIGENCIA_MIN = 12;
    public final int INTELIGENCIA_MAX = 16;
    public final int FUERZA_MIN = 18;
    public final int PUNTOS_CURACON = 10;
    private String dios;

    public Clerigos(String nombre, Razas raza, int fuerza, int puntosVidaMax, int inteligencia, String dios) throws ErrorJuegoException {
        super(nombre, raza, fuerza, puntosVidaMax, inteligencia);
        this.setDios(dios);
    }

    public String getDios() {
        return dios;
    }

    public void setDios(String dios) throws ErrorJuegoException {
        if(dios == null || dios.trim().isEmpty()){
            throw new ErrorJuegoException("Tienes que rezarle a un dios. ");
        }
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

    public Personajes curar(Personajes personajeCurado){
        if(getDios().length() != 0 || getDios().trim().isEmpty()){
            personajeCurado.setPuntosVida(getPuntosVida() + PUNTOS_CURACON);
        }
        return personajeCurado;
    }




}
