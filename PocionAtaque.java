public class PocionAtaque extends Item {
    private int bonus;
    public PocionAtaque(int bonus) { super("Poción de Ataque"); this.bonus = bonus; }

    @Override public void usar(Jugador usuario, Combatiente objetivo) {
        System.out.println(usuario.getNombre() + " usó " + nombre + " sobre " + objetivo.getNombre() + ", +" + bonus + " ataque por 1 turno.");
        objetivo.ataque += bonus;
    }
}