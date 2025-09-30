public class Batalla {
    private Jugador jugador;
    private Combatiente[] enemigos;

    public Batalla(Jugador jugador, Combatiente[] enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public void iniciar() {
        System.out.println(jugador.mensajeInicio());
        for (Combatiente e : enemigos) System.out.println(e.mensajeInicio());

        while (jugador.estaVivo() && hayEnemigosVivos()) {
            Vista.mostrarEstado(jugador, enemigos);
            Vista.menuTurnoJugador(jugador, enemigos);

            for (Combatiente e : enemigos) if (e.estaVivo()) e.turno(enemigos, new Combatiente[]{jugador});
        }

        if (jugador.estaVivo()) System.out.println("¡Ganaste la batalla!");
        else System.out.println(jugador.mensajeMuerte());
    }

    private boolean hayEnemigosVivos() {
        for (Combatiente e : enemigos) if (e.estaVivo()) return true;
        return false;
    }
}
