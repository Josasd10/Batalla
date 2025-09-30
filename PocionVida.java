public class PocionVida extends Item {
    private int curacion;
    public PocionVida(int curacion) { super("Poción de Vida"); this.curacion = curacion; }

    @Override public void usar(Jugador usuario, Combatiente objetivo) {
        if (objetivo.estaVivo()) {
            objetivo.vida += curacion;
            System.out.println(usuario.getNombre() + " usó " + nombre + " en " + objetivo.getNombre() + " curando " + curacion);
        }
    }
}
