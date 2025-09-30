public class Explorador extends Jugador {
    public Explorador(String nombre) {
        super(nombre, 90, 18);
        inventario.add(new PocionVida(90));
        inventario.add(new PocionAtaque(80));
    }

    @Override public void turno(Combatiente[] enemigos, Combatiente[] aliados) { }
    @Override public String mensajeInicio() { return nombre + " entra como Explorador."; }
    @Override public String mensajeMuerte() { return nombre + " ha sido derrotado."; }
}
