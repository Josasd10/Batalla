public class Guerrero extends Jugador {
    public Guerrero(String nombre) {
        super(nombre, 120, 50);
        inventario.add(new PocionVida(30));
        inventario.add(new PocionAtaque(20));
    }

    @Override public void turno(Combatiente[] enemigos, Combatiente[] aliados) { }
    @Override public String mensajeInicio() { return nombre + " entra como Guerrero."; }
    @Override public String mensajeMuerte() { return nombre + " ha caído en combate."; }
}
